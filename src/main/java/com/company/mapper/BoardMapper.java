package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;

public interface BoardMapper {

	public int insert(BoardVo board);
	
	public BoardVo read(int bno);
	
	public int delete(int bno);
	
	public int update(BoardVo board);
	
	public List<BoardVo> getListWithPaging(@Param("cri") Criteria cri);
}
