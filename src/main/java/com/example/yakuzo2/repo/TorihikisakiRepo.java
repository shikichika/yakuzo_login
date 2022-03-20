package com.example.yakuzo2.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TorihikisakiRepo {

	@Autowired
	private JdbcTemplate jt;

	public List<Map<String, Object>> getTempoData(){

		String sql = "select torihikisaki_code, torihikisaki_name from mst_torihikisaki where torihikisaki_kbn = ? and delete_flg = ?";
		Object[] param = {"2", "0"};
		return jt.queryForList(sql,param);

	}

	public List<Map<String, Object>> getTonyaData(){

		String sql = "select torihikisaki_code, torihikisaki_name from mst_torihikisaki where torihikisaki_kbn = '1' and delete_flg = '0'";
		return jt.queryForList(sql);

	}

	public String getTempoName(String tempo_code) {
		String sql="select torihikisaki_name from mst_torihikisaki where torihikisaki_code = ?";
		Map<String, Object> map = jt.queryForMap(sql, tempo_code);
		return map.get("torihikisaki_name").toString();
	}


}
