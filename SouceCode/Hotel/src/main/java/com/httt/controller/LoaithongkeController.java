package com.httt.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.httt.model.Loaithongke;
import com.httt.service.LoaithongkeService;

@Controller
public class LoaithongkeController {

	@Autowired
	private LoaithongkeService loaithongkeService;
	
	@GetMapping("/loaithongke")
	public String index(Model model) {
		model.addAttribute("loaithongke", loaithongkeService.findAll());
		return "loaithongke";
	}
	
	@GetMapping("/loaithongke/create")
	public String create(Model model) { 
		model.addAttribute("loaithongke", new Loaithongke());
		return "addLoaithongke";
	}
	
	@PostMapping(value="/loaithongke/save")
	public String save(@Valid Loaithongke loaithongke, BindingResult result, RedirectAttributes redirect) {
			
		loaithongkeService.save(loaithongke);
		redirect.addFlashAttribute("success", "Lưu loại thống kê thành công!");
		return "redirect:/loaithongke";
	}
	
	@GetMapping("/loaithongke/{id}/detail")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("loaithongke", loaithongkeService.findOne(id));
		return "detailLoaithongke";
	}
	
	@GetMapping("/loaithongke/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("loaithongke", loaithongkeService.findOne(id));
		return "editLoaithongke";
	}
	
	@GetMapping("/loaithongke/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		loaithongkeService.delete(id);
		redirect.addFlashAttribute("success", "Xóa loại thống kê thành công!");
		return "redirect:/loaithongke";
	}
	
	@GetMapping("/loaithongke/search")
	public String search(@RequestParam("s") int s, Model model) {
		model.addAttribute("loaithongke", loaithongkeService.search(s));
		return "loaithongke";
	}
}
