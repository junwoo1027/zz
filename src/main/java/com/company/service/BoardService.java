package com.company.service;

import java.util.List;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;

public interface BoardService {
	
	public int register(BoardVo board);
	
	public BoardVo get(int bno);
	
	public int modify(BoardVo board);
	
	public int remove(int bno);
	
	public List<BoardVo> getList(Criteria cri);
}
