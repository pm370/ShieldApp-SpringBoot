package com.pranav.shield.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.shield.entity.Notification;
import com.pranav.shield.entity.UserContactDetail;
import com.pranav.shield.entity.UserInfo;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

	
	
}
