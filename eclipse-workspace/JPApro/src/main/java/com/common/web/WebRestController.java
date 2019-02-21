package com.common.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.domain.dto.posts.PostsSaveRequestDto;
import com.common.domain.posts.Hello;
import com.common.domain.posts.HelloRepository;
import com.common.domain.posts.LangVO;
import com.common.domain.posts.LangVORepository;
import com.common.domain.posts.PostsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsRepository postsRepository;
	private LangVORepository LangVORepo;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello :)";
	}
	
	@RequestMapping("/add")
	public LangVO add(LangVO vo) {

		LangVO LangData = LangVORepo.save(vo);
		return LangData;
	}
 
	@RequestMapping("/api/Langlist")
	public List<LangVO> list(Model model) {

		List<LangVO> LangList = LangVORepo.findAll();

		return LangList;
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		System.out.println("savePosts start;");
		postsRepository.save(dto.toEntity());
	}
	
	@GetMapping("/pos")
	public void pos(@RequestBody PostsSaveRequestDto dto) {
		System.out.println("pos start;");
		postsRepository.save(dto.toEntity());
	}
}
