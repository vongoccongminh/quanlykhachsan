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

import com.httt.model.Phong;
import com.httt.service.PhongService;
import com.httt.service.TinhTrangPhongService;
import com.httt.service.LoaiPhongService;

@Controller
public class PhongController {
	
	@Autowired
	private PhongService phongService;
	
	@Autowired
	private LoaiPhongService loaiphongService;

	@Autowired
	private TinhTrangPhongService tinhtrangphongService;
	
	@GetMapping("/phong")
	public String index(Model model) {
		model.addAttribute("phongs", phongService.findAll());
		return "danhsachphong";
	}
	
	@GetMapping("/phong/create")
	public String create(Model model) {
        model.addAttribute("phong", new Phong());
		model.addAttribute("loaiphongs", loaiphongService.findAll() );
		return "themphong";
	}
	
	@PostMapping("/phong/save")
	public String save(@Valid Phong phong, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "themphong";
		}
		phongService.save(phong);
		redirect.addFlashAttribute("success", "Saved phong successfully!");
		return "redirect:/phong";
	}
	
	@GetMapping("/phong/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/phong";
		}

		model.addAttribute("phongs", phongService.search(s));
		return "danhsachphong";
	}
	
	@GetMapping("/phong/chitietphong/{id}")
	public String chitietphong(@PathVariable int id, Model model) {
		Phong xxx = phongService.findOne(id);
		model.addAttribute("phong", xxx);
		int maloai = xxx.getMaloai();
		model.addAttribute("loaiphongs", loaiphongService.layloaiphong(maloai));
		model.addAttribute("tinhtrangphongs", tinhtrangphongService.laytinhtrang(id));
		return "chitietphong";
	}
	
	
	@GetMapping("/phong/editphong/{id}")
	public String edit(@PathVariable int id, Model model) {
		Phong xxx = phongService.findOne(id);
		model.addAttribute("phong", xxx);
		int maloai = xxx.getMaloai();
		model.addAttribute("loaiphongs", loaiphongService.layloaiphong(maloai));
		model.addAttribute("tinhtrangphongs", tinhtrangphongService.laytinhtrang(id));
		model.addAttribute("loaiphongalls", loaiphongService.findAll());
		return "editphong";
	}
	
	
	
	@GetMapping("/phong/xemlichsu/{id}")
	public String xemlichsu(@PathVariable int id, Model model) {
		model.addAttribute("tinhtrangphongs", tinhtrangphongService.layphong(id));
		return "xemlichsu";
	}
}
