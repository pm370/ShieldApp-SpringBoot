package com.pranav.shield.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pranav.shield.entity.UserPrivilege;
import com.pranav.shield.utils.Enums.UserTypes;

public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege, Long> {

	UserPrivilege findByUserType(UserTypes director);
	
	@Query("select u.userType from UserPrivilege u where u.id=:id")
	String findUserTypeById(@Param("id") Long id);

}
