package org.it.mapper;

import java.util.List;

import org.it.domain.BoardVO;
import org.it.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//		
//	}
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();//insert할 애들 담을 그릇 생성
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("new");
		//새로 만들어진 board에 저장될 값
		//setXXX한 값들 #{}여기로 전달
		
		mapper.insert(board);
		//BoardMapper에 있는 insert메서드에 board객체 전달
		//BoardMapper.xml에 있는 insert 쿼리문 실행
		
		log.info(board);
		//Lombok이 만들어주는 toString()을 이용해서 bno 멤버 변수의 값을 알아보기 위함(null로 비어있음)
		
	}
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글 select key");
//		board.setContent("새로 작성하는 내용 select key");
//		board.setWriter("new select key");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
//		
//	}
//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(5L);
//		//bno=5인 row에 대한 정보 읽어온 거 담을 곳 필요하니까 BoardVO 타입의 객체 만들어준 거
//		log.info(board);
//	}
//	@Test
//	public void testDelete() {
//		log.info("삭제 수:"+mapper.delete(7L));
//	}
//	@Test
//	public void testUpdate() {
//		BoardVO board = new BoardVO();
//		board.setBno(5L);//실행 전 존재하는 번호인지 확인할 것(번호 있는 거 수정해야 하니까)
//		board.setTitle("수정");
//		board.setContent("수정");
//		board.setWriter("작성자");
//		
//		int count = mapper.update(board);
//		log.info("업데이트 수:"+count);
//	}
//	@Test
//	public void testPaging() {
//		Criteria cri = new Criteria();
//		cri.setPageNum(4);
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board));
//	}

}
