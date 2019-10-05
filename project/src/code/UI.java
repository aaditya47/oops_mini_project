package code;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class UI {
	Credentials credentials;
	String sessionID;
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
	public void signUp(Credentials newCredentials)
	{
		// TODO - write code to insert new credentials into database
		System.out.println("Successfully signed up! Login username: "+newCredentials.username);
	}
	public void registerComplaint()
	{
		String description;
		Media media=new Media();
		int threatLevel;
		int credibility;
		Complaint c=new Complaint();
		c.user=this.credentials.username;
		System.out.println("Enter description of your complaint: ");
		description=s.next();
		System.out.println("Do you wish to add any media? Type 1 if yes, or any other number if no");
		int opt=s.nextInt();
		if(opt==1)
		{
			System.out.println("Enter form: 1- Picture, 2- Video, 3- Location");
			opt=s.nextInt();
			if(opt==1)
			{
				c.media.form=1;
				// TODO - write code to import media
			}
			else if(opt==2)
			{
				c.media.form=2;
				// TODO - write code to import media
			}
			else if(opt==3)
			{
				c.media.form=1;
				// TODO - write code to import media
			}
		}
		else
		{
			continue;
		}
		c.description=description;
		// TODO - write code to access database and retrieve credibility level
		ThreatClassifier.insert(c); // Static method
		System.out.println("Thank you for submitting your complaint. We will get back to you soon");
	}
	public void displayMessage(String msg)
	{
		System.out.println(msg);
	}
	public String toString()
	{
		return "The user "+this.credentials.username+" is connected using session ID: "+this.sessionID;
	}
}
