package com.satya.travelapp.service;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.http.ResponseEntity;

import com.satya.travelapp.wrapper.AppUserWrapper;

public interface UserService {
    ResponseEntity<String> signUp(Map<String, String> requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);

	ResponseEntity<List<AppUserWrapper>> getAllUser();

	ResponseEntity<String> updateAppUser(Map<String,String> requestMap);

	String checkToken();

}
