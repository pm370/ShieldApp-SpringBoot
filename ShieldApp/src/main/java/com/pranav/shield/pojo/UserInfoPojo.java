package com.pranav.shield.pojo;

import java.util.List;

import com.pranav.shield.entity.Mission;
import com.pranav.shield.entity.Notification;
import com.pranav.shield.utils.Enums.UserTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoPojo {

	private String name;
	
	private String username;
	
	private String password;
	
	private UserTypes userType;
	
//	private List<UserContactDetailPojo> userContactDetailPojos;
//	
//	private List<Mission> missions;
//	
//	private List<Notification> notifications;
}
