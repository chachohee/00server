package org.it.service;

import java.util.List;

import org.it.domain.BoardVO;
import org.it.domain.Criteria;
import org.it.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service //이거 붙은 거 스프링에서 빈으로 인식
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;//각 계층끼리는 인터페이스로 느슨한 결합함
	
	@Override
	public void register(BoardVO board) {
		log.info("등록............."+board);
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("조회............"+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("수정................."+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("삭제..............."+bno);
		return mapper.delete(bno)==1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("현재 테이블에 저장된 모든 데이터를 가져옴");
//		return mapper.getList();//bno>0큰 거 읽어오는 거로 쿼리문 작성했으니까
//	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria:"+cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("전체 데이터 수");
		return mapper.getTotalCount(cri); //db에서 전체 게시물 수 알아옴
	}

}
