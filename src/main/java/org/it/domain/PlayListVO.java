package org.it.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PlayListVO {
	
	private Long pno;
	private String name;
	private Date regDate;
	private Date updateDate;

}
