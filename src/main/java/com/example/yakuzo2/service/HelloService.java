package com.example.yakuzo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yakuzo2.data.HelloData;
import com.example.yakuzo2.repo.TorihikisakiRepo;

@Service
public class HelloService {

	@Autowired
	private TorihikisakiRepo tr;

	public void setData(HelloData hd) {
		hd.setMsg("Hello new Spring World!");
		hd.setMsg2("You are using Service Class now.");
		hd.setMsg3("This is Message by Spring MVC.");
		hd.setMsg4("This is Message with Spring Class");
		hd.setList1(tr.getTempoData());
		hd.setList2(tr.getTonyaData());

	}

}
