package org.it.service;

import java.util.List;

import org.it.domain.BoardVO;
import org.it.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board); //등록
	
	public BoardVO get(Long bno);//조회
	
	public boolean modify(BoardVO board); //수정
	
	public boolean remove(Long bno); //삭제
	
//	public List<BoardVO> getList(); //결과로 전체 리스트 반환
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);//전체 게시물 개수 얻어 오는 메서드

}
