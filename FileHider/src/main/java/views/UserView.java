package views;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.DataDAO;
import model.Data;

public class UserView 
{
	private String email;
	
	UserView(String email)
	{
		this.email = email;
	}
	
    public void home() throws IOException
    {
    	do
    	{
    		System.out.println("                         ********WELCOME "+this.email+" ********");
    		System.out.println("");
    		System.out.println("");
    		System.out.println("                              PRESS 1 TO SHOW HIDDEN FILES.");
    		System.out.println("                              PRESS 2 TO HIDE NEW FILES.");
    		System.out.println("                              PRESS 3 TO UNHIDE A FILE");
    		System.out.println("                              PRESS 0 TO EXIST");
    	    Scanner sc = new Scanner(System.in);
    	    int ch = Integer.parseInt(sc.nextLine());
    	    
    	    switch(ch)
    	    {
    	      case 1:
    	      {
    	    	  try
    	    	  {
    	    		  List<Data> files = DataDAO.getAllFiles(this.email);
    	    		  System.out.println("ID - File Name: ");
    	    		  for(Data file : files)
    	    		  {
    	    			  System.out.println(file.getId() + " - " + file.getFileName());
    	    			  home();
    	    		  }
    	    	  }
    	    	  catch(SQLException e)
    	    	  {
    	    		  e.printStackTrace();
    	    		  home();
    	    	  }
    	      }
    	      
    	      case 2:
    	      {
    	    	  System.out.println("ENTER A FILE PATH WHICH WANT TO HIDE: ");
    	    	  String path = sc.nextLine();
    	    	  
    	    	  File f = new File(path);
    	    	  Data file = new Data(0,f.getName(),path,this.email);
    	    	  
    	    		  try 
    	    		  {
						DataDAO.hideFiles(file);
					  }
    	    		  catch (SQLException e) 
    	    		  {
						e.printStackTrace();
						home();
					  }
    	      }
    	      case 3:
    	      {
    	    	  List<Data> files;
				try {
					files = DataDAO.getAllFiles(this.email);

	    		  System.out.println("ID - File Name: ");
	    		  for(Data file : files)
	    		  {
	    			  System.out.println(file.getId() + " - " + file.getFileName());
	    		  }
	    		  
	    		  
	    		  System.out.println("Enter the id of file to unhide: ");
	    		  int id = Integer.parseInt(sc.nextLine());
	    		  boolean isValidId = false;
	    		  
	    		  for(Data file : files)
	    		  {
	    			  if(file.getId() == id)
	    			  {
	    				  isValidId = true;
	    				  break;
	    			  }
	    		  }
	    		  if(isValidId)
	    		  {
	    			  DataDAO.unhide(id);
	    		  }
	    		  else
	    		  {
	    			  System.out.println("You are write wrong Id.");
	    		  }
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
    	      }
    	      home();
    	      
    	      case 0:
    	      {
    	    	  System.exit(0);
    	      }
    	    }
    	}while(true);
    }
}
