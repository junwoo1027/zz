package com.company.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ReplyPageDto {

	private int replyCnt;
	private List<ReplyVo> list;
	
	@Autowired
	public ReplyPageDto(int replyCnt, List<ReplyVo> list) {
		super();
		this.replyCnt = replyCnt;
		this.list = list;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public List<ReplyVo> getList() {
		return list;
	}

	public void setList(List<ReplyVo> list) {
		this.list = list;
	}
	
}
