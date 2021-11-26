package org.it.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
//	@Test
//	public void testExist() {
//		log.info(service);//BoardService 객체가 제대로 주입 가능한지 확인
//		assertNotNull(service);
//	}
//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 글");
//		board.setWriter("newbie");
//		
//		service.register(board);
//		log.info("생성된 게시물의 번호:"+board.getBno());
//		
//	}
	@Test
	public void testGetList() {
		//service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
//	@Test
//	public void testGet() {
//		log.info(service.get(1L));
//	}
//	@Test
//	public void testRemove() {
//		log.info("제거 테스트:"+service.remove(6L));
//		
//	}
//	@Test
//	public void testModify() {
//		BoardVO board = service.get(1L);
//		if(board == null) {
//			return;//공백(값이 없다면)이라면 수정할 내용이 없으니까 종료
//		}
//		board.setTitle("제목 수정합니다");
//		log.info("수정 테스트:"+service.modify(board));
//	}

}
