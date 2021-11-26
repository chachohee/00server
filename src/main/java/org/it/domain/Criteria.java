package org.it.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum; //해당 페이지 번호
	private int amount; //한 페이지당 보여줄 게시물 양
	private int skip;//스킵 할 게시물 수 = (pageNum-1)*amount
	
	private String keyword;
	private String type;
	private String[] typeArr;
	
	public Criteria() {
		this(1,10);
		this.skip =0;
	
		
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum-1)*amount;
	}
	
	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}
	
	public void setAmount(int amount) {
		this.skip = (this.pageNum-1)*amount;
		this.amount = amount;
	}
	public String[] getTypeArr() {
		return type ==null? new String[] {}:type.split("");
	}
	
}
