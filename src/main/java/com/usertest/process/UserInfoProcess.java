package com.usertest.process;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usertest.data.userinfo.IUserInfoData;
import com.usertest.entity.UserInfo;
import com.usertest.pojo.userresponse.ReportUserAge;

@Service
public class UserInfoProcess implements IUserInfoProcess{
	private IUserInfoData data;
	private Logger log;
	
	public UserInfoProcess(@Qualifier("BeanDataUsuariosInfo") IUserInfoData data) {
		this.data = data;
		this.log = LoggerFactory.getLogger("com.loyalty.logger");
	}

	@Override
	public List<ReportUserAge> getUserByAge(Integer pre, Integer sec) {
		List<UserInfo> lstUserInfo = new ArrayList<>();
		List<ReportUserAge> lstUsrAge = new ArrayList<>();
		try {			
			List<ReportUserAge> lstUsrAge2 = new ArrayList<>();
			lstUserInfo = data.getUserByAge(pre, sec);
			lstUserInfo.forEach(x -> {
				lstUsrAge2.add(new ReportUserAge(x.getId().getUsername(), x.getId().getUsrfirstname(), x.getUsrlastname(), x.getUsrage()));				
			});
			lstUsrAge = lstUsrAge2;
		} catch (Exception e) {
			log.error("Error construyendo reporte de usuarios {}", e.getMessage(), e);
			lstUsrAge = new ArrayList<>();
		}
		return lstUsrAge;
	}

}
