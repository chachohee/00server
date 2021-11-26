package org.it.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.it.domain.Criteria;
import org.it.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long bno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO reply);
	
	//기존 페이징 처리에 특정 게시물의 댓글들만 대상으로 하는 페이징 처리 필요하므로 추가적으로 게시물 번호 필요
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
	
	/* MyBatis는 두개 이상의 데이터를 파라미터로 전달하기 위해서는
	 * 1. 별도의 객체로 구성
	 * 2. Map 이용
	 * 3. @Param 을 이용해서 이름을 사용하는 방식
	 */
	
	public int getCountByBno(Long bno);
	//댓글 수 파악
}
