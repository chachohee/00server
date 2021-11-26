package org.it.controller;

import org.it.domain.BoardVO;
import org.it.domain.Criteria;
import org.it.domain.PageDTO;
import org.it.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;

//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list");
//		model.addAttribute("list", service.getList());
//	}
	//페이징 적용 후
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("목록:"+cri);
		model.addAttribute("list", service.getList(cri)); //현재 보고 있는 페이지랑 그 페이지의 게시물 수
		//model.addAttribute("pageMaker", new PageDTO(cri,123));
		
		int total = service.getTotal(cri);
		log.info("전체 게시물 수 :"+total);
		
		model.addAttribute("pageMaker", new PageDTO(cri,total));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}//입력페이지 볼 수 있도록 / get이랑 post있으면 겟 먼저 실행하고 그 다음에 포스트 찾음
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("등록:"+board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result",board.getBno());//목록화면으로 돌아갈 때 새로운 bno번호를 가지고 감
		
		return "redirect:/board/list";
		//등록이 끝난 후에 다시 목록 화면으로
		// redirect: -> response.sendRedirect
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri ,Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
		model.addAttribute("cri", cri);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
		log.info("수정:"+board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "succes");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("삭제:"+bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
		
	}

}
