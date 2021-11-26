package org.it.service;

import java.util.List;

import org.it.domain.Criteria;
import org.it.domain.ReplyPageDTO;
import org.it.domain.ReplyVO;
import org.it.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		
		log.info("댓글 등록............."+vo);
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		
		log.info("댓글 조회............"+rno);
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		log.info("댓글 수정............."+vo);
		
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("댓글 삭제............"+rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("해당 게시글의 목록을 읽는다........"+bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno));
	}
	
	

}
