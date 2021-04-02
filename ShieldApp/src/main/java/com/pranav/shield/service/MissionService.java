package com.pranav.shield.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pranav.shield.entity.Mission;
import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.exception.MissionOutOfRangeException;
import com.pranav.shield.exception.NameNotFoundException;
import com.pranav.shield.pojo.MissionPojo;
import com.pranav.shield.pojo.NotificationPojo;
import com.pranav.shield.repository.MissionRepository;
import com.pranav.shield.repository.NotificationRepository;
import com.pranav.shield.repository.UserContactDetailRepository;
import com.pranav.shield.repository.UserInfoRepository;
import com.pranav.shield.utils.Enums.MissionStatus;

@Service
public class MissionService {
	
	@Autowired
	private MissionRepository missionRepo;
	
	@Autowired
	private UserInfoRepository userInfoRepo;
	
	@Autowired
	private UserContactDetailRepository userContactDetailRepo;
	
	@Autowired
	private NotificationService notificationService;
	
	public void assignMission(MissionPojo missionPojo) {
		Mission mission = new Mission();
		mission.setTitle(missionPojo.getTitle());
		mission.setDetails(missionPojo.getDetails());
		mission.setStatus(missionPojo.getStatus());
		UserInfo userInfo = userInfoRepo.findByName(missionPojo.getName())
				.orElseThrow(()-> new NameNotFoundException("Name not found")); 
		mission.setUserInfo(userInfo);
		List<Mission> missionList=missionRepo.findByNameAndStatus(missionPojo.getName(),MissionStatus.PENDING);
		if(missionList.size()>=2) {
			throw new MissionOutOfRangeException(missionPojo.getName()+" already has 2 pending missions");
		}
		missionRepo.save(mission);
		NotificationPojo notificationPojo = new NotificationPojo();
		sendNotification(notificationPojo,missionPojo,"New Mission Assigned");
		notificationService.saveNotification(notificationPojo);
	}
	
	public Mission viewMissionById(Long id) {
		return missionRepo.findById(id).get();
	}
	
	public List<Mission> viewAllMissions() {
		return missionRepo.findAll();
	}
	
	public List<Mission> viewPendingMissions() {
		return missionRepo.findPendingMissions(MissionStatus.PENDING);
	}
	
	public List<Mission> viewCompletedMissions() {
		return missionRepo.findCompletedMissions(MissionStatus.COMPLETED);
	}
	
	public String viewMissionStatusById(Long id) {
		return missionRepo.findStatusById(id);
	}
	
	public List<Mission> viewMissionsStatusByUser(String username) {
		return missionRepo.findMissionsByUserId(userInfoRepo.findIdByUsername(username));	
	}
	
	public void updateMissionTitle(MissionPojo missionPojo, Long id) {
		missionRepo.updateMissionTitle(missionPojo.getTitle(), id);
		NotificationPojo notificationPojo = new NotificationPojo();
		sendNotification(notificationPojo,missionPojo,"Mission Title Updated");
		notificationService.saveNotification(notificationPojo);
	}
	
	public void updateMissionDetails(MissionPojo missionPojo, Long id) {
		missionRepo.updateMissionDetails(missionPojo.getDetails(), id);
		NotificationPojo notificationPojo = new NotificationPojo();
		sendNotification(notificationPojo,missionPojo,"Mission Details Updated");
		notificationService.saveNotification(notificationPojo);
	}
	
	public void updateMissionStatus(MissionPojo missionPojo, Long id) {
		missionRepo.updateMissionStatus(missionPojo.getStatus(), id);
		NotificationPojo notificationPojo = new NotificationPojo();
		sendNotification(notificationPojo,missionPojo,"Mission Status Updated");
		notificationService.saveNotification(notificationPojo);
	}
	
	public void sendNotification(NotificationPojo notificationPojo,MissionPojo missionPojo,String msg) {
		notificationPojo.setName(missionPojo.getName());
		notificationPojo.setContactInfo(userContactDetailRepo.findContactInfoByUserAndChannel(missionPojo.getName(),missionPojo.getChannel()));
		notificationPojo.setMessage(msg);
	}
	
	
	

}
