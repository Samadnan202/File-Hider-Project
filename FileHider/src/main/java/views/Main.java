package views;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		Welcome wc = new Welcome();
		
		do
		{
			wc.welcomeScreen();
			
		}while(true);
	}

}
