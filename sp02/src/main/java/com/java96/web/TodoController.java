package com.java96.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;
import com.java96.service.TodoService;

import lombok.extern.java.Log;



@Controller
@RequestMapping("/todo/*")
@Log
public class TodoController {

	@Inject
	private TodoService service;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping("/modify")
	public void modGet(Long tno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		model.addAttribute("todo", service.get(tno));
	}
	
	@PostMapping("/modify")
			public String modPost(TodoDTO dto, Criteria cri, RedirectAttributes rttr) {
		
		log.info("mod post...........");
		
		rttr.addAttribute("tno", dto.getTno());
		
		return "redirect:/todo/view" + cri.getURI();
		
	}
	
	@GetMapping("/view")
	public void view(Long tno , @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("todo",service.get(tno));
	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		model.addAttribute("list", service.list(cri));
	}
	@PostMapping("/register")
	public String register(TodoDTO dto, RedirectAttributes rttr) {
		
		log.info(""+dto);
		
		service.register(dto);
		
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/todo/list";
	}
	
	
}

