package com.gymSystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gymSystem.db.DB;
import com.gymSystem.model.Participants;

/**
 * Servlet implementation class CreateParticipantConroller
 */
public class CreateParticipantConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateParticipantConroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Participants participant = new Participants();
		participant.name = request.getParameter("txtName");
		
		DB db = new DB();
		int result = db.addParticipant(participant);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		String message = "";
		
		if(result > 0) {
			message = participant.name + " was added in the database successfuly";
		}else {
			message = participant.name + " not added in database. Please try again";
		}
		out.print("<p>" + message + "</p>");
		out.print("</center>");
	}
}
