package com.java96.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java96.dto.LoginDTO;
import com.java96.dto.MemberDTO;

import lombok.extern.java.Log;

@Controller
@Log
public class LoginController {

	@GetMapping("/login")
	public void login() {
		log.info("get.....login");
	}

	@PostMapping("/login")
	public void loginPost(LoginDTO dto, Model model) {
		
		log.info("post...login");

		MemberDTO member = new MemberDTO();
		member.setUid(dto.getUid());
		member.setUpw(dto.getUpw());
		member.setUname("»ç¿ëÀÚ" + dto.getUid());
		
		model.addAttribute("memberDTO", member);
	}
}
