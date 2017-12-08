package holidays.services;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.*;

import holidays.LoginDetails.Login;
import holidays.customer.LoginInfo;
import holidays.services.*;

public class LoginScreen  implements ActionListener {

	
	JTextField userNameTextField;  
	JPasswordField passwordPasswordField;
	JFrame frame= new JFrame();
	
    JButton signInButton;
    JButton signUpButton;
    
    	LoginScreen()
    	{  
    		    		
         JLabel welcomeLabel= new JLabel("Welcome to Holiday Package Booking System"); 
         JLabel selectLabel= new JLabel("If you are new user, select SIGNUP else select SIGNIN");
         
         welcomeLabel.setBounds(100,10,3000,25);
         selectLabel.setBounds(10,30,400,40);
         
         signInButton= new JButton("SIGNIN");
         signUpButton= new JButton("SIGNUP");
         
         signUpButton.setBounds(120,60,80,50);
         signInButton.setBounds(240,60,80,50);
         
         signUpButton.setActionCommand("1");
         signInButton.setActionCommand("2");
         
         signUpButton.addActionListener(this);  
         signInButton.addActionListener(this);
         
         frame.add(welcomeLabel);
         frame.add(selectLabel);
         frame.add(signInButton);
         frame.add(signUpButton);
         
         frame.setSize(500,300);  
	     frame.setLayout(null);  
	    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	     //frame.setUndecorated(true);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
    	}
    	
    	 public void actionPerformed(ActionEvent e) 
 	    {  
 	    	 			
 			int action = Integer.parseInt(e.getActionCommand());
 	   
 			switch(action)
 			{	
		 	    case 1:
		 	    		 
		 	    		 frame.setVisible(false);
		 	    		 frame.dispose();
		 	         new LoginSignUpScreen();		 	         
		 	         break;
		 	         
		 	    case 2: 
		 	         // doSomething;		
		 	    		 frame.setVisible(false);
		 	    		 frame.dispose();
		 	    		 new LoginSignInScreen();	
		 	         break;
	 	   }
 			
 	    }  
	
	
	//public static void main(String[] args) {
	//	// TODO Auto-generated method stub
	//	new LoginScreen();  
	//}

}
