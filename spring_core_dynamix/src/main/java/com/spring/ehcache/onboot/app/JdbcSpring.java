package com.spring.ehcache.onboot.app;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.mysql.jdbc.JDBC4ResultSet;

public class JdbcSpring {
	private static ClassPathXmlApplicationContext ctxt;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		ctxt = new ClassPathXmlApplicationContext("ehcache/ehcache-jdbc.xml");
		JdbcSpring jd = ctxt.getBean("jdbcSpring", JdbcSpring.class);
		String query = "select * from tree;";
		/*
		 * List<Map<String, Object>> li = jd.jdbcTemplate.queryForList(query);
		 * 
		 * for (Map<String, Object> row : li) { String res = (String)
		 * row.get("col1"); System.out.println(res); }
		 */

		ResultSet rs = null;
		rs = jd.jdbcTemplate.execute(query,
				new CallableStatementCallback<ResultSet>() {
					@Override
					public ResultSet doInCallableStatement(CallableStatement arg0)
							throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						ResultSet rs = arg0.executeQuery();
						int n = rs.getMetaData().getColumnCount();
						System.out.println(n);
						return arg0.executeQuery();
					}
				});
		try {
			int n = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int j = 1; j <= n; j++) {
					System.out.println(rs.getString(j));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
