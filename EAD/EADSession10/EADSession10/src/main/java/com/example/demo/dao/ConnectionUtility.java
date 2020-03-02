package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility 
{
public static Connection con;
	
	public static Connection getConnection()
	{
		
		if(con==null)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/metaparkingspring","root","root");
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		return con;
	}

}
