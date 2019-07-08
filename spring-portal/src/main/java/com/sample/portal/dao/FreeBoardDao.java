package com.sample.portal.dao;

import java.util.List;

import com.sample.portal.vo.FreeBoard;
import com.sample.portal.vo.FreeBoardComment;

public interface FreeBoardDao {

	 List<FreeBoard> getAllBoards();
	 void addBoard(FreeBoard freeBoard);
	 FreeBoard getFreeBoardByNo(int boardNo);
	 
	 void addComment(FreeBoardComment comment);
	 List<FreeBoardComment> getCommentsByBoardNo(int boardNo);
}
