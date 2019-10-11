package code;
import java.util.*;

public class CredentialsDatabase {
    HashMap<Credentials,Integer> credibilityList;
    HashMap<String,String> usernameAndAadhaar;
    HashMap<String,String> usernameAndPassword;
    static {
        credibilityList=new HashMap<Credentials,Integer>();
        usernameAndAadhaar=new HashMap<String,String>();
        usernameAndPassword=new HashMap<String,String>();
    }
    public static void addRecord(String username,String aadhaar,String password)
    {
        usernameAndAadhaar.put(username,aadhaar);
        usernameAndPassword.put(username,password);
        Credentials c=new Credentials(username,aadhaar,password);
        credibilityList.put(c,10);
    }
    public static boolean checkAadhaar(String username,String aadhaar)
    {
        if(usernameAndAadhaar.get(username)==aadhaar)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean checkPassword(String username,String password)
    {
        if(usernameAndPassword.get(username)==password)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int getCrediblity(Credentials c)
    {
        return credibilityList.get(c);
    }
    public static void changePassword(String username,String newPassword)
    {
        usernameAndPassword.replace(username,newPassword);
    }
}