package com.usertest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.usertest.entity.UserInfo;
import com.usertest.entity.UserInfoId;

public interface UserInfoRepository extends CrudRepository<UserInfo, UserInfoId>{
	public List<UserInfo> findByUsrageBetween(Integer pri, Integer sec);
}
