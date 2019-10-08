package code;

public class Complaint {
    long int complaintID;
    Credentials user;
    String description;
    Media media;
    int threatLevel;
    public Complaint()
    {
        media=new Media();
    }
}