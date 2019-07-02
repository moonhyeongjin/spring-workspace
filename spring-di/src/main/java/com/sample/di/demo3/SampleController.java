package com.sample.di.demo3;

public class SampleController {
	private SampleDao dao;
	
	public void setDao(SampleDao dao) {
		this.dao = dao;
	}

	public void add(String id, String password) {
		dao.insert(id, password);
	}
	
}
