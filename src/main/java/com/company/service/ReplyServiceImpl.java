package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.Criteria;
import com.company.domain.ReplyPageDto;
import com.company.domain.ReplyVo;
import com.company.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyServie {

	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVo reply) {
		log.info("register : " + reply);
		return mapper.insert(reply);
	}

	@Override
	public ReplyVo get(int rno) {
		log.info("get: " + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVo reply) {
		log.info("modify: " + reply );
		return mapper.update(reply);
	}

	@Override
	public int remove(int rno) {
		log.info("remove: " + rno);
		return mapper.delete(rno);
	}

	@Override
	public ReplyPageDto getListPage(Criteria cri, int bno) {
		return new ReplyPageDto(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}

}
