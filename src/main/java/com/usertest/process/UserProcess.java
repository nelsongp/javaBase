package com.usertest.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usertest.data.userinfo.IUserInfoData;
import com.usertest.data.usuario.IUserData;
import com.usertest.entity.UserInfo;
import com.usertest.entity.UserInfoId;
import com.usertest.entity.Usuarios;
import com.usertest.pojo.CreateUsuario;
import com.usertest.pojo.userresponse.UserResponse;

@Service
public class UserProcess implements IUserProcess{
	
	private IUserData dataUser;
	private IUserInfoData dataInfoUser;
	private Logger log;
	
	public UserProcess(
			@Qualifier("BeanDataUsuarios") IUserData dataUser,
			@Qualifier("BeanDataUsuariosInfo") IUserInfoData dataInfoUser) {
		this.dataInfoUser = dataInfoUser;
		this.dataUser = dataUser;
		this.log =  LoggerFactory.getLogger("com.loyalty.logger");
	}

	@Override
	public UserResponse saveUser(CreateUsuario createUsuario) {
		UserResponse response = new UserResponse();
		Usuarios usuario = new Usuarios();
		UserInfo userInfo = new UserInfo();
		UserInfoId userId = new UserInfoId();
		
		try {
			//guardamos primero el usuario
			usuario.setUsername(createUsuario.getUserName());
			usuario.setUserpassword(createUsuario.getPassword());					
			
			Boolean userSave = dataUser.saveUsuario(usuario);
			
			if(userSave) {
				userId.setUsername(createUsuario.getUserName());
				userId.setUsrfirstname(createUsuario.getUserFirstName());
				userInfo.setId(userId);
				userInfo.setUsrlastname(createUsuario.getUserLastName());
				userInfo.setUsrage(createUsuario.getUserAge());
				userInfo.setUsraddress(createUsuario.getUserAddress());
				
				Boolean userInfoSave = dataInfoUser.saveUserInfoData(userInfo);
				if(userInfoSave) {
					response.setResponseCode("000");
					response.setMsg("Exito");
					response.setResponse(userInfoSave);
				}
				else {
					response.setResponseCode("001");
					response.setMsg("error guardar usuario");
					response.setResponse(userInfoSave);
				}
			} else {
				response.setResponseCode("002");
				response.setMsg("error al guardar usuario");
				response.setResponse(userSave);
			}
			
		} catch (Exception e) {
			response.setResponseCode("003");
			response.setMsg("error generico");
			response.setResponse(false);
		}
		return response;
	}

}
