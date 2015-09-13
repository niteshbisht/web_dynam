package com.base.mysql.tree.traversal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetUtil {
	public static boolean getDuplicacy(ResultSet rs) throws SQLException {
		int cc = rs.getMetaData().getColumnCount();
		int j = 1;
		String prev = null;
		String next;
		while (j <= cc) {
			if (j > 1)
				prev = rs.getString(j - 1);
			next = rs.getString(j);
			if (null != prev && prev.equals(next))
				return true;
			j++;
		}
		return false;
	}

	public static Map<String, List<Integer>> getDataDupls(ResultSet rs)
			throws SQLException {
		Map<String, List<Integer>> mm = new HashMap<String, List<Integer>>();
		List<Integer> li;
		int cc = rs.getMetaData().getColumnCount();
		int j = 1;
		String prev = null;
		String next;
		while (j <= cc) {
			if (j > 1)
				prev = rs.getString(j - 1);
			next = rs.getString(j);
			if (null != prev && prev.equals(next)) {
				if (mm.containsKey(prev)) {
					li = mm.get(prev);
					li.add(j);
				} else {
					li = new ArrayList<Integer>();
					li.add(j);
					mm.put(prev, li);
				}
			} else {
				li = new ArrayList<Integer>();
				li.add(j);
				mm.put(next, li);
			}
			j++;
		}
		return mm;
	}
}
