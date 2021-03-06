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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.httt.model.ThietBi;
import com.httt.service.ThietBiService;
import com.httt.model.LoaiThietBi;
import com.httt.service.LoaiThietBiService;
import com.httt.model.Phong;
import com.httt.service.PhongService;

@Controller
public class ThietBiController {
	@Autowired
	private ThietBiService thietBiService;
	
	@Autowired
	private LoaiThietBiService loaiThietBiService;
	
	@Autowired
	private PhongService phongService;
	

	@GetMapping({"/thietbi"})
	public String index(Model model) 
	{
		model.addAttribute("thietbis", thietBiService.findAll());
		return "thietBi";
	}
	
	@GetMapping("/thietbi/{id}/xoa")
	public String delete(@PathVariable int id, RedirectAttributes redirect)
	{	
		thietBiService.delete(id);
		redirect.addFlashAttribute("success", "Đã xóa thành công thiết bị.");
		return "redirect:/thietbi";
	}
	
	@PostMapping("/thietbi/luu")
	public String save(@Valid ThietBi thietbi, BindingResult result, RedirectAttributes redirect)
	{
		
		//thietbi.SetTenTB("nguyenhihih");
		System.out.println("day la ten thiet bi");
		//System.out.println(thietbi.getTenTB());
		if(result.hasErrors())
		{
			redirect.addFlashAttribute("failed", "Không thể thêm thiết bị mới.");
			return "thietbiform";
		}
		
		
			thietBiService.save(thietbi);
			redirect.addFlashAttribute("success", "Đã lưu thiết bị mới thành công.");
			
			return "redirect:/thietbi";	
		

	}
	
	@GetMapping("/thietbi/tao")
	public String create(Model model) {
		
		List <LoaiThietBi> listLTB = (List<LoaiThietBi>)this.loaiThietBiService.findAll();
		model.addAttribute("loaithietbis", listLTB);
		
		List <Phong> listPhong = (List<Phong>)this.phongService.findAll();
		model.addAttribute("phongs", listPhong);
		
		
				
		model.addAttribute("thietbi", new ThietBi());
		return "thietbiform";
	}
	
	@GetMapping("/thietbi/{id}/sua")
	public String edit(@PathVariable int id, Model model)
	{
		System.out.println("Day la id");
		System.out.println(id);
		model.addAttribute("thietbi", thietBiService.findOne(id));
		return "thietbiDetail";
	}
	
	@GetMapping("/thietbi/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/thietbi";
		}
		
		model.addAttribute("thietbis", thietBiService.search(s));
		return "thietbi";
	}
	
}
