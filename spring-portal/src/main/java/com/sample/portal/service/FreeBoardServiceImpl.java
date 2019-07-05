package com.sample.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.portal.dao.FreeBoardDao;
import com.sample.portal.vo.FreeBoard;
@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardDao freeBoardDao;
	
	@Override
	public List<FreeBoard> getAllBoards() {
		return freeBoardDao.getAllBoards();
	}
	
	@Override
	public void addBoard(FreeBoard freeBoard) {
		freeBoardDao.addBoard(freeBoard);
	}
}
