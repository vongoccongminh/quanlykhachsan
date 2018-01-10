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

import com.httt.model.Department;
import com.httt.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping({ "/department" })
	public String index(Model model) {
		model.addAttribute("departments", departmentService.findAll());
		return "department";
	}

	@GetMapping("/department/create")
	public String create(Model model) {
		model.addAttribute("department", new Department());
		return "adddepartment";
	}

	@GetMapping("/department/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("department", departmentService.findOne(id));
		return "editDepartment";
	}

	@GetMapping("/department/{id}/detail")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("department", departmentService.findOne(id));
		return "departmentDetail";
	}

	@GetMapping("/department/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		departmentService.delete(id);
		redirect.addFlashAttribute("success", "Deleted dept successfully!");
		return "redirect:/department";
	}

	@GetMapping("/department/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals(""))
			return "redirect:/department";
		model.addAttribute("departments", departmentService.search(s));
		return "department";
	}

	@PostMapping("/department/save")
	public String save(@Valid Department department, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			redirect.addFlashAttribute("failed", "Can not create dept, please try again!");
			return "addDepartment";
		}

		departmentService.save(department);
		redirect.addFlashAttribute("success", "Saved dept successfully!");
		return "redirect:/department";
	}

}