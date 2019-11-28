package com.usertest.data.userinfo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.usertest.entity.UserInfo;
import com.usertest.repository.UserInfoRepository;

@Service("UserInfoDataBase")
public class UserInfoDataBase implements IUserInfoData{
	private UserInfoRepository repo;
	private Logger log;
	
	public UserInfoDataBase(UserInfoRepository repo) {
		this.repo = repo;
		this.log =  LoggerFactory.getLogger("com.loyalty.logger");
	}

	@Override
	public Boolean saveUserInfoData(UserInfo userInfo) {
		try {
			repo.save(userInfo);
			return true;
		} catch (Exception e) {
			log.error("No se pudo guardar la informacion del usuario: {}", e.getMessage(), e);
			return false;
		}		
	}

	@Override
	public List<UserInfo> getUserByAge(Integer pre, Integer sec) {
		List<UserInfo> lstUserInfo = new ArrayList<>();
		try {			
			lstUserInfo = repo.findByUsrageBetween(pre, sec);			
		} catch (Exception e) {
			log.error("No se pudo realizar la consulta de manera correcta {}", e.getMessage(), e);
			lstUserInfo = new ArrayList<>();
		}
		return lstUserInfo;
	}

}
