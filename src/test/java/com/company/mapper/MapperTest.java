package com.company.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.domain.ReplyVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
	
//	@Test
//	public void insertTest() {
//		ReplyVo reply = new ReplyVo();
//		reply.setBno(55);
//		reply.setReply("GGG");
//		reply.setReplyer("BBB");
//	
//		
//		mapper.insert(reply);
//	}

//	@Test
//	public void readTest() {
//		int bno =1;
//		ReplyVo board= new ReplyVo();
//		log.info(mapper.read(bno));
//	}
	
//	@Test
//	public void deleteTest() {
//		int bno=1;
//		ReplyVo board = new ReplyVo();
//		mapper.delete(bno);
//	}
	
//	@Test
//	public void testUpdate() {
//		int bno=2;
//		ReplyVo board = mapper.read(bno);
//		board.setReply("updateTitle");
//		board.setReplyer("updateContent");
//		int count = mapper.update(board);
//		
//		log.info("count: " + count);
//	}
	
	@Test
	public void pageTest() {
		Criteria cri = new Criteria(2, 10);
		
		List<ReplyVo> replies = mapper.getListWithPaging(cri, 55);
		
		replies.forEach(reply -> log.info(reply));
	}

//	@Test
//	public void getTotalCountTest() {
//		Criteria cri = new Criteria();
//		Integer totalCount = mapper.getCountByBno(55);
//		log.info("totalCount : " + totalCount.toString());
//	}
}
