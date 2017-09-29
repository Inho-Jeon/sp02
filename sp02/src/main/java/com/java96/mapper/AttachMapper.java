package com.java96.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AttachMapper {

	@Insert("insert into tbl_attach (fname, tno) values (#{fname},  LAST_INSERT_ID()")
	public void insert(String fname);
}
