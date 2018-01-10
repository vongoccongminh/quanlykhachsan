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
import com.httt.model.Tinhtrangphong;
import com.httt.service.ChitietdpService;
import com.httt.service.TinhtrangphongService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class TinhtrangphongController {
	@Autowired
	private TinhtrangphongService tinhtrangphongService;
	//public void save(Em)
	@GetMapping("/updatephong")
	public String demo1(Model model)
	{
		System.out.println("meobach");


		Tinhtrangphong tinhtrang=new Tinhtrangphong();
		tinhtrang.setMaphong(ChitietdpController.maphong);
		tinhtrang.setTinhtrang("con trong");
		tinhtrangphongService.save(tinhtrang);


		//List<Chitietdp> chitiet=(List)chitietdpService.findChitietdp(ThongtindatphongController.ma_dp);

		//System.out.println(chitiet.toArray());



		return "redirect:/thongtinhuydatphong1";
	}
	@GetMapping("/tinhtrang")
	public String index(Model model)
	{
		model.addAttribute("tinhtrangphongs", tinhtrangphongService.findAll());
		return "tinhtrang";
	}



}
