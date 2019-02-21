package com.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.domain.posts.BoardRepository;
import com.common.domain.posts.BoardVO2;
import com.common.domain.posts.LangVORepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private BoardRepository boardVORepo;
	
	@GetMapping("/")
	public String main(Model model) {
		
		List<BoardVO2> voList =boardVORepo.findAll();
		
		model.addAttribute("voList", voList);
		return "home";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoard(Model model) {
		
		return "boardDetail";
	}

	@RequestMapping(value = "/writeBoardAct", method = RequestMethod.POST)
	public String writeBoardAct(Model model,BoardVO2 vo) {
		
		boardVORepo.save(vo);
		//write 글
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(Model model,BoardVO2 vo) {
		
		boardVORepo.deleteById(vo.getId());
		//write 글
		
		return "redirect:";
	}
	
	@GetMapping("/detailBoard")
	public String detailBoard(Model model,int id) {
		
		model.addAttribute("vo", boardVORepo.getOne(id));
		return "boardDetail2";
	}
	
	
	@GetMapping("/callback")
	public String callback() {
		System.out.println("redirecting to home page");
		return "/home";
	}

}
