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

import com.base.mysql.tree.traversal.TreeStructure;
import com.base.mysql.tree.traversal.TreeTraversal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	public static void main(String[] args) throws JsonProcessingException {
		ctxt = new ClassPathXmlApplicationContext("ehcache/ehcache-jdbc.xml");
		JdbcSpring jd = ctxt.getBean("jdbcSpring", JdbcSpring.class);
		String query = "select * from tree;";
		/*
		 * List<Map<String, Object>> li = jd.jdbcTemplate.queryForList(query);
		 * 
		 * for (Map<String, Object> row : li) { String res = (String)
		 * row.get("col1"); System.out.println(res); }
		 */

		TreeStructure rs = null;
		TreeTraversal tr = new TreeTraversal();
		rs = jd.jdbcTemplate.execute(query,
				new CallableStatementCallback<TreeStructure>() {
					@Override
					public TreeStructure doInCallableStatement(CallableStatement arg0)
							throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						ResultSet rs = arg0.executeQuery();
						int n = rs.getMetaData().getColumnCount();
						TreeStructure ts = tr.getDataJsonFromResultSet(rs);
						return ts;
					}
				});
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(rs));
	}

}
