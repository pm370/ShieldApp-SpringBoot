package com.pranav.shield.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pranav.shield.entity.UserContactDetail;
import com.pranav.shield.utils.Enums.NotificationChannels;

public interface UserContactDetailRepository extends JpaRepository<UserContactDetail, Long> {

	Optional<UserContactDetail> findByContactInfo(String string);
	
	@Query("select u from UserContactDetail u where u.userInfo.id=:id")
	List<UserContactDetail> findContactDetailsByUserId(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update UserContactDetail u set u.contactInfo=:contactInfo where u.id=:id")
	void updateContactInfo(@Param("contactInfo") String contactInfo, @Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update UserContactDetail u set u.notificationChannel=:notificationChannel where u.id=:id")
	void updateNotificationChannel(@Param("notificationChannel") NotificationChannels notificationChannel, @Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update UserContactDetail u set u.userInfo.id=:userId where u.id=:id")
	void updateUserId(@Param("userId") Long userId, @Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update UserContactDetail u set u.userInfo.id=:userId, u.notificationChannel=:notificationChannel, u.contactInfo=:contactInfo where u.id=:id")
	void updateContactDetails(@Param("userId") Long userId,@Param("notificationChannel") NotificationChannels notificationChannel, @Param("contactInfo") String contactInfo, @Param("id") Long id);

	@Query("select u.contactInfo from UserContactDetail u where u.userInfo.name=:name AND u.notificationChannel=:channel")
	String findContactInfoByUserAndChannel(@Param("name") String name, @Param("channel") NotificationChannels channel);

	
}
