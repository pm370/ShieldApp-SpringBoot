package com.pranav.shield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pranav.shield.entity.Notification;
import com.pranav.shield.entity.UserContactDetail;
import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.exception.ContactInfoNotFoundException;
import com.pranav.shield.exception.NameNotFoundException;
import com.pranav.shield.pojo.NotificationPojo;
import com.pranav.shield.repository.NotificationRepository;
import com.pranav.shield.repository.UserContactDetailRepository;
import com.pranav.shield.repository.UserInfoRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepo;

	@Autowired
	private UserInfoRepository userInfoRepo;
	
	@Autowired
	private UserContactDetailRepository userContactDetailRepo;
	
	public void saveNotification(NotificationPojo notificationPojo) {
		Notification notification = new Notification();
		UserInfo userInfo = userInfoRepo.findByName(notificationPojo.getName())
				.orElseThrow(()-> new NameNotFoundException(null));
		notification.setUserInfo(userInfo);
		UserContactDetail userContactDetail=userContactDetailRepo.findByContactInfo(notificationPojo.getContactInfo())
				.orElseThrow(()-> new ContactInfoNotFoundException("Contact Info not found"));
		notification.setUserContactDetail(userContactDetail);
		notification.setMessage(notificationPojo.getMessage());
		System.out.println(notificationPojo.getName()+" @"+notificationPojo.getContactInfo()+" : "+notificationPojo.getMessage());
		notificationRepo.save(notification);
	}
	
	public List<Notification> viewAllNotifications() {
		return notificationRepo.findAll();
	}
	
}
