package com.java96.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.java96.dto.Criteria;
import com.java96.dto.ReplyDTO;

public interface ReplyMapper {

	@Insert("insert into tbl_reply (reply, replyer, tno) values (#{reply}, #{replyer}, #{tno})")
	public void create(ReplyDTO dto);

	@Select("select * from tbl_reply where rno = #{rno}")
	public ReplyDTO read(Integer rno);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	public void delete(Integer rno);
	
	@Update("update tbl_reply set reply = #{reply}, replyer = #{replyer} where rno = #{rno}")
	public void update(ReplyDTO dto);
	
	@Select("select * from tbl_reply where rno > 0 limit #{skip}, 100 ")
	public List<ReplyDTO> list(Criteria cri);
}
