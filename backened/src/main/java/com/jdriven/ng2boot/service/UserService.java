package com.jdriven.ng2boot.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.jdriven.ng2boot.model.User;

public interface UserService {
	public ResponseEntity<String> validateUser(User user) throws IOException;
}
