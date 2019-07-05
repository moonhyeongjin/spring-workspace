package com.sample.portal.service;

import java.util.List;

import com.sample.portal.vo.FreeBoard;

public interface FreeBoardService {

	List<FreeBoard> getAllBoards();
	void addBoard(FreeBoard freeBoard);
}
