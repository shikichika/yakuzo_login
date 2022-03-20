package com.example.yakuzo2.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KengenRepo {

	@Autowired
	JdbcTemplate jt;

	public List<Map<String, Object>> getKengenSelect(){

		String sql = "select kengen_code, kengen_name from mst_kengen where delete_flg = '0' ";
		return jt.queryForList(sql);

	}

}
