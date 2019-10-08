package code;

public class ThreatClassifier {
    static Complaint[] complaintList;
    static int lastIndex;
    static
    {
        complaintList=new Complaint[1000];
        for(int i=0;i<1000;++i)
        {
            complaintList[i]=new Complaint();
        }
        lastIndex=0;
    }
    public void classify(long int complaintID)
    {
        for(int i=0;i<1000;++i)
        {
            if(complaintID==complaintList[i].complaintID)
            {
                classify(complaintList[i].user,i);
                break;
            }
        }
    }
    public void classify(Credentials c,int index)
    {
        for(int i=0;i<1000;++i)
        {
            for(int j=i+1;j<1000;++j)
            {
                if((0.35*(CredentialsDatabase.getCrediblity(complaintList[i]))+0.65*complaintList[i].threatLevel)<(0.35*(CredentialsDatabase.getCrediblity(complaintList[j]))+0.65*(complaintList[j].threatLevel)))
                {
                    Object temp=complaintList[i];
                    complaintList[i]=complaintList[j];
                    complaintList[j]=temp;
                }
            }
        }
    }
    public static void insert(Complaint c)
    {
        try
        {
            complaintList[lastIndex]=c;
            lastIndex++;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}