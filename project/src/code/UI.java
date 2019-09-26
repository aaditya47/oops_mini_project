package code;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class UI {
	Credentials credentials;
	int sessionID;
	Scanner s;
	public UI()
	{
		s=new Scanner(System.in);
		// TODO - Write code to assign random session ID and display it
		openLoginPage();
	}
	public void openLoginPage()
	{
		credentials=new Credentials();
		while(true)
		{
			System.out.println("Enter username: ");
			String username=s.next();
			System.out.println("Enter password: ");
			String password=s.next();
			// TODO - Write code to check username and password
			if(/*passwords match*/)
			{
				System.out.println("Successfully logged in!");
				credentials.username=username;
				credentials.password=password;
				break;
			}
			else
			{
				System.out.println("Invalid credentials. Please try again.");
			}
		}
	}
}
