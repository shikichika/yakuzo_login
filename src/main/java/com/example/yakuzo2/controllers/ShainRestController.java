package com.example.yakuzo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yakuzo2.data.ShainData;
import com.example.yakuzo2.service.ShainService;

@RestController
public class ShainRestController {
	@Autowired
	ShainService ss;

	@PostMapping("/getPages")
	public int getPages(ShainData sd) {
		return ss.getPages(sd);
	}

	@PostMapping("/getList")
	public String getList(ShainData sd) {
		return ss.getList(sd);

	}


}
