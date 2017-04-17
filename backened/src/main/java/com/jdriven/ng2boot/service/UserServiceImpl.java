package com.jdriven.ng2boot.service;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jdriven.ng2boot.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public ResponseEntity<String> validateUser(User user) throws IOException {
		// call second service
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new StringHttpMessageConverter());

		HttpEntity<Object> httpEntity = new HttpEntity<Object>(user,
				requestHeaders);
		ResponseEntity<String> out = restTemplate.exchange(
				"http://localhost:9002/api/second/user/", HttpMethod.POST,
				httpEntity, String.class);
		return out;
	}

}
