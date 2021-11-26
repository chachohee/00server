package org.it.controller;

import org.it.domain.Criteria;
import org.it.domain.PageDTO;
import org.it.domain.PlayListVO;
import org.it.service.PlayListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/music/*")
@AllArgsConstructor
public class PlayListController {
	
	private PlayListService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		model.addAttribute("list", service.getList(cri)); 
		
		int total = service.getTotal(cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri,total));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(PlayListVO playlist, RedirectAttributes rttr) {
				
		service.register(playlist);
		
		rttr.addFlashAttribute("result",playlist.getPno());
		
		return "redirect:/music/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("pno") Long pno, @ModelAttribute("cri") Criteria cri ,Model model) {
		
		model.addAttribute("playlist", service.get(pno));
		model.addAttribute("cri", cri);
	}
	
	@PostMapping("/modify")
	public String modify(PlayListVO playlist, @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
		
		if(service.modify(playlist)) {
			rttr.addFlashAttribute("result", "succes");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/music/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") Long pno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		if(service.remove(pno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/music/list";
		
	}


}
