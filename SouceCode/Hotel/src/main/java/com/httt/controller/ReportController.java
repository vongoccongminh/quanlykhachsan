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


import com.httt.model.Report;
import com.httt.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService reportService;
	

	@GetMapping("/report")
	public String index(Model model) {
		model.addAttribute("reports", reportService.findAll());
		return "report";
	}
	
	@GetMapping("/report/create")
	public String create(Model model) { 
		model.addAttribute("report", new Report());
		return "addReport";
	}
	
	@GetMapping("/report/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("report", reportService.findOne(id));
		return "editReport";
	}

	@GetMapping("/report/{id}/detail")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("report", reportService.findOne(id));
		return "reportDetail";
	}
	
	@GetMapping("/report/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		reportService.delete(id);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/report";
	}

	@GetMapping("/report/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) 
			return "redirect:/report";
		model.addAttribute("reports", reportService.search(s));
		return "report";
	}
	
	@PostMapping("/report/save")
	public String save(@Valid Report report, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			redirect.addFlashAttribute("failed", "Can not create report, please try again!");
			return "addReport";
		}
		
				
		reportService.save(report);
		redirect.addFlashAttribute("success", "Saved report successfully!");
		return "redirect:/report";
	}
	

 
	
}
