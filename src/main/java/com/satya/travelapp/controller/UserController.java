package com.satya.travelapp.controller;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.travelapp.constants.AppConstants;
import com.satya.travelapp.service.UserService;
import com.satya.travelapp.util.CafeUtils;
import com.satya.travelapp.wrapper.AppUserWrapper;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap){
        try{
            return userService.signUp(requestMap);
        }catch(Exception e){
        	logger.warn("Getting Error while signup :{}",e.getMessage(),e);
        }
        return CafeUtils.getResponseEntity(AppConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true)Map<String,String> requestMap){
    	try {
			return userService.login(requestMap);
		} catch (Exception e) {
			logger.warn("Getting Error while login :{}",e.getMessage(),e);
		}
		return null;
    }
    
    @GetMapping(path = "/get")
    public ResponseEntity<List<AppUserWrapper>> getAllUser() {
    	try {
			return userService.getAllUser();
		} catch (Exception e) {
			logger.warn("Error while getting all user :{}",e.getMessage(),e);
			e.printStackTrace();
		}
    	return new ResponseEntity<List<AppUserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody(required=true) Map<String,String> requestMap){
		try {
			return userService.updateAppUser(requestMap);
		}catch(Exception e) {
			logger.warn("Error while updating user :{}",e.getMessage(),e);
		}
		return CafeUtils.getResponseEntity(AppConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping(path = "/checkToken")
    public ResponseEntity<String> checkToken(){
		try {
			return ResponseEntity.ok(userService.checkToken());
		}catch (Exception e) {
			logger.warn("Error while checking token :{}",e.getMessage(),e);
		}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppConstants.SOMETHING_WENT_WRONG);
    }
    
   
    
    


}
