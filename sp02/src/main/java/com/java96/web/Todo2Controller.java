package com.java96.web;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/todo2/*")
@Log
public class Todo2Controller {

	
	@Autowired
	private TodoService service;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	@PostMapping("/register")
    public String registerPost(TodoDTO dto, RedirectAttributes rttr) {
       
	service.register(dto);
       rttr.addFlashAttribute("result","success");
       return "redirect:/todo2/list";
	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri, 
			Model model ) {
	
		log.info("list" + cri);
		
		model.addAttribute("list", service.list(cri)); 
	}
	
	
	@GetMapping("/view")
	public void view(TodoDTO dto, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("todo", service.get(dto.getTno()));
		
		
	}
	
	@PostMapping
	public String removePost(TodoDTO dto, RedirectAttributes rttr) {
		
		service.remove(dto.getTno());
		rttr.addFlashAttribute("result", "delsuccess");
		
		return "redirect:/todo2/list";
	}
	
	@GetMapping("/modify")
	public void modify(TodoDTO dto, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("todo", service.get(dto.getTno()));
		 view(dto, cri, model);
	}
	@PostMapping("/modify")
	public String modifyPost(TodoDTO dto, Criteria cri, RedirectAttributes rttr) {
		service.modify(dto);
		
		rttr.addAttribute("tno", dto.getTno());
		rttr.addAttribute("page", cri.getPage());
		rttr.addFlashAttribute("result", "modsuccess");
		return "redirect:/todo2/view";
	}
	
}
