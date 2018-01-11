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

import com.httt.service.ThongTinThuePhongService;
import com.httt.model.ThongTinThuePhong;

@Controller
public class ThongTinThuePhongController {
	@Autowired
	private ThongTinThuePhongService ThongTinThuePhongService;

	@GetMapping({"/ThongTinThuePhong","/"})
	public String index(Model model) 
	{
		model.addAttribute("ThongTinThuePhongs", ThongTinThuePhongService.findAll());
		return "ThongTinThuePhong";
	}

	@GetMapping("/ThongTinThuePhong/create")
	public String create(Model model) { 
		model.addAttribute("ThongTinThuePhong", new ThongTinThuePhong());
		return "addThongTinThuePhong";
	}

	@GetMapping("/ThongTinThuePhong/{matp}/edit")
	public String edit(@PathVariable int matp, Model model) {
		model.addAttribute("ThongTinThuePhong", ThongTinThuePhongService.findOne(matp));
		return "editThongTinThuePhong";
	}
	
	
	@GetMapping("/ThongTinThuePhong/{matp}/detail")
	public String detail(@PathVariable int matp, Model model) {
		model.addAttribute("ThongTinThuePhong", ThongTinThuePhongService.findOne(matp));
		return "ThongTinThuePhongDetail";
	}

	@PostMapping("/ThongTinThuePhong/save")
	public String save(@Valid ThongTinThuePhong ThongTinThuePhong, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			redirect.addFlashAttribute("failed", "Không thể tạo thông tin thuê phòng, vui lòng thử lại!");
			return "addThongTinThuePhong";
		}
				
		ThongTinThuePhongService.save(ThongTinThuePhong);
		redirect.addFlashAttribute("success", "Đã lưu thông tin thuê phòng thành công!");
		return "redirect:/ThongTinThuePhong";
	}

	@GetMapping("/ThongTinThuePhong/{matp}/delete")
	public String delete(@PathVariable int matp, RedirectAttributes redirect) {
		ThongTinThuePhongService.delete(matp);
		redirect.addFlashAttribute("success", "Đã xóa thông tin thuê phòng thành công!");
		return "redirect:/ThongTinThuePhong";
	}

	@GetMapping("/ThongTinThuePhong/search")
	public String search(@RequestParam("s") int s, Model model) {
		model.addAttribute("ThongTinThuePhongs", ThongTinThuePhongService.search(s));
		return "ThongTinThuePhong";
	}
}