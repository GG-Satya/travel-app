package com.satya.travelapp.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.satya.travelapp.constants.AppConstants;
import com.satya.travelapp.dao.UserDao;
import com.satya.travelapp.entity.AppUser;
import com.satya.travelapp.security.JwtFilter;
import com.satya.travelapp.security.JwtUtil;
import com.satya.travelapp.util.CafeUtils;
import com.satya.travelapp.util.UserUtil;
import com.satya.travelapp.wrapper.AppUserWrapper;


@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDao userDao ;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    CustomerUsersDetailsService customerUsersDetailsService;
    
    @Autowired
    JwtUtil jwtUtil;
    
    @Autowired
    UserUtil userUtil;

    @Autowired
    JwtFilter jwtFilter;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    

    
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup :"+requestMap);
        try {
            if (validateSignup(requestMap)) {
                AppUser userWithEmail = userDao.findByEmail(String.valueOf(requestMap.get("email")));
                AppUser userWithContact = userDao.findByContactNumber(String.valueOf(requestMap.get("contactNumber")));
                if (Objects.isNull(userWithEmail) && Objects.isNull(userWithContact)) {
                    userDao.save(this.getUserFromRequest(requestMap));
                    return CafeUtils.getResponseEntity("Successfully Registered...", HttpStatus.OK);
                }else{
                    return CafeUtils.getResponseEntity("Email OR Contact Number already exists", HttpStatus.BAD_REQUEST);
                }
            } else {
                return CafeUtils.getResponseEntity(AppConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ignored){
            ignored.printStackTrace();
        }
        return CafeUtils.getResponseEntity(AppConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateSignup(Map<String, String> requestMap){
        return requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password");
    }
    private AppUser getUserFromRequest(Map<String, String> requestMap){
        AppUser user = new AppUser();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(passwordEncoder.encode(requestMap.get("password")));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password")));
		
			if(auth.isAuthenticated()) {
				if(customerUsersDetailsService.getUserDetail().getStatus().equalsIgnoreCase("true")) {
					return new ResponseEntity<String>("{\"token\":\""
							+ jwtUtil.generateToken(customerUsersDetailsService.getUserDetail().getEmail(), 
									customerUsersDetailsService.getUserDetail().getRole())+"\"}", 
							HttpStatus.OK);
				}else {
					return new ResponseEntity<String>("{\"message\":\""+"Wait for admin approval."+"\"}",HttpStatus.BAD_REQUEST);
				}
			}
		} catch (Exception e) {
			log.error("{}",e);
		}
		return new ResponseEntity<String>("{\"message\":\""+"Bad Credentials."+"\"}",HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<List<AppUserWrapper>> getAllUser() {
		try {
			if(jwtFilter.isAdmin()) {
				return new ResponseEntity<List<AppUserWrapper>>(userDao.getAllAppUser(),HttpStatus.OK);
			}else {
				return new ResponseEntity<List<AppUserWrapper>>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<AppUserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	public ResponseEntity<String> updateAppUser(Map<String,String> requestMap) {
		try {
			if(jwtFilter.isAdmin()) {
				int userId = Integer.parseInt(requestMap.get("id"));
				String statusToBeUpdated = requestMap.get("status");
				AppUser user = userDao.findById(userId).orElseThrow(() -> new NoSuchElementException("User does't exists with id: "+userId));
				
				//if status is already updated
				if(user.getStatus().equalsIgnoreCase(statusToBeUpdated)) {
					return statusToBeUpdated.equalsIgnoreCase("true") ? ResponseEntity.ok("User is already Enabled"):ResponseEntity.ok("User is already Disabled");
				}
				
				userDao.updateStatus(statusToBeUpdated, userId);
				return ResponseEntity.ok("User Approved:  status updated successfully");
			}else{
				return CafeUtils.getResponseEntity(AppConstants.UNSUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(AppConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	public String checkToken() {
		return "true";
	}
	
}
