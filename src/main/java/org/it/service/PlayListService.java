package org.it.service;

import java.util.List;

import org.it.domain.PlayListVO;
import org.it.domain.Criteria;

public interface PlayListService {
	
	public void register(PlayListVO playlist); //등록
	
	public PlayListVO get(Long pno);//조회
	
	public boolean modify(PlayListVO playlist); //수정
	
	public boolean remove(Long pno); //삭제
	
//	public List<BoardVO> getList(); //결과로 전체 리스트 반환
	
	public List<PlayListVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);//전체 게시물 개수 얻어 오는 메서드

}
