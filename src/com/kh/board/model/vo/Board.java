package com.kh.board.model.vo;

import java.sql.Date;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본생성자
@AllArgsConstructor// 매개변수 생성자
@Setter
@Getter
@ToString
@Builder

/*
 * boardTitle   => 글제목
 * boardNo 	    => 작성자
 * count 	    => 조회수
 * createDate   => 작성일
 * boardContent => 글내용
 * */
public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;  
	private String userId;
	private int count;
	private Date createDate;
	private String status;
	
	private ArrayList<Reply> list;


}
