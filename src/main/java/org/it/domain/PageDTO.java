package org.it.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage;//현재 보여지는 페이지 줄에서 시작페이지 번호
	private int endPage;//현재 보여지는 페이지 줄에서 마지막 페이지 번호
	private boolean prev, next;
	
	private int total; //전체 데이터 수(게시물 수) 이거로 startPage, endPage, prev, next 구함
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//올림된 수 * 10
		this.startPage = this.endPage-9;
		//10개씩 보여줄거임(1~10, 11~20 이렇게)
		int realEnd = (int)(Math.ceil((total * 1.0)/cri.getAmount()));
		//최종 페이지 수 = 전체데이터수 / 한 페이지당 보여줄 게시물 수 (올림처리)
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage >1; //2페이지부터 이전 페이지가 존재하니까
		this.next = this.endPage < realEnd; //최종페이지번호보다 작으면 무조건 다음으로 갈 수 있겠지
		
	}

}
