package org.it.domain;

import java.util.Date;

import lombok.Data;

@Data // getter/setter, toString() 등 만들어냄
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;

}
