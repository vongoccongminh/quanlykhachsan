package com.httt.controller;

import java.util.List;

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

import com.httt.model.Dichvu;
import com.httt.service.DichvuService;
import com.httt.model.Loaidichvu;
import com.httt.service.LoaidichvuService;

@Controller
public class DichvuController {
	@Autowired
	private DichvuService DichvuService;
	
	@Autowired
	private LoaidichvuService LoaidichvuService;

	@GetMapping("/dichvu")
	public String index(Model model) {
		model.addAttribute("Dichvus", DichvuService.findAll());
		return "DanhSachDichVu";
	}

	@GetMapping("/dichvu/create")
	public String create(Model model) {
		List<Loaidichvu> listLDV = (List<Loaidichvu>) this.LoaidichvuService.findAll();
		model.addAttribute("listLDV", listLDV);
		
		model.addAttribute("Dichvu", new Dichvu());
		return "ChiTietDichVu";
	}

	@GetMapping("/dichvu/{maDV}/edit")
	public String edit(@PathVariable int maDV, Model model) {
		List<Loaidichvu> listLDV = (List<Loaidichvu>) this.LoaidichvuService.findAll();
		model.addAttribute("listLDV", listLDV);
		
		model.addAttribute("Dichvu", DichvuService.findOne(maDV));
		return "ChiTietDichVu";
	}

	@PostMapping("/dichvu/save")
	public String save(@Valid Dichvu Dichvu, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "ChiTietDichVu";
		}
		DichvuService.save(Dichvu);
		redirect.addFlashAttribute("success", "Saved service successfully!");
		return "redirect:/dichvu";
	}

	@GetMapping("/dichvu/{maDV}/delete")
	public String delete(@PathVariable int maDV, RedirectAttributes redirect) {
		DichvuService.delete(maDV);
		redirect.addFlashAttribute("success", "Deleted service successfully!");
		return "redirect:/dichvu";
	}

	@GetMapping("/dichvu/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/dichvu";
		}

		model.addAttribute("Dichvus", DichvuService.search(s));
		return "DanhSachDichVu";
	}
}
