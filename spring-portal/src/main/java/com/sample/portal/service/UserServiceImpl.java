package com.sample.portal.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.portal.dao.UserDao;
import com.sample.portal.exception.AlreadyUsedIdException;
import com.sample.portal.exception.LoginFailureException;
import com.sample.portal.vo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void registerUser(User user) {
		if(userDao.getUserById(user.getId()) != null) {
			// ���ܹ߻�
			throw new AlreadyUsedIdException("["+user.getId()+"]�� �̹� ������� ���̵��Դϴ�.");
		}
		
		String md5Password = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(md5Password);
		
		userDao.addUser(user);
	}
	
	@Override
	public User login(String id, String password) {
		User user = userDao.getUserById(id);
		if(user == null) {
			throw new LoginFailureException("���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
		}
		String md5Password = DigestUtils.md5Hex(password);
		
		if(!md5Password.equals(user.getPassword())) {
			throw new LoginFailureException("���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
		}
		return user;
	}
}
