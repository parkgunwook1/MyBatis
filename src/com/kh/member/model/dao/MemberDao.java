package com.kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.model.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
		
		// 필요한 변수 셋팅
		// Member m = null;
		// PreparedStatement pstmt = null;
		// ResultSet rset = null;
		// String sql = "Select * from Member" ;
		// pstmt = conn.preparedStatement(sql);
		// 예외처리, 위치홀더 변환, 조회된 결과값(rset)을 VO클래스(Member)로 변환
		// 자원반납 등등...

		// selectOne : 조회결과 없으면 null값 반환
		// sqlSession.sql문 종류에 맞는 메소드("mapper파일의 namespace.해당 sql문의 id값", sql문을 완성시킬 객체)
		return sqlSession.selectOne("memberMapper.loginMember", m); //필요한 sql문 가지고 오고, 매개변수 넘기기 
		
	}

	public int insertMember(SqlSession sqlSession, Member m) {
						
		return sqlSession.insert("memberMapper.insertMember", m );
	}

}
