package com.example.yakuzo2.data;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class LoginData {

	private String shain_code="";
	private String shain_name="";
	private String password  = "";
    private String tempo_code = "";
    private String tempo_name = "";
    private String kengen_code="";
    private String kengen_name="";
    private String msg = "";
    private List<Map<String, Object>> tempo_list;

}
