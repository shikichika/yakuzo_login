package com.example.yakuzo2.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yakuzo2.data.ShainData;
import com.example.yakuzo2.repo.KengenRepo;
import com.example.yakuzo2.repo.ShainRepo;

@Service
public class ShainService {

	@Autowired
	KengenRepo kr;
	@Autowired
	ShainRepo sr;

	public void getKengenData(ShainData sd) {
		sd.setKengen_list(kr.getKengenSelect());
	}

	public int getPages(ShainData sd) {
		//System.out.println(Math.ceil(sr.getPages(sd)/25));
		return (int)Math.ceil(sr.getPages(sd)/25);
	}

	public String getList(ShainData sd) {
		sr.getList(sd);
		StringBuilder html = new StringBuilder();
		html.append("<table class = 'table table-bordered table-striped'>");
		html.append("<tr>");
		html.append("<th>社員コード</th><th>社員名</th><th>ログインプラグ</th><th>メールアドレス</th>");
		html.append("<th>権限</th><th>削除フラグ</th><th>編集</th><th>削除</th>");
		html.append("</tr>");
		for(Map<String, Object> map : sd.getList()) {
			html.append("<tr>");
			html.append("<td>"+map.get("shain_code")+"</td>");
			html.append("<td>"+map.get("shain_name")+"</td>");
			html.append("<td>"+map.get("login_flg")+"</td>");
			html.append("<td>"+map.get("mail_address")+"</td>");
			html.append("<td>"+map.get("kengen_name")+"</td>");
			html.append("<td>"+map.get("delete_flg")+"</td>");
			html.append("<td><button onclick =\"editShain("+map.get("shain_code")+")\">編集</td>");
			html.append("<td><button onclick =\"delShain("+map.get("shain_code")+")\">削除</td>");
			html.append("</tr>");

		}

		html.append("</table>");
		return html.toString();
	}

}
