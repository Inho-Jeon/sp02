package com.java96.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;

public interface TodoMapper {

	@Insert("insert into tbl_todo (title, writer) values (#{title}, #{writer})")
	public void insert(TodoDTO dto); 
	
	@Select("select * from tbl_todo where tno = #{tno}")
	public TodoDTO findById(Long tno);
	
	public List<TodoDTO> listPage(Criteria cri);
	
	@Select("select count(*) from tbl_todo where tno > 0")
	public int getTotal(Criteria cri);
	
	@Delete("delete from tbl_todo where tno = #{tno}")
	public void remove(long tno);

	@Update("update tbl_todo set title = #{dto.title}, writer=#{dto.writer} where tno = #{tno} ")
	public void update(@Param("dto")TodoDTO dto, @Param("cri") Criteria cri);
	
	@Update("update tbl_todo set replycnt = replycnt + 1 where tno = #{tno}")
	public void updateReplyCnt(Long tno);
}
