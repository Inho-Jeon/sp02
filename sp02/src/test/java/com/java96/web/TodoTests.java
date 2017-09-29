package com.java96.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;
import com.java96.mapper.TodoMapper;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
@Log
public class TodoTests {

	@Inject
	private TodoMapper mapper;

	@Test
	public void testList() {
		List<TodoDTO> list = mapper.listPage(new Criteria(1));

		list.forEach(dto -> log.info("" + dto + "\n"));
	}

	@Test
	public void test1() {
		log.info("" + mapper.findById(2L));
	}

	@Test
	public void test2() {
		TodoDTO dto = new TodoDTO();
		dto.setTitle("title" + System.currentTimeMillis());
		dto.setWriter("user");

		mapper.insert(dto);
	}
}
