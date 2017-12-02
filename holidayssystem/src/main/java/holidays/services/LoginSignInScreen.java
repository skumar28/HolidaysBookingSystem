package holidays.services;

import javax.swing.*;
import java.awt.event.*;  
import holidays.LoginDetails.Login;
import holidays.customer.LoginInfo;

public class LoginSignInScreen implements ActionListener {

			JTextField userNameTextField;  
			JPasswordField passwordPasswordField;
			JFrame frame= new JFrame();
		      
			
		    JButton loginButton;  
		    
		    	LoginSignInScreen()
		    	{  
		       
		        JLabel usernameLabel = new JLabel("Username");
		        JLabel passwordLabel = new JLabel("Password");
		        usernameLabel.setBounds(10,20,80,25);
		        passwordLabel.setBounds(10,50,80,25);
		        userNameTextField=new JTextField();  
		        userNameTextField.setBounds(100,20,165,25);  
		        passwordPasswordField=new JPasswordField();  
		        passwordPasswordField.setBounds(100,50,165,25);  
		        passwordPasswordField.setEchoChar('*') ;
		           
		        loginButton=new JButton("LOGIN");  
		        loginButton.setBounds(10, 80, 80, 25);  
		          
		        loginButton.addActionListener(this);  
		          
		        frame.add(userNameTextField);
		        frame.add(passwordPasswordField);
		        frame.add(usernameLabel);
		        frame.add(passwordLabel);
		        frame.add(loginButton);
		        
		          
		        frame.setSize(300,300);  
		        frame.setLayout(null);
		       // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		        //frame.setUndecorated(true);
		        frame.setVisible(true);  
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	}
		    	
	    public void actionPerformed(ActionEvent e) 
	    {  
	    		
	    		Login login = new Login();
			LoginInfo userInfo = new LoginInfo();
			boolean userStatus = userLogin(login, userInfo);
			
			if(userStatus==false)
			{			
				JOptionPane.showMessageDialog(null, "You have entered wrong username/password!!");
				//userNameTextField.setText("");
				//passwordPasswordField.setText("");
				//userNameTextField.grabFocus();
				frame.setVisible(false);
	    		 	frame.dispose();				
				 new LoginScreen();
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have successfully logged in!!");
				
				//search, select, book screen call
			}
	    }  
	    
	    private boolean userLogin(Login login, LoginInfo userInfo) {
	    
	    	userInfo.setUserName(userNameTextField.getText());
	    	userInfo.setPassword(passwordPasswordField.getText());
	    	if(userInfo.getUserName()=="" || userInfo.getPassword()=="")
	    	{
	    		return false;
	    	}
	    	boolean check = login.validateUser(userInfo);
	    	return check;
	    	
	    }
	

}
