package com.example.demo.controller;

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
import com.httt.model.Thongtindatphong;
import com.httt.model.Data;
import com.httt.model.Thongtinhuydatphong;
import com.httt.service.ThongtinhuydatphongService;
import com.httt.service.ThongtindatphongService;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class ThongtinhuydatphongController {

	@Autowired
	private ThongtinhuydatphongService thongtinhuydatphongService;
	@GetMapping("/thongtinhuydatphong")
	public String index(Model model)
	{

		//thongtinhuydatphongService.insertdata(111, 222, new Date().toString(),"khong nho", 000);
		model.addAttribute("thongtinhuydatphongs",thongtinhuydatphongService.findAll());
		return "thongtinhuydatphong";
	}
	@GetMapping("/thongtinhuydatphong1")
	public String thongtinhuydatphong(Model model)
	{
		Thongtinhuydatphong thongtin=new Thongtinhuydatphong();
		//thongtin.setId(0);
		thongtin.setMadp(ChitietdpController.ma_dp);
		thongtin.setMaphong(ChitietdpController.maphong);
		thongtin.setNgayhuy(new Date());
		thongtin.setNguyennhan("khong");
		thongtin.setManv(333);
		thongtinhuydatphongService.save(thongtin);
		//thongtinhuydatphongService.insertdata(111, 222, new Date().toString(),"khong nho", 000);
		//model.addAttribute("thongtinhuydatphongs",thongtinhuydatphongService.findAll());
		return "redirect:/capnhatthongtindatphong";
	}


}
