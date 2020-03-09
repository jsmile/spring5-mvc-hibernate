package com.jsmile.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// setup connection variables
		String user = "springhibernate";
		String passwd = "springhibernate";
		
		String driver = "org.mariadb.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimeZone=UTC";
		
		// get connection to DB
		try 
		{
			PrintWriter out = response.getWriter();
			out.println( "\nConnecting to DB ... : " + jdbcUrl );
			
			Class.forName( driver );
			Connection con = DriverManager.getConnection( jdbcUrl, user, passwd );
			out.println( "Connection Success !!" );
			
			con.close();			
		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
			throw new ServletException();
		}

	}

}
