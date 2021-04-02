package com.pranav.shield.pojo;

import java.util.List;

import com.pranav.shield.entity.Notification;
import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.utils.Enums.NotificationChannels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContactDetailPojo {
	
	private NotificationChannels notificationChannel;	
	
	private String contactInfo;
	
	private String name;
	
//	private List<Notification> notifications;
	
}
