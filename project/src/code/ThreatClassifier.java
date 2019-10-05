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
    public void classify()
    {
        // TODO - insert code to classify
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