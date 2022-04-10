package com.example.yakuzo2.data;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ShainData {
	private String shain_code ="";
	private String shain_name = "";
	private String shain_name_kana = "";
	private String password = "";
	private String password2 = "";
	private String shain = ""; //社員コード、社員名、社員かな　どれでもうけとる
	private String login_flg = "";
	private String mail_address = "";
	private List<Map<String, Object>> kengen_list;
	private String kengen_code="";
	private String biko = "";
	private String delete_flg="";
	private List<Map<String, Object>> list;
	private int page = 0;
	private String created_on = "";
	private String created_by = "";
	private String title = "";
	private String button = "";
	private String disabled = "";
}
