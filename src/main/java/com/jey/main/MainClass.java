package com.jey.main;


import java.sql.SQLException;
import java.util.Scanner;

import com.jey.database.UserDaoImpl;
import com.jey.model.User;


public class MainClass {

	public static void main(String[] args) {
		
		UserDaoImpl databaseService = new UserDaoImpl();
		
		try (Scanner scan = new Scanner(System.in);) {
			
			boolean isRunning = true;
			while (isRunning) {
				System.out.println("Enter Choice");
				System.out.println("1. Insert user");
				System.out.println("2. Get all user details");
				System.out.println("3. Get user by id");
				System.out.println("4. Delete user");
				System.out.println("5. Update user");
				System.out.println("6. Exit");

				int choice = scan.nextInt();
				User user = new User();
				scan.nextLine();

				switch (choice) {
				case 1:
					user = createUser(scan);
					databaseService.insertUser(user);
					break;
				case 2:
					databaseService.getAllUsers();
					break;
				case 3:
					System.out.println("Enter ID of an user: ");
					databaseService.getUserById(scan.nextInt());
					break;
				case 4:
					System.out.println("Enter ID of an user: ");
					databaseService.deleteUserById(scan.nextInt());
					break;
				case 5:
					System.out.println("Enter ID of an user: ");
					int id = scan.nextInt();
					scan.nextLine();
					user = createUser(scan);
					databaseService.updateUser(id, user);	
					
					break;
				case 6:
					System.out.println("Thankyou! Visit again");
					isRunning = false;
					break;

				default:
					break;
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong...." + e.fillInStackTrace());
		}
	}

	private static User createUser(Scanner scan) throws SQLException {
		
		System.out.print("Enter ID:");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter name:");
		String name = scan.nextLine();
		System.out.print("Enter Designation:");
		String designation = scan.nextLine();
		System.out.print("Enter Maid ID:");
		String mail = scan.nextLine();
		System.out.print("Enter work location:");
		String location = scan.nextLine();
		System.out.print("Enter whom you are reports to:");
		String reportsTo = scan.nextLine();
		User user = new User(id, name, designation, mail, location, reportsTo);
		return user;
	}
}
