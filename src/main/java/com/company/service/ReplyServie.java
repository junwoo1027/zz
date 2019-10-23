package com.company.service;

import com.company.domain.Criteria;
import com.company.domain.ReplyPageDto;
import com.company.domain.ReplyVo;

public interface ReplyServie {

	public int register(ReplyVo reply);
	
	public ReplyVo get(int bno);
	
	public int modify(ReplyVo reply);
	
	public int remove(int rno);
	
	public ReplyPageDto getListPage(Criteria cri ,int bno);
	
}
