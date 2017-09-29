package com.java96.service;

import java.util.List;

import com.java96.dto.Criteria;
import com.java96.dto.ReplyDTO;

public interface ReplyService {

	public void register(ReplyDTO dto);
	
	public ReplyDTO get(Integer rno);
	
	public void remove(Integer rno);
	
	public void update(ReplyDTO dto);
	
	public List<ReplyDTO> listPage(Criteria cri);
}
