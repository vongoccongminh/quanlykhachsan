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

import com.httt.model.DatPhong;
import com.httt.service.DatPhongService;

@Controller
public class DatPhongController {
	@Autowired
	private DatPhongService datphongService;

	@GetMapping("/datphong")
	public String index(Model model) {
		model.addAttribute("datphongs", datphongService.findAll());
		return "listDatPhong";
	}

	@GetMapping("/datphong/create")
	public String create(Model model) {
		model.addAttribute("datphong", new DatPhong());
		return "DatPhong";
	}

	@GetMapping("/datphong/{madp}/edit")
	public String edit(@PathVariable int madp, Model model) {
		model.addAttribute("datphong", datphongService.findOne(madp));
		return "DatPhong";
	}

	@PostMapping("/datphong/save")
	public String save(@Valid DatPhong datphong, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "DatPhong";
		}
		datphongService.save(datphong);
		redirect.addFlashAttribute("success", "Saved thong tin dat phong successfully!");
		return "redirect:/datphong";
	}

	@GetMapping("/datphong/{madp}/delete")
	public String delete(@PathVariable int madp, RedirectAttributes redirect) {
		datphongService.delete(madp);
		redirect.addFlashAttribute("success", "Deleted thong tin dat phong successfully!");
		return "redirect:/datphong";
	}

	@GetMapping("/datphong/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/datphong";
		}
		int madp=Integer.parseInt(s);
		model.addAttribute("datphongs", datphongService.search(madp));
		return "listDatPhong";
	}
}