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

import com.httt.model.Thongke;
import com.httt.service.ThongkeService;

@Controller
public class ThongkeController {
	@Autowired
	private ThongkeService thongkeService;
	
	@GetMapping("/thongke")
	public String index(Model model) {
		model.addAttribute("thongke", thongkeService.findAll());
		return "thongke";
	}
	
	@GetMapping("/thongke/create")
	public String create(Model model) { 
		model.addAttribute("thongke", new Thongke());
		return "addThongke";
	}
	
	@PostMapping(value="/thongke/save")
	public String save(@Valid Thongke thongke, BindingResult result, RedirectAttributes redirect) {
			
		thongkeService.save(thongke);
		redirect.addFlashAttribute("success", "Lưu thành công!");
		return "redirect:/thongke";
	}
	
	@GetMapping("/thongke/{id}/detail")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("thongke", thongkeService.findOne(id));
		return "detailThongke";
	}
	
	@GetMapping("/thongke/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("thongke", thongkeService.findOne(id));
		return "editThongke";
	}
	
	@GetMapping("/thongke/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		thongkeService.delete(id);
		redirect.addFlashAttribute("success", "Xóa thống kê thành công!");
		return "redirect:/thongke";
	}
	
	@GetMapping("/thongke/search")
	public String search(@RequestParam("s") int s, Model model) {
		model.addAttribute("thongke", thongkeService.search(s));
		return "thongke";
	}
}
