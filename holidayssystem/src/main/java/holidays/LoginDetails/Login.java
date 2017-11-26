package holidays.LoginDetails;

import java.util.*;
import java.io.*;

public class Login {
	
	private String sUsername;
	private String sPassword;
	
	private BufferedReader in;
	private BufferedWriter out;
	HashMap<String, String> hr = new HashMap<String, String>();
	
	
	Login()
	{	
		
		sUsername="";
		sPassword="";
		loaddata();
		
	}
		
    private void loaddata()
    {
    	  try
    	  {
    		  in = new BufferedReader(new FileReader("/Users/akshaychopra/Documents/HolidaysBookingSystem/holidayssystem/src/main/java/LoginData/logindata.txt"));
    		  out= new BufferedWriter(new FileWriter("/Users/akshaychopra/Documents/HolidaysBookingSystem/holidayssystem/src/main/java/LoginData/logindata.txt",true));
    		  readFile();
    	  }
    	  
    	  catch(Exception ex)
    	  {
    		  System.out.println(ex.getMessage());
    	  }
    	  
    	  
    	  
    }	
	public String getUsername()
	{
		return this.sUsername;
	}
	
	
	public String getPassword()
	{
		return this.sPassword;
	}
	
	public void setUsername(String username)
	{
		this.sUsername= username;
	}
	
	public void setPassword(String password)
	{
		this.sPassword=password;
	}
	
	
	public void readFile()
	{
		String sLine="";
		try
		{
				while((sLine = in.readLine()) != null)
				{
					String parts[] = sLine.split("#");
		            hr.put(parts[0], parts[1]);
				}
				//in.close();
		        System.out.println(hr.toString());
		}
		
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		finally
		{
			try
			{
			   in.close();	
			}
			
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
					
		}
		
	}
	
	
	
	public Boolean checkvalid(String Username, String Password)
	{
		try
		{
			String value;
			value=(String)hr.get(Username);
			if(value.equals(Password))	
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
			
	}
	
	
	
	public Boolean newuser(String Username, String Password)
	{
		try
		{
			
			if(hr.containsKey(Username))
			{
				return false;
			}
			else
			{				
				hr.put(Username, Password);
				out.newLine();
				out.write(Username+"#"+Password);
				System.out.println(hr.toString());
				return true;
			}
				
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
		finally
		{
			try
			{
				out.close();
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
}
