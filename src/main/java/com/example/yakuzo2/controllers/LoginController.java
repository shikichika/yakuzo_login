package com.example.yakuzo2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.yakuzo2.data.LoginData;
import com.example.yakuzo2.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService ls;

	@Autowired
	HttpSession session;

	@GetMapping("/")
	public String login(@ModelAttribute ("ld") LoginData ld, Model model) {
		ls.getTempoList(ld);
		//System.out.println("model="+model.toString());
		return "login";

	}

	@PostMapping("/putLogin")
	public String putLogin(@ModelAttribute ("ld") LoginData ld, Model model) {

		ls.getTempoList(ld);
		System.out.println("model="+model.toString());
		if(!ls.checkLogin(ld)) {
			return "login";
		}
		session.setMaxInactiveInterval(0);
		session.setAttribute("login_shain_code", ld.getShain_code());
		session.setAttribute("login_shain_name", ld.getShain_name());
		session.setAttribute("login_kengen_code", ld.getKengen_code());
		session.setAttribute("login_kengen_name", ld.getKengen_name());
		session.setAttribute("login_tempo_code", ld.getTempo_code());
		session.setAttribute("login_tempo_name", ld.getTempo_name());

		return "redirect:/menu";

	}

}
