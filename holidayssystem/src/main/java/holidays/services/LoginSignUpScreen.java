package holidays.services;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import holidays.LoginDetails.Login;
import holidays.customer.LoginInfo;

import java.awt.event.*;

public class LoginSignUpScreen implements ActionListener {
	
	JTextField userNameTextField;  
	JPasswordField passwordPasswordField;
	JFrame frame= new JFrame();
      
	
    JButton signUpButton;  
    
    LoginSignUpScreen()
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
           
        signUpButton=new JButton("SIGNUP");  
        signUpButton.setBounds(10, 80, 80, 25);  
          
        signUpButton.addActionListener(this);  
          
        frame.add(userNameTextField);
        frame.add(passwordPasswordField);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(signUpButton);
        
          
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
		boolean userStatus = userSignUp(login, userInfo);
		
		if(userStatus==false)
		{			
			JOptionPane.showMessageDialog(null, "Username already exists!!");
			//userNameTextField.setText("");
			//passwordPasswordField.setText("");
			//userNameTextField.grabFocus();
			frame.setVisible(false);
		 	frame.dispose();	
		 	new LoginScreen();
		}
		else
		{
			//JOptionPane.showMessageDialog(null, "New User created successfully!!");
			frame.setVisible(false);
			frame.dispose();
			new HolidaySearchFrame(userNameTextField.getText());
			//search, select, book screen call
		}
    }  
    
    private boolean userSignUp(Login login, LoginInfo userInfo) {
    
    	userInfo.setUserName(userNameTextField.getText());
    	userInfo.setPassword(passwordPasswordField.getText());
    	if(userInfo.getUserName()=="" || userInfo.getPassword()=="")    	
    		return false;    	
    	boolean check = login.registerNewUser(userInfo);
    	return check;
    	
    }

}
