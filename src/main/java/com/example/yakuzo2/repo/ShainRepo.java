package com.example.yakuzo2.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.yakuzo2.data.ShainData;

@Repository
public class ShainRepo {

	@Autowired
	JdbcTemplate jt;

	public double getPages(ShainData sd) {
		List<Object> param = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder();

		sql.append("select count(*) cnt from mst_shain ");
		//社員
		if(!sd.getShain().equals("") ) {
			sql.append(" where (");
			sql.append("shain_code = ?  ");
			sql.append("or shain_name like ?  ");
			sql.append("or shain_name_kana like ?");
			sql.append(") ");
			param.add(sd.getShain());
			param.add("%" + sd.getShain() + "%");
			param.add("%" + sd.getShain() + "%");
		}

		//ログインフラグ
		if(!sd.getLogin_flg().equals("")) {
			if(param.isEmpty()) {
				sql.append("where ");
			} else {
				sql.append("and ");
			}
			sql.append("login_flg = ?  ");
			param.add(sd.getLogin_flg());
		}
		//権限
		if(!sd.getKengen_code().equals("")) {
			if(param.isEmpty()) {
				sql.append("where ");
			} else {
				sql.append("and ");
			}
			sql.append("kengen_code = ? ");
			param.add(sd.getKengen_code());
			}

		//削除フラグ
		if(!sd.getDelete_flg().equals("")) {
			if(param.isEmpty()) {
				sql.append("where ");
			} else {
				sql.append("and ");
			}
			sql.append("delete_flg = ? ");
			param.add(sd.getDelete_flg());
		}

		Map<String, Object> map = jt.queryForMap(sql.toString(), param.toArray());
		//System.out.println("recodes="+map.get("cnt"));
		return Integer.parseInt(map.get("cnt").toString());

	}

	public void getList(ShainData sd) {
		List<Object> param = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder();

		sql.append("select ");
		sql.append("ms.shain_code,");
		sql.append("ms.shain_name,");
		sql.append("case ms.login_flg ");
		sql.append("when '0' then '可' ");
		sql.append("when '1' then '不可' ");
		sql.append("else '不明' end login_flg,");
		sql.append("ms.mail_address,");
		sql.append("mk.kengen_name,");
		sql.append("case ms.delete_flg ");
		sql.append("when '0' then '' ");
		sql.append("when '1' then '削除済み' ");
		sql.append("else '不明' end delete_flg ");
		sql.append("from mst_shain ms join mst_kengen mk ");
		sql.append("on ms.kengen_code = mk.kengen_code ");
		//社員
		if(!sd.getShain().equals("") ) {
			sql.append(" where (");
			sql.append("ms.shain_code = ?  ");
			sql.append("or ms.shain_name like ?  ");
			sql.append("or ms.shain_name_kana like ?");
			sql.append(") ");
			param.add(sd.getShain());
			param.add("%" + sd.getShain() + "%");
			param.add("%" + sd.getShain() + "%");
		}
		//ログインフラグ
		if(!sd.getLogin_flg().equals("")) {
			if(param.isEmpty()) {
				sql.append("where ");
			} else {
				sql.append("and ");
			}
			sql.append("ms.login_flg = ?  ");
			param.add(sd.getLogin_flg());
		}
		//権限
		if(!sd.getKengen_code().equals("")) {
			if(param.isEmpty()) {
				sql.append("where ");
			} else {
				sql.append("and ");
			}
			sql.append("ms.kengen_code = ? ");
			param.add(sd.getKengen_code());
		}
		//削除フラグ
		if(!sd.getDelete_flg().equals("")) {
			if(param.isEmpty()) {
				sql.append("where ");
			} else {
				sql.append("and ");
			}
			sql.append("ms.delete_flg = ? ");
			param.add(sd.getDelete_flg());
		}
		//order by
		sql.append("order by ms.shain_name_kana ");
		//limit
		sql.append("limit ?,25");
		param.add((sd.getPage() - 1) * 25);

		sd.setList(jt.queryForList(sql.toString(),param.toArray()));
	}

}
