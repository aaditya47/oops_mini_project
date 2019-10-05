package code;

public class Driver {

	public static void main(String[] args) {
		System.out.println("PATROL DEPLOYMENT APP");
		UI ui=new UI();
		while(true)
		{
			System.out.println("Is there anything else we can help you out with? Type 1 if yes or any other number if no");
			int opt=new Scanner(System.in).nextInt();
			if(opt==1)
			{
				System.out.println("Type 1 if you want to view the status of a previous complaint, Type 2 if you want to add a payment method");
				opt=new Scanner(System.in).nextInt();
				switch(opt)
				{
					case 1:
						System.out.println("Enter username: ");
						String username=new Scanner(System.in).next();
						int count;
						for(int i=0;i<ThreatClassifier.lastIndex;++i)
						{
							if(ThreatClassifier.complaintList[i].user.equals(username))
							{
								count++;
								System.out.println("Your "+count+"th pending case is in position "+(i+1)+" and will be taken care of shortly. Please wait");
							}
						}
						break;
					case 2:
						// TODO - add code to add payment method
				}
			}
			else
			{
				break;
			}
		}
		

	}

}
