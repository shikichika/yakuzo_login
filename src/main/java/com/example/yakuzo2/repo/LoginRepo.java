package com.example.yakuzo2.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.yakuzo2.data.LoginData;

@Repository
public class LoginRepo {

	@Autowired
	JdbcTemplate jt;

	public boolean checkLogin(LoginData ld) {

		StringBuilder sql = new StringBuilder();
		sql.append("select ms.shain_name, ms.kengen_code, mk.kengen_name ");
		sql.append("from mst_shain ms join mst_kengen mk ");
		sql.append("on ms.kengen_code = mk.kengen_code ");
		sql.append("where ms.login_flg = '0' ");
		sql.append("and ms.delete_flg = '0' ");
		sql.append("and ms.shain_code = ?");
		sql.append("and ms.password = ?");

		try {
			Map<String, Object> map=jt.queryForMap(sql.toString(), ld.getShain_code(), ld.getPassword());
			ld.setShain_name(map.get("shain_name").toString());
			ld.setKengen_code(map.get("kengen_code").toString());
			ld.setKengen_name(map.get("kengen_name").toString());

			if(ld.getKengen_code().equals("002")&&ld.getTempo_code().length()==0) {
				ld.setMsg("店舗権限者は、店舗の選択が必須です。");
				return false;
			}

		}catch(Exception e) {
			ld.setMsg("社員コードまたはパスワードに間違いがあります。");
			return false;
		}
		return true;
	}

}
