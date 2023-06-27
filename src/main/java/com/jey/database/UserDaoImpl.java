package com.jey.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jey.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(User user) throws SQLException {

		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertUserQuery())) {

			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getDesignation());
			preparedStatement.setString(4, user.getMailId());
			preparedStatement.setString(5, user.getLocation());
			preparedStatement.setString(6, user.getReportsTo());

			int rows = preparedStatement.executeUpdate();

			System.out.println("-----------------------------");
			if (rows > 0) {
				System.out.println("Record created successfully");
			} else {
				System.out.println("Insert Record Failed");
			}
			System.out.println("-----------------------------");

		}

	}

	@Override
	public void getAllUsers() throws SQLException {
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.selectAllUserQuery())){

			ResultSet resultSet = preparedStatement.executeQuery();
			printUsers(resultSet);

		}

	}

	@Override
	public void getUserById(int id) throws SQLException {
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.selectUsereById())) {

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			printUsers(resultSet);
		}

	}

	@Override
	public void updateUser(int id, User user) throws SQLException {
		try (Connection connection = ConnectionPool.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.updateUserQuery(id))) {

			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getDesignation());
			preparedStatement.setString(4, user.getMailId());
			preparedStatement.setString(5, user.getLocation());
			preparedStatement.setString(6, user.getReportsTo());
			int result = preparedStatement.executeUpdate();

			System.out.println("-----------------------------");
			if (result > 0) {
				System.out.println("Employee updated sucessfully");
			} else {
				System.out.println("Failed to update record.");
			}
			System.out.println("-----------------------------");

		}
	}

	@Override
	public boolean deleteUserById(int id) throws SQLException {
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.deleteUserById())) {

			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();

			System.out.println("-----------------------------");
			if (result > 0) {
				System.out.println("Employee deleted sucessfully");
				System.out.println("-----------------------------");
				return true;
			} else {
				System.out.println("Employee ID is not present.");
				System.out.println("-----------------------------");
			}
			return false;
		}
	}

	private void printUsers(ResultSet resultSet) throws SQLException {
		System.out.println("-----------------------------");
		while (resultSet.next()) {
			System.out.println("User Id: " + resultSet.getInt(1));
			System.out.println("User Name: " + resultSet.getString(2));
			System.out.println("Designation: " + resultSet.getString(3));
			System.out.println("Maid ID: " + resultSet.getString(4));
			System.out.println("Location: " + resultSet.getString(5));
			System.out.println("Reports: " + resultSet.getString(6));
			System.out.println("-----------------------------");

		}
	}
}
