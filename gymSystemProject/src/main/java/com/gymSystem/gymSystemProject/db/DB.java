package com.gymSystem.gymSystemProject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Instructor;

public class DB implements DAO{
	Connection connection;
	Statement statement;
	final String TAG = "[" + getClass().getSimpleName() + "]";
	
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(TAG + "Driver loadded");
		} catch (Exception e) {
			System.out.println("Exception Ocurred" + e);
		}
		
	}

	@Override
	public void createConnection() {
		try {
			String user = "zumba";
			String password = "password";
			String url = "jdbc:mysql://localhost/zumbaSystem";
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(TAG + "Connetion created");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void closeConnection() {
		try {
			connection.close();
			System.out.println(TAG + "Connection closed ");
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}

	@Override
	public void createInstructor(Instructor instructor) {
		try {
			String sql = "INSERT INTO gym_instructors (name) VALUES ('" + instructor.getName() + "')";
			System.out.println("Sql is ");
			statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			String message = result > 0 ? "Customer Created Susccesfully" : "Customer Not Created. Please Try Again"; 
			System.out.println(TAG + message);
		} catch (Exception e) {
			System.out.println("Exception Ocurred: " + e);
		}
	}

	@Override
	public void updateInstructor(int id, String name) {
		try {
			String sql = "UPDATE gym_instructors SET name = '" + name + "' WHERE id = " + id;
			System.out.println("Sql is ");
			statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			String message = result > 0 ? "Customer Updated Susccesfully" : "Customer Not Updated. Please Try Again"; 
			System.out.println(TAG + message);
		} catch (Exception e) {
			System.out.println("Exception Ocurred: " + e);
		}	
	}

	@Override
	public void deletedInstructor(int id) {
		try {
			String sql = "DELETE FROM gym_instructors WHERE id = " + id;
			System.out.println("Sql is ");
			statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			String message = result > 0 ? "Customer was deleted id= " + id +  " Susccesfully" : "Customer Not Deleted. Please Try Again"; 
			System.out.println(TAG + message);
		} catch (Exception e) {
			System.out.println("Exception Ocurred: " + e);
		}
	}

	@Override
	public ArrayList<Instructor> getAllInstructor() {
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
		try {
			String sql = "SELECT * FROM gym_instructors";
			statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				Instructor instructor = new Instructor();
				instructor.setName(set.getString(2));
				instructors.add(instructor);
			}
			
			for (Instructor instructor : instructors) {
				System.out.println(instructor.getName());
			}
		} catch (Exception e) {
			System.out.println("Exception Ocurred: " + e);
		}
		return null;
	}
	
	
}
