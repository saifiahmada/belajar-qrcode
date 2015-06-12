package com.saifiahmada.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saifiahmada.spring.util.Generate;

@Controller
@RequestMapping(value = "/qrcode")
public class QrcodeController {
	
	@ModelAttribute("page")
	public String page() {
		return "qrcode";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("image", null);
		return "qrcode";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("teks") String teks, Model model){
		
		String namaFile = getNamaFile();
		
		String [] textArray = new String [2];
		textArray[0] = teks;
		textArray[1] = namaFile;
		Generate.createQRCode(textArray);
		String image = "/qrcode/"+namaFile+".PNG";
		model.addAttribute("image", image);
		model.addAttribute("nama", namaFile);
		model.addAttribute("teks", teks);
		return "qrcode";
	}
	
	private String getNamaFile(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssS");
		return sdf.format(new Date());
	}
	
	


}
