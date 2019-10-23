package com.company.me;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.BoardPageDto;
import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.domain.PageDto;
import com.company.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/")
@RestController
@Log4j
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	
	//게시글 등록
	@PostMapping(value="/new",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody BoardVo board){
		
		log.info("BoardVo: " + board);
		
		int insertCount = service.register(board);
		
		log.info("insertCount: " + insertCount);
		
		return insertCount == 1
		? new ResponseEntity<>("success", HttpStatus.OK)
		: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//게시긂 목록
	@GetMapping(value="/pages/{page}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<BoardPageDto> getList(@PathVariable("page") int page){
		
		log.info("getList....");
		Criteria cri = new Criteria(page, 10);
		
		log.info(cri);
		
		return new ResponseEntity<>(service.getListPage(cri), HttpStatus.OK);
	}
	
	//게시글 조회
	@GetMapping(value="/{bno}",
			produces = { MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<BoardVo> get(@PathVariable("bno") int bno){
		log.info("get: " + bno);
		
		return new ResponseEntity<>(service.get(bno), HttpStatus.OK);
	}
	
	//게시글 삭제
	@DeleteMapping(value="/{bno}",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("bno") int bno){
		log.info("remove: " + bno);
		
		return service.remove(bno) == 1
		? new ResponseEntity<>("success", HttpStatus.OK)
	    : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	//게시글 수정
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value="/{bno}",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody BoardVo board, @PathVariable("bno") int bno){
		
		board.setBno(bno);
		
		log.info("bno: " + bno);
		log.info("modify: " + board);
		
		return service.modify(board) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}