package com.pranav.shield.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.shield.entity.UserContactDetail;
import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.exception.NameNotFoundException;
import com.pranav.shield.pojo.UserContactDetailPojo;
import com.pranav.shield.repository.UserContactDetailRepository;
import com.pranav.shield.repository.UserInfoRepository;
import com.pranav.shield.utils.Enums.NotificationChannels;

@Service
public class UserContactDetailService {

	@Autowired
	private UserContactDetailRepository userContactDetailRepo;

	@Autowired
	private UserInfoRepository userInfoRepo;

	public void saveContactDetails(UserContactDetailPojo userContactDetailPojo) {
		UserContactDetail userContactDetail = new UserContactDetail();
		UserInfo userInfo = userInfoRepo.findByName(userContactDetailPojo.getName())
				.orElseThrow(()-> new NameNotFoundException("Name not found"));
		userContactDetail.setUserInfo(userInfo);
		userContactDetail.setNotificationChannel(userContactDetailPojo.getNotificationChannel());
		userContactDetail.setContactInfo(userContactDetailPojo.getContactInfo());
		userContactDetailRepo.save(userContactDetail);
	}

	public UserContactDetail viewContactDetailsById(Long id) {
		return userContactDetailRepo.findById(id).get();
	}

	public List<UserContactDetail> viewContactDetailsByUser(String username) {
		return userContactDetailRepo.findContactDetailsByUserId(userInfoRepo.findIdByUsername(username));
	}

	public void updateContactInfo(UserContactDetailPojo userContactDetailPojo, Long id) {
		userContactDetailRepo.updateContactInfo(userContactDetailPojo.getContactInfo(), id);
	}

	public void updateNotificationChannel(UserContactDetailPojo userContactDetailPojo, Long id) {
		userContactDetailRepo.updateNotificationChannel(userContactDetailPojo.getNotificationChannel(), id);
	}

	public void updateUserId(UserContactDetailPojo userContactDetailPojo, Long id) {
		userContactDetailRepo.updateUserId(userInfoRepo.findIdByName(userContactDetailPojo.getName()), id);
	}

	public void updateContactDetails(UserContactDetailPojo userContactDetailPojo, Long id) {
		userContactDetailRepo.updateContactDetails(userInfoRepo.findIdByName(userContactDetailPojo.getName()),
				userContactDetailPojo.getNotificationChannel(), userContactDetailPojo.getContactInfo(), id);
	}
}
