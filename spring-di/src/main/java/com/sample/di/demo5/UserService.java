package com.sample.di.demo5;

public class UserService {

	private PointDao pointDao;
	
	public void setPointDao(PointDao pointDao) {
		this.pointDao = pointDao;
	}
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	void addNewUser(String name , String id, String password) {
		userDao.insertUser(name, id, password);
		pointDao.updatePoint(id, 10);
	}
}
