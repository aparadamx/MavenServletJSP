<%@page import="com.gymSystem.db.DBjsp"%>
<%@page import="com.gymSystem.model.Participants"%>
<%@page import="com.gymSystem.db.DB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@Page import="com.gymSystem.model.Participants"%>
<%@Page language="java" contentType="text/html; charset=UTF-8" PageEncoding="UTF-8"%>"

<%

	Participants participant = new Participants();
	
	participant.name = request.getParameter("textName");
	
	DBjsp db = DBjsp.getDB();
	
%>