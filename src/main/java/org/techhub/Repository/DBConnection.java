package org.techhub.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection 
{
	DBConfig config=DBConfig.getInstance();
	protected Connection conn= config.getConn();
	protected PreparedStatement stmt=config.getstatement();
	protected ResultSet rs=config.getResult();
	

}
