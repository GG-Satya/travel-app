package com.satya.travelapp;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.satya.travelapp.dao.UserDao;
import com.satya.travelapp.entity.AppUser;
import com.satya.travelapp.service.UserService;


@SpringBootApplication
public class TravelAppApplication implements CommandLineRunner {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
    {
		AppUser adminUser = new AppUser();
		adminUser.setName("satya");
		adminUser.setEmail("satya@gmail.com");
		adminUser.setPassword(passwordEncoder.encode("satya"));
		adminUser.setRole("admin");
		adminUser.setStatus("true");
		adminUser.setContactNumber("12345");
		
		if(Objects.isNull(userDao.findByEmail(adminUser.getEmail())) && Objects.isNull(userDao.findByContactNumber(adminUser.getContactNumber()))) {
			userDao.save(adminUser);
		}
        
//        Map<String,String> map = new HashMap<>();
//        map.put("name", "satya");
//        map.put("email", "satya@gmail.com");
//        map.put("password", "satya");
//        map.put("role", "admin");
//        map.put("status", "true");
//        map.put("contactNumber", "12345");
//        
//        userService.signUp(map);

//        map = new HashMap<>();
//        map.put("name", "demo");
//        map.put("email", "demo@gmail.com");
//        map.put("password", "demo");
//        map.put("role", "user");
//        map.put("status", "true");
//        map.put("contactNumber", "00000");
//        
//        userService.signUp(map);
        

        AppUser firstUser = new AppUser();
        firstUser.setName("demo");
        firstUser.setEmail("demo@gmail.com");
        firstUser.setPassword(passwordEncoder.encode("demo"));
        firstUser.setRole("user");
        firstUser.setStatus("true");
        firstUser.setContactNumber("00000");
        
        if(Objects.isNull(userDao.findByEmail(firstUser.getEmail())) && Objects.isNull(userDao.findByContactNumber(firstUser.getContactNumber()))) {
			userDao.save(firstUser);
		}
    }
}
