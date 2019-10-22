package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BoardPageDto;
import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	@Override
	public int register(BoardVo board) {
		return mapper.insert(board);
	}

	@Override
	public BoardVo get(int bno) {
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVo board) {
		return mapper.update(board);
	}

	@Override
	public int remove(int bno) {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVo> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public BoardPageDto getListPage(Criteria cri) {
		return new BoardPageDto(mapper.getTotalCount(cri), mapper.getListWithPaging(cri));
	}
}
