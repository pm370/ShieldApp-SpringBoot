package com.pranav.shield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.entity.Notification;
import com.pranav.shield.pojo.NotificationPojo;
import com.pranav.shield.service.NotificationService;
import com.pranav.shield.view.JsonViews.CommonJsonView;
import com.pranav.shield.view.JsonViews.UserContactDetailJsonView;
import com.pranav.shield.view.JsonViews.UserInfoJsonView;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("/save")
	public void saveNotification(@RequestBody NotificationPojo notificationPojo) {
		notificationService.saveNotification(notificationPojo);
	}
	
	@GetMapping("/view/all")
	@JsonView(CommonJsonView.class)
	public List<Notification> viewAllNotifications() {
		return notificationService.viewAllNotifications();
	}
	

} 
