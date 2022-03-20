package com.example.yakuzo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yakuzo2.data.LoginData;
import com.example.yakuzo2.repo.LoginRepo;
import com.example.yakuzo2.repo.TorihikisakiRepo;

@Service
public class LoginService {

	@Autowired
	TorihikisakiRepo tr;

	@Autowired
	LoginRepo lr;

	public void getTempoList(LoginData ld) {
		ld.setTempo_list(tr.getTempoData());
	}

	public boolean checkLogin(LoginData ld) {
		if(!lr.checkLogin(ld)) {
			return false;
		}

		if(ld.getKengen_code().equals("001")) {
			ld.setTempo_code("");
			ld.setTempo_name("");
			return true;
		}
		ld.setTempo_name(tr.getTempoName(ld.getTempo_code()));
		return true;

	}
}
