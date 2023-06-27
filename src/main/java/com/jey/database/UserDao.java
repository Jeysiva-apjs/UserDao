package com.jey.database;

import java.sql.SQLException;

import com.jey.model.User;

public interface UserDao {
	
	void insertUser(User user) throws SQLException;
	void getAllUsers() throws SQLException;
	void getUserById(int id) throws SQLException;
	boolean deleteUserById(int id) throws SQLException;
	void updateUser(int id, User user) throws SQLException;

}
