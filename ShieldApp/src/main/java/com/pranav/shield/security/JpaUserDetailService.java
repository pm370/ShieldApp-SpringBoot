package com.pranav.shield.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.repository.UserInfoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService{

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		UserInfo userInfo=userInfoRepo.findByUsername(username)
				.orElseThrow(()-> new BadCredentialsException("Invalid username or password"));
		return new SecureUser(userInfo);
	}
}
