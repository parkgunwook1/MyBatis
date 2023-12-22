package com.kh.member.model.service;

import com.kh.member.model.vo.Member;

// 인터페이스 : 상수필드(public static final) + 추상메소드(public abstract)
public interface MemberService {
	
	Member loginMember(Member m); //내부에 몸통 구현하면 안됨, public abstract가 묵시적으로 붙음
	

}
