package com.sample.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sample.portal.vo.FreeBoard;

@Repository
public class FreeBoardDaoImPl implements FreeBoardDao {
	@Autowired
	private SqlMapClientTemplate template;

	@Override
	public List<FreeBoard> getAllBoards() {
		return template.queryForList("free.getAllBoards");
	}
	@Override
	public void addBoard(FreeBoard freeBoard) {
		 template.insert("free.addBoard",freeBoard);
	}
	
}
