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
import com.httt.model.Chitietdp;
import com.httt.service.ChitietdpService;
import com.httt.service.ThongtindatphongService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class ChitietdpController {
	public static int ma_dp;
	public static int gia;
	public static int maphong;
	@Autowired
	private ChitietdpService chitietdpService;
	@GetMapping("/demo")
	public String demo(Model model)
	{
		//List<Chitietdp> chitiet=(List)chitietdpService.findChitietdp(ThongtindatphongController.ma_dp);

		//System.out.println(chitiet.toArray());

		model.addAttribute("chitietdps", chitietdpService.findChitietdp(ThongtindatphongController.ma_dp));

		return "demo";
	}
	@GetMapping("/chitietdatphong")
	public String chitietdatphong(Model model)
	{
		//List<Chitietdp> chitiet=(List)chitietdpService.findChitietdp(ThongtindatphongController.ma_dp);

		//System.out.println(chitiet.toArray());

		model.addAttribute("chitietdps", chitietdpService.findAll());

		return "chitietdatphong";
	}
	@GetMapping("/demo/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		Chitietdp ctdp=chitietdpService.findOne(id);
		ma_dp=ctdp.getMaDP();
		gia=ctdp.getGia();
		maphong=ctdp.getMaphong();
		chitietdpService.delete(id);

		redirect.addFlashAttribute("success", "Huy phong thanh cong");
		return "redirect:/updatephong";
	}


}
