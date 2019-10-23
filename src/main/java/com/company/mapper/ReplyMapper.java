package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.Criteria;
import com.company.domain.ReplyVo;

public interface ReplyMapper {

	public int insert(ReplyVo reply);
	
	public ReplyVo read(int rno);
	
	public int delete(int rno);
	
	public int update(ReplyVo reply);
	
	public List<ReplyVo> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);
	
	public int getCountByBno(int bno);
}
