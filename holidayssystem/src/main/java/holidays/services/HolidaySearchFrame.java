package holidays.services;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import holidays.components.Activity;
import holidays.components.Flight;
import holidays.components.Hotel;
import holidays.components.Transport;

public class HolidaySearchFrame implements ActionListener {
	JButton bookPackage;
	JButton makePayment;
	JFrame frame = new JFrame();
	JPanel topPanel = new JPanel();
	JPanel searchPanel = new JPanel();
	JPanel resultPanel = new JPanel();
	ServiceProvider serviceProvider = new ServiceProvider();
	JButton searchButton;
	JTextField searchTextField;
	JLabel lable = new JLabel();

	public HolidaySearchFrame() {

		frame.setBounds(200, 100, 1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gLayout = new GridLayout(2, 1);
		topPanel.setLayout(gLayout);

		JLabel applicationName = new JLabel();
		applicationName.setText("<html><h2>Holidays Booking Management System</h2></html>");
		applicationName.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel();
		label.setText("Enter Package Name Or City Name:");
		searchTextField = new JTextField(40);
		searchTextField.setToolTipText("Enter Package Name Or City Name");
		searchPanel.add(label);
		searchPanel.add(searchTextField);

		searchButton = new JButton("Search");
		searchButton.setActionCommand("search");
		searchButton.addActionListener(this);

		JScrollPane scrPane = new JScrollPane(resultPanel);
		Container contentPane = frame.getContentPane();
		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(scrPane, BorderLayout.CENTER);
		scrPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		searchPanel.add(searchButton);
		topPanel.add(applicationName);
		topPanel.add(searchPanel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		resultPanel.removeAll();

		JPanel thePanel = new JPanel();

		if (e.getActionCommand().equalsIgnoreCase("search")) {

			String searchCriteria = searchTextField.getText();

			List<HolidayPackage> hpList = serviceProvider.searchPackage(searchCriteria);

			if (!hpList.isEmpty()) {

				thePanel.setLayout(new GridLayout(hpList.size(), 0, 20, 20));
				int count = 0;
				for (HolidayPackage hp : hpList) {
					List<Hotel> hotelList = hp.getHotels();
					List<Activity> activityList = hp.getActivities();
					List<Flight> flightList = hp.getFlights();
					List<Transport> transportList = hp.getTransport();

					Box theBox = Box.createVerticalBox();

					JLabel nameLabel = new JLabel("Package Name: " + hp.getName());
					Font nameFont = new Font("Helvetica", Font.BOLD, 16);
					nameLabel.setFont(nameFont);
					theBox.add(nameLabel);
					// addComp(thePanel, nameLabel, 0, count++, 1, 1, GridBagConstraints.EAST,
					// GridBagConstraints.NONE);

					JLabel descLabel = new JLabel("Description: " + hp.getDescription());
					theBox.add(descLabel);
					JLabel type = new JLabel("Type: " + hp.getType());
					theBox.add(type);
					JLabel duration = new JLabel("Duration: " + hp.getDuration());
					theBox.add(duration);
					JLabel fromCity = new JLabel("From City: " + hp.getFromCity());
					theBox.add(fromCity);

					Font font = new Font("Helvetica", Font.BOLD, 14);

					if (!flightList.isEmpty()) {
						JLabel fDetail = new JLabel("Flight Details");
						fDetail.setFont(font);
						theBox.add(fDetail);

						for (Flight flight : flightList) {
							Box flightBox = Box.createHorizontalBox();

						}
					}

					if (!hotelList.isEmpty()) {
						JLabel hDetail = new JLabel("Hotel Details");
						hDetail.setFont(font);
						theBox.add(hDetail);

						for (Hotel htl : hotelList) {
							Box hotelBox = Box.createHorizontalBox();

						}
					}

					if (!activityList.isEmpty()) {
						JLabel aDetail = new JLabel("Activity Details");
						aDetail.setFont(font);
						theBox.add(aDetail);
						for (Activity act : activityList) {

							Box activityBox = Box.createHorizontalBox();
						}
					}
					JLabel tDetail = new JLabel("Transport Details");
					tDetail.setFont(font);
					theBox.add(tDetail);
					if (!transportList.isEmpty()) {
						for (Transport trp : transportList) {
							Box transportBox = Box.createHorizontalBox();
						}
					}
					bookPackage = new JButton("Book Package");
					bookPackage.setActionCommand("Book Package #" + hp.getId());
					bookPackage.addActionListener(this);
					theBox.add(bookPackage);

					thePanel.add(theBox);
				}

				serviceProvider.ListPackages(hpList);
				System.out.println("Pacakge found: " + hpList.size());
			} else {
				thePanel.add(new JLabel("Opps!!! No Package Found for Given Criteria."));
			}
			resultPanel.add(thePanel);

			SwingUtilities.updateComponentTreeUI(frame);
		}

		if (e.getActionCommand().contains("Book Package")) {
			System.out.println("Book Package called" + e.getActionCommand());
			String packInfo[] = e.getActionCommand().split("#");
			int packageId = Integer.parseInt(packInfo[1]);

			HolidayPackage hp = serviceProvider.getPackageById(packageId);

			List<Hotel> hotelList = hp.getHotels();
			List<Activity> activityList = hp.getActivities();
			List<Flight> flightList = hp.getFlights();
			List<Transport> transportList = hp.getTransport();

			Box theBox = Box.createVerticalBox();
			JLabel msg = new JLabel("You Have Selected Below Pakckage");
			Font nameFont1 = new Font("Helvetica", Font.BOLD, 17);
			msg.setFont(nameFont1);
			theBox.add(msg);
			JLabel nameLabel = new JLabel("Package Name: " + hp.getName());
			Font nameFont = new Font("Helvetica", Font.BOLD, 16);
			nameLabel.setFont(nameFont);
			theBox.add(nameLabel);
			// addComp(thePanel, nameLabel, 0, count++, 1, 1, GridBagConstraints.EAST,
			// GridBagConstraints.NONE);

			JLabel descLabel = new JLabel("Description: " + hp.getDescription());
			theBox.add(descLabel);
			JLabel type = new JLabel("Type: " + hp.getType());
			theBox.add(type);
			JLabel duration = new JLabel("Duration: " + hp.getDuration());
			theBox.add(duration);
			JLabel fromCity = new JLabel("From City: " + hp.getFromCity());
			theBox.add(fromCity);

			Font font = new Font("Helvetica", Font.BOLD, 14);

			if (!flightList.isEmpty()) {
				JLabel fDetail = new JLabel("Flight Details");
				fDetail.setFont(font);
				theBox.add(fDetail);

				for (Flight flight : flightList) {
					Box flightBox = Box.createHorizontalBox();

				}
			}

			if (!hotelList.isEmpty()) {
				JLabel hDetail = new JLabel("Hotel Details");
				hDetail.setFont(font);
				theBox.add(hDetail);

				for (Hotel htl : hotelList) {
					Box hotelBox = Box.createHorizontalBox();

				}
			}

			if (!activityList.isEmpty()) {
				JLabel aDetail = new JLabel("Activity Details");
				aDetail.setFont(font);
				theBox.add(aDetail);
				for (Activity act : activityList) {

					Box activityBox = Box.createHorizontalBox();
				}
			}
			JLabel tDetail = new JLabel("Transport Details");
			tDetail.setFont(font);
			theBox.add(tDetail);
			if (!transportList.isEmpty()) {
				for (Transport trp : transportList) {
					Box transportBox = Box.createHorizontalBox();
				}
			}

			Double totalPrice = serviceProvider.getTotalPrice(hp);
			hp.setTotalPrice(totalPrice);

			JLabel price = new JLabel("Total Pacakge Price: " + totalPrice + "$");
			nameFont1 = new Font("Helvetica", Font.BOLD, 17);
			price.setFont(nameFont1);
			theBox.add(price);

			makePayment = new JButton("Make Payment");
			makePayment.setActionCommand("Make Payment #" + hp.getId());
			makePayment.addActionListener(this);
			theBox.add(makePayment);

			thePanel.add(theBox);

			resultPanel.add(thePanel);
			SwingUtilities.updateComponentTreeUI(frame);
		}
		
		if (e.getActionCommand().contains("Make Payment")) {
			System.out.println("Make Payment called" + e.getActionCommand());
			String packInfo[] = e.getActionCommand().split("#");
			int packageId = Integer.parseInt(packInfo[1]);

			HolidayPackage hp = serviceProvider.getPackageById(packageId);

			// write a form here and Submit button 
		}
	}

}
