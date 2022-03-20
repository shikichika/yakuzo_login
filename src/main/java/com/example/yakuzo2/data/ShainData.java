package com.example.yakuzo2.data;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ShainData {
	private String shain = "";
	private String login_flg = "";
	private List<Map<String, Object>> kengen_list;
	private String kengen_code="";
	private String delete_flg="";
	private List<Map<String, Object>> list;
	private int page = 0;

}
