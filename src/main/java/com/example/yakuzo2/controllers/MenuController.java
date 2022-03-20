package com.example.yakuzo2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.yakuzo2.data.MenuData;
import com.example.yakuzo2.repo.MenuRepo;

@Controller
public class MenuController {

	@Autowired
	HttpSession session;

	@Autowired
	MenuRepo mr;

	@GetMapping("/menu")
	public String dispMenu(@ModelAttribute("md") MenuData md, Model model) {
		mr.getMenu(session.getAttribute("login_kengen_code").toString(), md);
		return "menu";

	}

}
