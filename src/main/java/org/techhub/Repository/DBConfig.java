package org.techhub.Repository;
import java.sql.*;
import java.util.Properties;
import java.io.*;
public class DBConfig {
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	private static DBConfig db=null;
	
	private DBConfig()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//line is not always necessary in java 6 and above
			File f=new File("");
			String path=f.getAbsolutePath();
			FileInputStream inputStream=new FileInputStream(path+"\\src\\main\\resources\\DbConfig.Properties");
			Properties p=new Properties();
			p.load(inputStream);
			String driverClassName=p.getProperty("driver");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			String url=p.getProperty("url");
			conn=DriverManager.getConnection(url,username,password);
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
	}
	public static DBConfig getInstance()
	{
		if(db==null)
		{
			db=new DBConfig();
		}
		return db;
	}
	public Connection getConn() {
		return conn;
	}
	public PreparedStatement getstatement() {
		return stmt;
	}
	public ResultSet getResult() {
		return rs;
	}
	
	
	
	
}
