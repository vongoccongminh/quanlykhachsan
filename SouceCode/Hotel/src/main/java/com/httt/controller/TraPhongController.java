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

import com.httt.model.TraPhong;
import com.httt.service.TraPhongService;

@Controller
public class TraPhongController {
	@Autowired
	private TraPhongService traphongService;

	@GetMapping("/traphong")
	public String index(Model model) {
		model.addAttribute("traphongs", traphongService.findAll());
		return "listTraPhong";
	}

	@GetMapping("/traphong/create")
	public String create(Model model) {
		model.addAttribute("traphong", new TraPhong());
		return "addTraPhong";
	}

	@GetMapping("/traphong/{matp}/edit")
	public String edit(@PathVariable int matp, Model model) {
		model.addAttribute("traphong", traphongService.findOne(matp));
		return "editTraPhong";
	}

	@PostMapping("/traphong/save")
	public String save(@Valid TraPhong traphong, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "addTraPhong";
		}
		traphongService.save(traphong);
		redirect.addFlashAttribute("success", "Saved thong tin tra phong successfully!");
		return "redirect:/traphong";
	}

	@GetMapping("/traphong/{matp}/delete")
	public String delete(@PathVariable int matp, RedirectAttributes redirect) {
		traphongService.delete(matp);
		redirect.addFlashAttribute("success", "Deleted thong tin tra phong successfully!");
		return "redirect:/traphong";
	}

	@GetMapping("/traphong/search")
	public String search(@RequestParam("s") String s, Model model) {
		int id=Integer.parseInt(s);
		model.addAttribute("traphong", traphongService.search(id));
		return "infoTraPhong";
	}
}