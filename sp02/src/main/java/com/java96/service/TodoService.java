package com.java96.service;

import java.util.List;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;

public interface TodoService {

	public TodoDTO get(Long tno);
	
	public void register(TodoDTO dto);

	public List<TodoDTO> list(Criteria cri);

	public void remove(long tno);

	public void modify(TodoDTO dto);

	void register(TodoDTO dto, String[] ufiles);


}
