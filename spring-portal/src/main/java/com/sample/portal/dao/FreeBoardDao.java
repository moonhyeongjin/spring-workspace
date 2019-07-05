package com.sample.portal.dao;

import java.util.List;

import com.sample.portal.vo.FreeBoard;

public interface FreeBoardDao {

	 List<FreeBoard> getAllBoards();
	 void addBoard(FreeBoard freeBoard);
}
