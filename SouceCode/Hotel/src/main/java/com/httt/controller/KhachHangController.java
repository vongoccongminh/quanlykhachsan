package com.httt.controller;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import com.httt.model.KhachHang;
import com.httt.model.LoaiKhachHang;
import com.httt.service.KhachHangService;
import com.httt.service.LoaiKhachHangService;


@Controller
public class KhachHangController {
	@Autowired
	private KhachHangService khachhangService;
	
	@Autowired
	private LoaiKhachHangService loaikhachhangService;
	

	@GetMapping({"/khachhang","/"})
	public String index(Model model) 
	{
		model.addAttribute("khachhangs", khachhangService.findAll());
		return "khachhang";
	}
	
	@GetMapping("/khachhang/create")
	public String create(Model model) {
		
		List<LoaiKhachHang> listLKH = (List<LoaiKhachHang>) this.loaikhachhangService.findAll();
		model.addAttribute("listLKH", listLKH);
		
		model.addAttribute("khachhang", new KhachHang());
		return "themKhachHang";
	}
	
	@GetMapping("/khachhang/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		List<LoaiKhachHang> listLKH = (List<LoaiKhachHang>) this.loaikhachhangService.findAll();
		model.addAttribute("listLKH", listLKH);
		model.addAttribute("khachhang", khachhangService.findOne(id));
		return "suaKhachHang";
	}
	
	@GetMapping("/khachhang/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		khachhangService.delete(id);
		redirect.addFlashAttribute("success", "Xóa khách hàng thành công!");
		return "redirect:/khachhang";
	}
	
	@GetMapping("/khachhang/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/khachhang";
		}
		
		model.addAttribute("khachhangs", khachhangService.search(s));
		return "khachhang";
	}
	
	@PostMapping("/khachhang/save")
	public String save(@Valid KhachHang khachhang, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			redirect.addFlashAttribute("failed", "Thêm khách hàng không thành công, vui lòng thử lại!");
			return "themKhachHang";
		}
		
		
		khachhangService.save(khachhang);
		redirect.addFlashAttribute("success", "Lưu khách hàng thành công!");
		return "redirect:/khachhang";
	}

}
