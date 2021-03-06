package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.models.Planet;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Planet p = new Planet("Jupiter");
		Planet op = new Planet("Venus");
		
		//SESSION CODE
//		This method will return the current session or creeate a new one
		HttpSession session = req.getSession();
//		HttpSession session = req.getSession(false); //Will return null if no sessions exists
		
		session.setAttribute("planet" , p);
		session.setAttribute("Other planets" , op);
		
		System.out.println(session.getAttribute("planet"));
	}
	
}
