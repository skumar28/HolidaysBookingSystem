package holidays.LoginDetails;

import java.util.*;
import java.io.*;

public class Login {
	
	private String sUsername;
	private String sPassword;
	
	Login()
	{
		sUsername="";
		sPassword="";
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
	
	public void readFile(BufferedReader in, HashMap<String, String> hr)
	{
		String sLine="";
		try
		{
				while((sLine = in.readLine()) != null)
				{
					String parts[] = sLine.split("#");
		            hr.put(parts[0], parts[1]);
				}
				in.close();
		        System.out.println(hr.toString());
		}
		
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	public Boolean checkvalid(String Username, String Password, HashMap<String, String> hr )
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
	
	
	public Boolean newuser(String Username, String Password, HashMap<String, String> hr )
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
				System.out.println(hr.toString());
				return true;
			}
				
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
}
