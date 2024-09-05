package com.gymSystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.gymSystem.model.Participants;

public class DB {
		Connection connection;
		PreparedStatement preparedStatement;
		
		public DB(){
			try {
				Class.forName("com.sql.cj.dbc.Driver");
				System.out.println("[DB] Driver Loaded");
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost/zumbaSystem", "zumba", "password");
				System.out.println("[DB] connection created");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public int addParticipant(Participants participant) {
			int result = 0;
			
			try {
				String sql = "insert into participants (name, session_id) values('Eve',(select id from sessions where session_type = 'Zumba' and session_time = 'Afternoon'))";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, participant.name);
				result = preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println();
			}
			return result;
		}
		
		
		public void closeConnection() {
			try {
				connection.close();
				System.out.println("[DB] Connection to DB Closed");
			} catch (Exception e) {
				System.out.println("");
			}
		}

}
