package org.it.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MusicVO {
	
	private Long pno;
	private Long mno;
	private String title;
	private String artist;
	private String link;
	private Date addDate;
	private Date updateDate;

}
