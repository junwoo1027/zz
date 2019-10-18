package com.company.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {

	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
	
	@Test
	public void insertTest() {
		BoardVo board = new BoardVo();
			board.setTitle("헬로");
			board.setContent("hoho");
			board.setWriter("jun");
		
		mapper.insert(board);
	}

//	@Test
//	public void readTest() {
//		int bno =1;
//		BoardVo board= new BoardVo();
//		log.info(mapper.read(bno));
//	}
	
//	@Test
//	public void deleteTest() {
//		int bno=2;
//		BoardVo board = new BoardVo();
//		mapper.delete(bno);
//	}
	
//	@Test
//	public void testUpdate() {
//		int bno=1;
//		BoardVo board = mapper.read(bno);
//		board.setTitle("updateTitle");
//		board.setContent("updateContent");
//		int count = mapper.update(board);
//		
//		log.info("count: " + count);
//	}
	
//	@Test
//	public void pageTest() {
//		Criteria cri = new Criteria();
//		
//		List<BoardVo> list = mapper.getListWithPaging(cri);
//		
//		list.forEach(board -> log.info(board));
//	}
}
