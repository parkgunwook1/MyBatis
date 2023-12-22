package com.kh.board.model.vo;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reply {
	private int replyNo;
	private String replyContent;
	private int refBno;
	private String replyWriter;
	private Date createDate;
	private String stqtus;
	
	private String replyUserId;

}
