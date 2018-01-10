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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.httt.model.Department;
import com.httt.model.Employee;
import com.httt.service.DepartmentService;
import com.httt.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;

	@GetMapping({"/employee"})
	public String index(Model model) 
	{
		List<Department> listDepartment = (List<Department>) this.departmentService.findAll();
		model.addAttribute("listDepartment", listDepartment);
		model.addAttribute("employees", employeeService.findAll());
		return "employee";
	}

	@GetMapping("/employee/create")
	public String create(Model model) { 
		List<Department> listDepartment = (List<Department>) this.departmentService.findAll();
		model.addAttribute("listDepartment", listDepartment);
		model.addAttribute("employee", new Employee());
		
		return "addEmployee";
	}

	@GetMapping("/employee/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		List<Department> listDepartment = (List<Department>) this.departmentService.findAll();
		model.addAttribute("listDepartment", listDepartment);
		model.addAttribute("employee", employeeService.findOne(id));
		return "editEmployee";
	}
	
	
	@GetMapping("/employee/{id}/detail")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.findOne(id));
		return "employeeDetail";
	}

	@PostMapping("/employee/save")
	public String save(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			redirect.addFlashAttribute("failed", "Can not create employee, please try again!");
			return "addEmplyee";
		}
		
		int id = employee.getId();
		
		if( id > 0 ) {
			id = employee.getId();
			Employee tempEmployee = employeeService.findOne(id);
			
			employee.setPasswords(tempEmployee.getPasswords());
			employeeService.save(employee);
			System.out.println("ko");
			
			return "redirect:/employee";
		}
		
		//hash passwords
		String passwords = employee.getPasswords();
		System.out.println(passwords);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(passwords);
		employee.setPasswords(hashedPassword);
		
		employeeService.save(employee);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		return "redirect:/employee";
	}

	@GetMapping("/employee/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		employeeService.delete(id);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/employee";
	}

	@GetMapping("/employee/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) 
			return "redirect:/employee";
		model.addAttribute("employees", employeeService.search(s));
		return "employee";
	}
}