package com.sample.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sample.portal.vo.FreeBoard;
import com.sample.portal.vo.FreeBoardComment;

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
	@Override
	public FreeBoard getFreeBoardByNo(int boardNo) {
		return (FreeBoard) template.queryForObject("free.getFreeBoardByNo", boardNo);
	}
	@Override
	public void addComment(FreeBoardComment comment) {
			template.insert("free.addComment",comment);
	}
	@Override
	public List<FreeBoardComment> getCommentsByBoardNo(int boardNo) {
		return template.queryForList("free.getCommentsByBoardNo", boardNo);
	}
	
}
