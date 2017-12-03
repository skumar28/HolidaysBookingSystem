package holidays.services;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainApplication {
	JButton searchButton;
	JTextField searchTextField;
	JTextField searchTextField2;
	JLabel lable = new JLabel();

	private JFrame frame;
	JPanel topPanel = new JPanel();
	JPanel searchPanel = new JPanel();
	JPanel resultPanel = new JPanel();

	JScrollPane scrPane = new JScrollPane(resultPanel);
	ServiceProvider serviceProvider =  new ServiceProvider();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainApplication window = new MainApplication();
				window.frame.setVisible(true);
			}
		});
	}

	public MainApplication() {
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setBounds(200, 100, 1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gLayout = new GridLayout(2,1);
		topPanel.setLayout(gLayout);
		Container contentPane = frame.getContentPane();		

		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(scrPane, BorderLayout.CENTER);

		
		searchButton = new JButton("Search");
		resultPanel.add(new JLabel("Search Result will display Here"));
		// Create an instance of ListenForEvents to handle events

		ListenForButton lForButton = new ListenForButton();

		// Tell Java that you want to be alerted when an event
		// occurs on the button

		JLabel applicationName = new JLabel();
		applicationName.setText("<html><h2>Holidays Booking Management System</h2></html>");	
		applicationName.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel();
		label.setText("Enter Package Name Or City Name:");		
		searchButton.addActionListener(lForButton);
		searchTextField = new JTextField(40);
		searchTextField.setToolTipText("Enter Package Name Or City Name");
		
		searchPanel.add(label);
		searchPanel.add(searchTextField);		
		searchPanel.add(searchButton);

		topPanel.add(applicationName);
		topPanel.add(searchPanel);
		// How to add a text field ----------------------
		

	}

	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == searchButton) {				
				String searchCriteria  = searchTextField.getText();
				
				List<HolidayPackage> hpList = serviceProvider.searchPackage(searchCriteria);

				if (!hpList.isEmpty()) {
					
					GridLayout gLayout = new GridLayout(hpList.size(),1);
					resultPanel.setLayout(gLayout);
					
					for(HolidayPackage hp : hpList) {
						JLabel newLable = new JLabel();
						newLable.setText(hp.getName());
						resultPanel.add(newLable);
					}
					
					serviceProvider.ListPackages(hpList);
					System.out.println("Pacakge found: "+ hpList.size());
				} else {
					System.out.println("Opps!!! No Package Found for Given Criteria.");
				}
								
				System.out.println(searchCriteria);
				lable.setText(searchCriteria);
				resultPanel.add(lable);
				
			}

		}
	}
}