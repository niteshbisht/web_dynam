package com.web.authenticate_user;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ElastDbUserSignStore {
	private static Map<Long, ArrayList<String>> userid = new TreeMap<Long, ArrayList<String>>();

	public static void addUserID(long uuid, String username, String password) {
		ArrayList<String> user = new ArrayList<>();
		user.add(username);
		user.add(password);
		userid.put(uuid, user);
	}

	public static boolean getUserid(String username, String password) {
		long uid = username.hashCode() + password.hashCode();
		return userid.containsKey(uid);
	}
}
