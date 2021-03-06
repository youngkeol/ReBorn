package com.reborn.web.dao.mybatis.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reborn.web.dao.community.BoardDao;
import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;
@Repository
public class MyBatisBoardDao implements BoardDao{
	
	private SqlSession session;
	
	private BoardDao mapper;
	
	@Autowired
	public MyBatisBoardDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(BoardDao.class);
	}
	
	@Override
	public int insert(Board board) {
		return mapper.insert(board);
	}
	
	@Override
	public int insert(BoardCategory category) {
	
		return mapper.insert(category);
	}

	@Override
	public int update(Board board) {
		return mapper.update(board);
	}
	
	//글 조회수 업데이트
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public int hitUp(int id) {
		
		return mapper.hitUp(id);
	}
	
	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public BoardView get(int id) {
		return mapper.get(id);
	}


	@Override
	public Board getLast() {

		return mapper.getLast();
	}

	@Override
	public int getCount(String field, String query) {
	
		return mapper.getCount(field, query);
	}
	
	@Override
	public int getCount(String field, String query, String option) {
		
		return mapper.getCount(field, query, option);
	}

	@Override
	public Board getPrev(int id) {
		// TODO Auto-generated method stub
		return mapper.getPrev(id);
	}

	@Override
	public Board getnext(int id) {
		return mapper.getnext(id);
	}
	@Override
	public List<Board> getList() {
		return mapper.getList();
	}
	
	@Override
	public List<Board> getList(int offset) {
		return mapper.getList(1);
	}
	
	@Override
	public List<Board> getList(int offset, int size, String field, String query) {
		return mapper.getList(offset, size, field, query);
	}
	@Override
	public List<BoardView> getViewList(int offset, int size) {
		
		return mapper.getViewList(offset, size);
	}

	@Override
	public List<BoardView> getViewList(int offset, int size, String field, String query) {

		return mapper.getViewList(offset, size, field, query);
	}

	@Override
	public List<BoardView> getViewList(int offset, int view, String field, String query, String option) {

		return mapper.getViewList(offset, view, field, query, option);
	}
	
	
	
	
	
}
