package com.example.yakuzo2.data;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MenuData {

	private List<Map<String, Object>> gyoumuList;
	private List<Map<String, Object>> stockList;
	private List<Map<String, Object>> systemList;

}
