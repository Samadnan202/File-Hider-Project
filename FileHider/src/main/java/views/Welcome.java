package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

public class Welcome 
{
    public void welcomeScreen() throws IOException
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("                       ....WELCOME TO THE APPLICATION....\n");
    	
    	System.out.println("* PRESS 1 TO LOGINE");
    	System.out.println("* PRESS 2 TO SIGNUP");
    	System.out.println("* PRESS 0 TO EXIT");
    	
    	int choice = 0;
    	
    	try
    	{
    		choice  =  Integer.parseInt(br.readLine());
    	}
    	catch(IOException e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    	switch(choice)
    	{
    	    case 1 : login();
    	    case 2 : signUp();
    	    case 3 : System.exit(0);
    	}
    }

	//login method
	private void login() throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER YOUR EMAIL:");
		String email = sc.nextLine();
		
		try
		{
			if(UserDAO.isExists(email))
			{
				String getOTP = GenerateOTP.getOTP();
				
				SendOTPService.sendOTP(email, getOTP);
				
				System.out.println("ENTER YOUR OTP");
				String otp = sc.nextLine();
				
				if(otp.equals(getOTP))
				{
					new UserView(email).home();
				}
				else
				{
					System.err.println("INVALID OTP");
				}
				
			}
			else
			{
				System.err.println("USER NOT FOUND");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//sign up method 
    private void signUp() 
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("ENTER YOUR NAME: ");
    	String name = sc.nextLine();
    	
        System.out.print("ENTER YOUR EMAIL: ");
        String email = sc.nextLine();
        
        String getOTP = GenerateOTP.getOTP();
		
		SendOTPService.sendOTP(email, getOTP);
		
		System.out.print("ENTER YOUR OTP: ");
		String otp = sc.nextLine();
		
		if(otp.equals(getOTP))
		{
			User user = new User(name,email);
			int response  = UserService.saveUser(user);
			
			switch(response)
			{
			case 0: System.out.println("USER REGISTRATION IS SUCCESSFULL");
			case 1: System.err.println("USER ALREADY EXISTS");
			}
		}
		else
		{
			System.err.println("INVALID OTP");
		}
    }
}
