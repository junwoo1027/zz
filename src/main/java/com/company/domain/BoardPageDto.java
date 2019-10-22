package com.company.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BoardPageDto {

	private int boardCnt;
	private List<BoardVo> list;
	
	@Autowired
	public BoardPageDto(int boardCnt, List<BoardVo> list) {
		this.boardCnt = boardCnt;
		this.list = list;
	}

	public int getBoardCnt() {
		return boardCnt;
	}

	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}

	public List<BoardVo> getList() {
		return list;
	}

	public void setList(List<BoardVo> list) {
		this.list = list;
	}
	
}
