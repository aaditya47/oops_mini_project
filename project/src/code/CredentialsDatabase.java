package code;
import java.util.*;

public class CredentialsDatabase {
    HashMap<Credentials,Integer> credibilityList=new HashMap<Credentials,Integer>();
    HashMap<String,String> usernameAndAadhaar=new HashMap<String,String>();
    HashMap<String,String> usernameAndPassword=new HashMap<String,String>();
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
}