package com.pranav.shield.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.utils.Enums.NotificationChannels;
import com.pranav.shield.view.JsonViews.CommonJsonView;
import com.pranav.shield.view.JsonViews.NotificationJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserContactDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(CommonJsonView.class)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonView(CommonJsonView.class)
	private UserInfo userInfo;
	
	@Enumerated(EnumType.STRING)
	@JsonView(CommonJsonView.class)
	private NotificationChannels notificationChannel;
	
	@JsonView(CommonJsonView.class)
	private String contactInfo;
	
	@OneToMany(mappedBy = "userContactDetail")
	@JsonView(NotificationJsonView.class)
	private List<Notification> notifications;
	
	public void setNotification(Notification notification) {
		if(notifications!=null) {
			notification.setUserContactDetail(this);
			notifications.add(notification);
			return;
		}
		notifications=new ArrayList<>();
		notification.setUserContactDetail(this);
		notifications.add(notification);
	}
	
}
