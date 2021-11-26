package org.it.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.it.domain.BoardVO;
import org.it.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select*from tbl_board where bno>0") -> xml로 처리해서 이제 어노테이션 제거
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	//insert만 처리되고 생성된 pk값을 알 필요가 없는 경우
	
	public void insertSelectKey(BoardVO board);
	//insert문이 실행되고 생성된 pk값을 알아야 하는 경우
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO baord);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri); //db에서 전체 데이터 개수 얻어와야 함
}
