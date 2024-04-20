package com.join2.www.dao;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JoinDao extends JdbcTemplate{
	
	public JoinDao() {}
	
	public JoinDao(DataSource dataSource) {
		super(dataSource);
		System.out.println("---------------->>------"+dataSource);
	}

	public int join(HashMap<String, String> params) {
		String sql = "INSERT INTO forum.`member` "
				+ "( member_id, passwd, member_nm, email, auth_yn, pwd_chng_dtm, join_dtm) "
				+ "VALUES( '', '"+params.get("passwd")
				+ "', '"+ params.get("FirstName")+" " + params.get("LastName")
				+ "', '" + params.get("email")
				+ "', 'N', '', DATE_FORMAT(NOW()  ,'%Y%m%d%H%i%s')); ";
		return update(sql);
	}
}
