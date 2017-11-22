package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConexion 
{
	private final String URL = "jdbc:mysql://localhost:3306/bd_sistema?useSSL=false";
	private final String USER = "root";
	private final String PASS = "admin";
	
	public MySqlDBConexion()
	{}
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConexion()
	{
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(URL,USER,PASS);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cn;
	}
}
