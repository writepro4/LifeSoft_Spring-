package com.example.spring02.model.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.spring02.model.memo.dto.MemoDTO;

public interface MemoDAO {
	
	@Select("select * from memo order by idx desc")
	public List<MemoDTO> list();
	
	@Insert("insert into memo (idx,writer,memo) "
			+ "values ( (select nvl(max(idx)+1,1) from memo)" 
			+ ",#{writer},#{memo} )")
	public void insert(@Param("writer") String writer,
			@Param("memo") String memo);
	
	@Select("select * from memo where idx=#{idx}")
	public MemoDTO memo_view(@Param("idx") int idx);

}
