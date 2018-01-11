package com.httt.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.httt.model.LoaiKhachHang;
import com.httt.service.LoaiKhachHangService;

@Controller
public class LoaiKhachHangController {

	
	@Autowired
	private LoaiKhachHangService loaikhachhangService;
	
	@GetMapping({"/loaikhachhang","/"})
	public String index(Model model) 
	{
		model.addAttribute("loaikhachhangs", loaikhachhangService.findAll());
		return "loaikhachhang";
	}
	
	@GetMapping("/loaikhachhang/create")
	public String create(Model model) {
		
		model.addAttribute("loaikhachhang", new LoaiKhachHang());
		return "themLoaiKhachHang";
	}
	
	@GetMapping("/loaikhachhang/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("loaikhachhang", loaikhachhangService.findOne(id));
		return "suaLoaiKhachHang";
	}
	
	@GetMapping("/loaikhachhang/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		loaikhachhangService.delete(id);
		redirect.addFlashAttribute("success", "Xóa loại khách hàng thành công!");
		return "redirect:/loaikhachhang";
	}
	
	
	@PostMapping("/loaikhachhang/save")
	public String save(@Valid LoaiKhachHang loaikhachhang, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			redirect.addFlashAttribute("failed", "Thêm loại khách hàng không thành công, vui lòng thử lại!");
			return "themLoaiKhachHang";
		}
		
		
		loaikhachhangService.save(loaikhachhang);
		redirect.addFlashAttribute("success", "Lưu loại khách hàng thành công!");
		return "redirect:/loaikhachhang";
	}
	
}

