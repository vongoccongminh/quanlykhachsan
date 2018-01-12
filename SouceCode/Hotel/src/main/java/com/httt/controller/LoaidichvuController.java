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

import com.httt.model.Loaidichvu;
import com.httt.service.LoaidichvuService;

@Controller
public class LoaidichvuController {
	@Autowired
	private LoaidichvuService LoaidichvuService;

	@GetMapping("/loaidichvu")
	public String index(Model model) {
		model.addAttribute("Loaidichvus", LoaidichvuService.findAll());
		return "DanhSachLoaiDichVu";
	}

	@GetMapping("/loaidichvu/create")
	public String create(Model model) {
		model.addAttribute("Loaidichvu", new Loaidichvu());
		return "ChiTietLoaiDichVu";
	}

	@GetMapping("/loaidichvu/{maLDV}/edit")
	public String edit(@PathVariable int maLDV, Model model) {
		model.addAttribute("Loaidichvu", LoaidichvuService.findOne(maLDV));
		return "ChiTietLoaiDichVu";
	}

	@PostMapping("/loaidichvu/save")
	public String save(@Valid Loaidichvu Loaidichvu, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "ChiTietLoaiDichVu";
		}
		LoaidichvuService.save(Loaidichvu);
		redirect.addFlashAttribute("success", "Saved service successfully!");
		return "redirect:/loaidichvu";
	}

	@GetMapping("/loaidichvu/{maLDV}/delete")
	public String delete(@PathVariable int maLDV, RedirectAttributes redirect) {
		LoaidichvuService.delete(maLDV);
		redirect.addFlashAttribute("success", "Deleted service successfully!");
		return "redirect:/loaidichvu";
	}

	@GetMapping("/loaidichvu/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/loaidichvu";
		}

		model.addAttribute("Loaidichvus", LoaidichvuService.search(s));
		return "DanhSachLoaiDichVu";
	}
}