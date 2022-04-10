package com.example.yakuzo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.yakuzo2.data.ShainData;
import com.example.yakuzo2.service.ShainService;

@Controller
public class ShainController {
	@Autowired
	ShainService ss;

	@GetMapping("/mst_shain")
	public String index(@ModelAttribute("sd") ShainData sd, Model model) {
		ss.getKengenData(sd);
		return "mst_shain";
	}

	@PostMapping("/dispShinki")
	public String getList(@ModelAttribute("sd") ShainData sd, Model model) {

		ss.getKengenData(sd);
		sd.setTitle("社員データ新規作成");
		sd.setButton("<button onclick = \"registShinki() \">登録</button>");
		return "operateShain";
	}



}
