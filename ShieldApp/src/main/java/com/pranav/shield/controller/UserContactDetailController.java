package com.pranav.shield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.entity.UserContactDetail;
import com.pranav.shield.pojo.UserContactDetailPojo;
import com.pranav.shield.service.UserContactDetailService;
import com.pranav.shield.view.JsonViews.CommonJsonView;

@RestController
@RequestMapping("/user/contact")
public class UserContactDetailController {

	@Autowired
	private UserContactDetailService userContactDetailService;
	
	@PostMapping("/save")
	public void saveContactDetails(@RequestBody UserContactDetailPojo userContactDetailPojo) {
		userContactDetailService.saveContactDetails(userContactDetailPojo);
	}
	
	@GetMapping("/view/{id}")
	@JsonView(CommonJsonView.class)
	public UserContactDetail viewContactDetailsById(@PathVariable("id") Long id) {
		return userContactDetailService.viewContactDetailsById(id);
	}
	
	@GetMapping("/view/{username}")
	@JsonView(CommonJsonView.class)
	public List<UserContactDetail> viewContactDetailsByUser(@PathVariable("username") String username) {
		return userContactDetailService.viewContactDetailsByUser(username);
	}
	
	@PutMapping("/update/contactInfo/{id}")
	public void updateContactInfo(@RequestBody UserContactDetailPojo userContactDetailPojo, @PathVariable("id") Long id) {
		userContactDetailService.updateContactInfo(userContactDetailPojo,id);
	}
	
	@PutMapping("/update/notificationChannel/{id}")
	public void updateNotificationChannel(@RequestBody UserContactDetailPojo userContactDetailPojo, @PathVariable("id") Long id) {
		userContactDetailService.updateNotificationChannel(userContactDetailPojo,id);
	}
	
	@PutMapping("/update/user/{id}")
	public void updateUserId(@RequestBody UserContactDetailPojo userContactDetailPojo, @PathVariable("id") Long id) {
		userContactDetailService.updateUserId(userContactDetailPojo,id);
	}
	
	@PutMapping("/update/contactDetails/{id}")
	public void updateContactDetails(@RequestBody UserContactDetailPojo userContactDetailPojo, @PathVariable("id") Long id) {
		userContactDetailService.updateContactDetails(userContactDetailPojo,id);
	}
}
