package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.BaoCaoService;

@Controller
public class BaoCaoController {
	@Autowired
	private BaoCaoService baocaoService;
	
	@GetMapping("/baocao")
	public String baocao(Model model) {
		model.addAttribute("baocao", baocaoService.findAll());
		return "list";
	}
	
}
