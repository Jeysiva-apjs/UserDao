package com.jey.database;

public class QueryUtil {
	
	public static String insertUserQuery() {
		return "INSERT INTO user_info(id, name, designation, mail_id, location, reports_to) VALUES(?,?,?,?,?,?)";
	}

	public static String selectAllUserQuery() {
		return "SELECT * FROM user_info";
	}

	public static String selectUsereById() {
		return "SELECT * FROM user_info WHERE id = ?";
	}
	
	public static String deleteUserById() {
		return "DELETE FROM user_info WHERE id = ?";
	}
	
	public static String updateUserQuery(int id) {
		return "UPDATE user_info SET id=?, name=?, designation=?, mail_id=?, location=?, reports_to=? WHERE id = " + id;
	}
}
