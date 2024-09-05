package com.gymSystem.gymSystemProject;

import com.gymSystem.gymSystemProject.db.DB;

import model.Instructor;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Customer Management System");
        
        Instructor instructor = new Instructor();
        
        instructor.setName("carlos");
        
        
        DB db = new DB();
        db.createConnection();
        db.createInstructor(instructor);
        db.closeConnection();


        db.createConnection();
        db.updateInstructor(2,"jorge");
        db.closeConnection();
 

        db.createConnection();
        db.deletedInstructor(1);
        db.closeConnection();
      
  
        db.createConnection();
        db.getAllInstructor();
        db.closeConnection();  
    }
}
