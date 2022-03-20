package com.example.yakuzo2.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.yakuzo2.data.MenuData;

@Repository
public class MenuRepo {
	@Autowired
	JdbcTemplate jt;

	public void getMenu(String kengen_code, MenuData md) {
		StringBuilder sql = new StringBuilder();
		sql.append("select mm.menu_name, ");
		sql.append("mm.menu_uri ");
		sql.append("from mst_menu_kengen mk join mst_menu mm ");
		sql.append("on mk.menu_code = mm.menu_code ");
		sql.append("where mk.delete_flg = '0' ");
		sql.append("and mk.kengen_code = ?");
		sql.append("and mm.menu_kbn = ?");
		sql.append("order by mk.hyoji_jun");

		md.setGyoumuList(jt.queryForList(sql.toString(), kengen_code, "01"));
		md.setStockList(jt.queryForList(sql.toString(), kengen_code, "02"));
		md.setSystemList(jt.queryForList(sql.toString(), kengen_code, "03"));

	}

}
