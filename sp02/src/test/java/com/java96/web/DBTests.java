package com.java96.web;

import java.sql.Connection;


import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBTests {

	
	@Autowired
	
	DataSource ds;
	
	@Test
	public void test() {
		
		//DB연결 테스트
	}
	@Test
	public void test2() throws Exception {
		
		//스프링 빈으로 등록된 DataSource Test
		Connection con = ds.getConnection();
		System.out.println(con);
		
		con.close();
	}
}
