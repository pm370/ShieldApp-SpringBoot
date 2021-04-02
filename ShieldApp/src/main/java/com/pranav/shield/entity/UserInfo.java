package com.pranav.shield.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.view.JsonViews.CommonJsonView;
import com.pranav.shield.view.JsonViews.MissionJsonView;
import com.pranav.shield.view.JsonViews.NotificationJsonView;
import com.pranav.shield.view.JsonViews.UserContactDetailJsonView;
import com.pranav.shield.view.JsonViews.UserPrivilegeJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(CommonJsonView.class)
	private Long id;
	
	@JsonView(CommonJsonView.class)
	private String name;
	
	@JsonIgnore
	private String username;
	
	@JsonIgnore
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_type_id", referencedColumnName = "id")
	@JsonView(UserPrivilegeJsonView.class)
	private UserPrivilege userPrivilege;
	
	@OneToMany(mappedBy = "userInfo")
	@JsonView(UserContactDetailJsonView.class)
	private List<UserContactDetail> userContactDetails;
	
	@OneToMany(mappedBy = "userInfo")
	@JsonView(MissionJsonView.class)
	private List<Mission> missions;
	
	@OneToMany(mappedBy = "userInfo")
	@JsonView(NotificationJsonView.class)
	private List<Notification> notifications;
	
	public void setUserContactDetail(UserContactDetail userContactDetail) {
		if(userContactDetails!=null) {
			userContactDetail.setUserInfo(this);
			userContactDetails.add(userContactDetail);
			return;
		}
		userContactDetails=new ArrayList<>();
		userContactDetail.setUserInfo(this);
		userContactDetails.add(userContactDetail);
		
	}
	
	public void setMission(Mission mission) {
		if(missions!=null) {
			mission.setUserInfo(this);
			missions.add(mission);
			return;
		}
		missions=new ArrayList<>();
		mission.setUserInfo(this);
		missions.add(mission);
	}
	
	public void setNotification(Notification notification) {
		if(notifications!=null) {
			notification.setUserInfo(this);
			notifications.add(notification);
			return;
		}
		notifications=new ArrayList<>();
		notification.setUserInfo(this);
		notifications.add(notification);
	}
	
	
}
