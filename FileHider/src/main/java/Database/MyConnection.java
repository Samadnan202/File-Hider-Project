package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection 
{
	//static because har jagah object banane ki jaroorat nahi padengi.
	
	
    public static Connection connection = null;
    
    //database connect karane ki method.
    public static Connection getConnection() throws SQLException
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
    	catch (ClassNotFoundException e) 
    	{}
    	try 
    	{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filehider","root","Adnan@202");
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	//System.out.println("DATABASE CONNECTION IS PROPERLLY SUCSSESFULL.....");
    	
		return connection;
    }
    
    public static void closeConnection()
    {
    	if(connection !=null)
    	{
    		try
        	{
        		connection.close();
        	}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
}
