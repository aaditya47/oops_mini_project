package code;

public class Complaint {
    String user;
    String description;
    Media media;
    int threatLevel;
    int credibility;
    public Complaint()
    {
        media=new Media();
    }
}