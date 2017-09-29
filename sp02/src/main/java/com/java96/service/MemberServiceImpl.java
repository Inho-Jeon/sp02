package com.java96.service;

import org.springframework.stereotype.Service;

import com.java96.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Override
	public MemberDTO login(String uid) {
		
		MemberDTO dto = new MemberDTO();//memberDTO�� ���� ���� ����������!!
		dto.setUid(uid);
		dto.setUpw(uid);
		dto.setUname("�����..." + uid);
		return dto;
	}

}
