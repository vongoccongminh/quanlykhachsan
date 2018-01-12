package com.httt.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;
import java.sql.Timestamp;
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
import com.httt.model.Employee;
import com.httt.model.Loaithongke;
import com.httt.model.Thongke;
import com.httt.model.TinhTrangPhong;
import com.httt.service.DatPhongService;
import com.httt.service.EmployeeService;
import com.httt.service.LoaithongkeService;
import com.httt.service.ThongkeService;
import com.httt.service.TinhTrangPhongService;



@Controller
public class ThongkeController {
	@Autowired
	private ThongkeService thongkeService;
	
	@Autowired
	private LoaithongkeService loaithongkeService;
	
	@Autowired
	private TinhTrangPhongService tinhtrangphongService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DatPhongService datphongService;
	
	
	@GetMapping("/thongke")
	public String index(Model model) {
		List<Loaithongke> listLoaithongke = (List<Loaithongke>) this.loaithongkeService.findAll();
		model.addAttribute("listLoaithongke", listLoaithongke);
		
		List<Employee> listEmployee = (List<Employee>) this.employeeService.findAll();
		model.addAttribute("listEmployee", listEmployee);
		model.addAttribute("thongke", thongkeService.findAll());
		return "thongke";
	}
	
	@GetMapping("/thongke/create")
	public String create(Model model) { 
		
		List<Loaithongke> listLoaithongke = (List<Loaithongke>) this.loaithongkeService.findAll();
		model.addAttribute("listLoaithongke", listLoaithongke);
		
		List<Employee> listEmployee = (List<Employee>) this.employeeService.findAll();
		model.addAttribute("listEmployee", listEmployee);
		
		model.addAttribute("thongke", new Thongke());
		return "addThongke";
	}
	
	@PostMapping(value="/thongke/save")
	public String save(@Valid Thongke thongke, BindingResult result, RedirectAttributes redirect) {	
		
		List<TinhTrangPhong> listTinhtrangphong = (List<TinhTrangPhong>) this.tinhtrangphongService.findAll();
		int slphongduocthue1=0;
		int slphongkhongduocthue1=0;
		
		int slphongduocthue2=0;
		int slphongkhongduocthue2=0;
		
		for (TinhTrangPhong tinhtrangphong : listTinhtrangphong)
		{
			if(tinhtrangphong.getNgay().after(thongke.getNgaybd())==false && tinhtrangphong.getNgay().before(thongke.getNgaybd())==false) {
			
					if(tinhtrangphong.getTinhtrang().equals("con trong") || tinhtrangphong.getTinhtrang().equals("dang sua chua"))
						slphongkhongduocthue1++;
					if(tinhtrangphong.getTinhtrang().equals("da thue"))
						slphongduocthue1++;
			}		
			
			if(tinhtrangphong.getNgay().after(thongke.getNgaykt())==false && tinhtrangphong.getNgay().before(thongke.getNgaykt())==false) {
				
				if(tinhtrangphong.getTinhtrang().equals("con trong") || tinhtrangphong.getTinhtrang().equals("dang sua chua"))
					slphongkhongduocthue2++;
				if(tinhtrangphong.getTinhtrang().equals("dang thue"))
					slphongduocthue2++;
		}		
		}
		
		List<DatPhong> listDatphong = (List<DatPhong>) this.datphongService.findAll();
		int slphongduocdat1=0;
		int slphongduocdat2=0;
		
		for (DatPhong datphong : listDatphong)
		{
			if(datphong.getNgaydp().after(thongke.getNgaybd())==false && datphong.getNgaydp().before(thongke.getNgaybd())==false) {
				slphongduocdat1++;	
			}		
			
			if(datphong.getNgaydp().after(thongke.getNgaykt())==false && datphong.getNgaydp().before(thongke.getNgaykt())==false) {
				slphongduocdat2++;		
		}		
		}
		
		
		
		thongke.setSlphongduocdat1(slphongduocdat1);
		thongke.setSlphongduocdat2(slphongduocdat2);
		thongke.setSlphongduocthue1(slphongduocthue1);
		thongke.setSlphongkhongduocthue1(slphongkhongduocthue1);
		
		thongke.setSlphongduocthue2(slphongduocthue2);
		thongke.setSlphongkhongduocthue2(slphongkhongduocthue2);
		
		thongkeService.save(thongke);
		redirect.addFlashAttribute("success", "Lưu thống kê thành công!");
		return "redirect:/thongke";
	}
	
	@GetMapping("/thongke/{id}/detail")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("thongke", thongkeService.findOne(id));
		return "detailThongke";
	}
	
	@GetMapping("/thongke/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("thongke", thongkeService.findOne(id));
		return "editThongke";
	}
	
	@GetMapping("/thongke/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		thongkeService.delete(id);
		redirect.addFlashAttribute("success", "Xóa thống kê thành công!");
		return "redirect:/thongke";
	}
	
	@GetMapping("/thongke/search")
	public String search(@RequestParam("s") int s, Model model) {
		model.addAttribute("thongke", thongkeService.search(s));
		return "thongke";
	}
}
