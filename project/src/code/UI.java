package code;
import java.util.*;

public class UI {
	Credentials credentials;
	String sessionID;
	Scanner s;
	public UI()
	{
		s=new Scanner(System.in);
		// TODO - Write code to assign random session ID and display it
		menu1();
	}
	public void menu1()
	{
		while(true)
		{
			System.out.println("Enter 1 if you would like to login to an existing account. Alternatively, enter 2 if you would like to sign up");
			int opt=s.nextInt();
			if(opt==1)
			{
				openLoginPage();
				break;
			}
			else if(opt==2)
			{
				signUp();
			}
			else
			{
				System.out.println("Invalid option. Enter a valid option to continue")
			}
		}
	}
	public void menu2()
	{
		while(true)
		{
			System.out.println("Is there anything else we can help you out with? Type 1 if yes or any other number if no");
			int opt=s.nextInt();
			if(opt==1)
			{
				System.out.println("Type 1 if you want to view the status of a previous complaint, Type 2 if you want to change your password, Type 3 if you want to exit");
				opt=s.nextInt();
				switch(opt)
				{
					case 1:
						System.out.println("Enter the complaint ID you were issued with: ");
						long int id=s.nextInt();
						int count;
						for(int i=0;i<ThreatClassifier.lastIndex;++i)
						{
							if(ThreatClassifier.complaintList[i].complaintID==id)
							{
								System.out.println("Your complaint with ID "+id" is in position "+(i+1)+" and will be taken care of shortly. Please wait");
							}
						}
						break;
					case 2:
						while(true)
						{
							System.out.println("Enter your username: ");
							String username=s.next();
							System.out.println("Enter your Aadhaar number: ");
							String aadhaar=s.next();
							if(CredentialsDatabase.checkAadhaar(username, aadhaar)==True)
							{
								System.out.println("Username and Aadhaar match.");
								while(true)
								{
									System.out.println("Please enter your new password: ");
									String password=s.next();
									System.out.println("Enter your password again");
									if(s.next().equals(password))
									{
										CredentialsDatabase.changePassword(username, password);
										System.out.println("Password changed successfully!");
										break;
									}
									else 
									{
										System.out.println("Passwords don't match. Please try again");
									}
								}
							}
							else
							{
								System.out.println("Username does not match Aadhaar registered. Please try again");
							}
						}
						break;
					case 3:
						System.out.println("Thank you for using our app!");
						break;
					default:
						System.out.println("Wrong option! Please try again");
						break;
				}
			}
			else
			{
				break;
			}
		}
	}
	public void openLoginPage()
	{
		credentials=new Credentials();
		while(true)
		{
			System.out.println("Enter username: ");
			String username=s.next();
			System.out.println("Enter Aadhaar: ");
			String aadhaar=s.next();
			System.out.println("Checking username and Aadhaar. Please wait");
			if(CredentialsDatabase.checkAadhaar(username, aadhaar)==true)
			{
				System.out.println("Enter password: ");
				String password=s.next();
				System.out.println("Checking validity. Please wait. This might take a while...")
				if(CredentialsDatabase.checkPassword(username, password)==true)
				{
					System.out.println("Successfully logged in!");
					credentials.username=username;
					credentials.password=password;
					menu2();
					break;
				}
				else
				{
					System.out.println("Invalid credentials. Please try again.");
				}
			}
			else
			{
				System.out.println("Username and Aadhaar don't match! Please try again");
			}
			
		}
	}
	public void signUp()
	{
		// TODO - write code to insert new credentials into database
		System.out.println("Successfully signed up! Please login to continue");
	}
	public void registerComplaint()
	{
		String description;
		Media media=new Media();
		int threatLevel;
		int credibility;
		Complaint c=new Complaint();
		c=this.credentials;
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
				c.threatLevel=1;
				c.media.attachment="Picture..."
				System.out.println("Picture successfully imported. Our authorities will contact you shortly");
			}
			else if(opt==2)
			{
				c.media.form=2;
				c.threatLevel=2;
				c.media.attachment="Video..."
				System.out.println("Video successfully imported. Our authorities will contact you shortly");
			}
			else if(opt==3)
			{
				c.media.form=3;
				c.threatLevel=3;
				c.media.attachment="Location..."
				System.out.println("Location successfully shared. Our authorities will contact you shortly");
			}
		}
		else
		{
			continue;
		}
		c.description=description;
		ThreatClassifier.insert(c);
		int n=new Random().nextInt();
		System.out.println("Thank you for submitting your complaint. We will get back to you soon. Your complaint ID is "+n);
	}
	public String toString()
	{
		return "The user "+this.credentials.username+" is connected using session ID: "+this.sessionID;
	}
}