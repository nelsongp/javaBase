package com.usertest.repository;

import org.springframework.data.repository.CrudRepository;

import com.usertest.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, String>{

}
