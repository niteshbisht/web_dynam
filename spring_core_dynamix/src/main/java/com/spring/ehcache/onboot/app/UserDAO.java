package com.spring.ehcache.onboot.app;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.base.mysql.tree.traversal.TreeStructure;
import com.base.mysql.tree.traversal.TreeTraversal;

public class UserDAO implements UserIface {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public TreeStructure getTreeStructure(String qType) {
		String query = null;
		AppConstants[] ac = AppConstants.values();
		for(AppConstants a:ac){
			if(a.toString().equals(qType))
			{
				query = a.getQuery();
				break;
			}
		}
		TreeTraversal trtrav = new TreeTraversal();
		ResultSet rs = jdbcTemplate.execute(query,
				new PreparedStatementCallback<ResultSet>() {
					@Override
					public ResultSet doInPreparedStatement(PreparedStatement ps)
							throws DataAccessException, SQLException {
						ResultSet rs = ps.executeQuery();
						return rs;
					}
				});
		boolean v = false;
		try {
			v = rs.isClosed();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(v);
		TreeStructure ts = null;
		try {
			ts = trtrav.getDataJsonFromResultSet(rs);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ts;
	}

}
