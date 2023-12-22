package com.kh.board.model.dao;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
		//1행 1열 전달받을 것이기 때문에 selectone을 사용
	}
	public ArrayList<Board> selectList(SqlSession session, PageInfo pi) {
		
		/*
		 * 마이바티스에서는 페이징 처리를 위해 RowBounds라는 클래스 제공함
		 *
		 * * offset : 몇 개의 게시글을 건너뛰고 조회할 건지에 대한 값
		 *
		 * boardLimit가 5일 경우			  offset		limit
		 * currentPage : 1=>1~5				0			 5
		 * currentPage : 2=>6~10			5			 5
		 * currentPage : 3=>11~15			10			 5
		 */
		
		int limit = pi.getBoardLimit();
		int offset= (pi.getCurrentPage()-1) *limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		/*
		 * RowBounds 객체를 넘겨야 할 경우
		 * selectList메소드의 오버로딩된 메서드 중 매개변수가 3개인 메소드를 사용해야만 한다.
		 * 단, 이 때 두번째매개변수(쿼리문을 꾸밀 객체)가 필요 없다면 null값을 제시해야 한다.
		 */
		
		return (ArrayList) session.selectList("boardMapper.selectList", null , rowBounds);
		
	}
	public Board selectListCount(SqlSession sqlSession, int bno) {
		
		return sqlSession.selectOne("boardMapper.selectDetail", bno);
	}
	public int selectListUp(SqlSession sqlSession, int bno) {
		
		return sqlSession.update("boardMapper.increaseCoint", bno);
	}
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		
		int limit  = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds );
	}
	
}