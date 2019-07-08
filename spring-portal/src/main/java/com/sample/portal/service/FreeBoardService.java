package com.sample.portal.service;

import java.util.List;

import com.sample.portal.vo.FreeBoard;
import com.sample.portal.vo.FreeBoardComment;

public interface FreeBoardService {

	List<FreeBoard> getAllFreeBoards();
	void addNewFreeBoard(FreeBoard freeBoard);
	FreeBoard getFreeBoardDetail(int boardNo);
	
	void addNewFreeBoardComment(FreeBoardComment comment);
	List<FreeBoardComment> getFreeBoardComments(int boardNo);
}
