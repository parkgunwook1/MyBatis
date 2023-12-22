package com.kh.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
import com.kh.common.template.Template;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = boardDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession session = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectList(session, pi);
		
		session.close();
		
		return list;
	}

	@Override
	public Board selectBoard(int bno) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Board listCount = boardDao.selectListCount(sqlSession, bno);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public int increaseCoint(int bno) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = boardDao.selectListUp(sqlSession, bno);
		
		//dml이면 트랜잭션 처리 무조건 해줘야한다.
		if(listCount > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int searchCount = boardDao.selectSearchCount(sqlSession , map);
		
		sqlSession .close();
		
		return searchCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		 
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		
		return list;
	}
}

