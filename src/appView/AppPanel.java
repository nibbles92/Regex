package appView;

import java.awt.event.*;
import javax.swing.*;
import appController.AppController;

public class AppPanel extends JPanel
	{
		private AppController controller;
		private SpringLayout layout;

		private JLabel firstNameLabel;
		private JLabel lastNameLabel;
		private JLabel userNumberLabel;
		private JLabel userMailLabel;

		private JTextField firstNameField;
		private JTextField lastNameField;
		private JTextField userNumberField;
		private JTextField userMailField;

		private JComboBox<String> selectEmailBox;

		private JButton createButton;

		public AppPanel(AppController controller)
			{
				this.controller = controller;
				layout = new SpringLayout();
				createButton = new JButton("create profile");
				layout.putConstraint(SpringLayout.EAST, createButton, -463, SpringLayout.EAST, this);
				firstNameLabel = new JLabel("first name :");
				layout.putConstraint(SpringLayout.WEST, firstNameLabel, 10, SpringLayout.WEST, this);
				
				lastNameLabel = new JLabel("last name :");
				layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 0, SpringLayout.NORTH, firstNameLabel);
				layout.putConstraint(SpringLayout.WEST, lastNameLabel, 68, SpringLayout.EAST, firstNameLabel);
				
				userNumberLabel = new JLabel("Phone number");
				layout.putConstraint(SpringLayout.EAST, userNumberLabel, 0, SpringLayout.EAST, lastNameLabel);
			
				userMailLabel = new JLabel("email :");
				layout.putConstraint(SpringLayout.NORTH, userMailLabel, 0, SpringLayout.NORTH, userNumberLabel);
				layout.putConstraint(SpringLayout.WEST, userMailLabel, 0, SpringLayout.WEST, firstNameLabel);


				firstNameField = new JTextField();
				layout.putConstraint(SpringLayout.NORTH, firstNameField, 31, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.SOUTH, firstNameLabel, -5, SpringLayout.NORTH, firstNameField);
				layout.putConstraint(SpringLayout.EAST, firstNameField, -478, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.WEST, firstNameField, 10, SpringLayout.WEST, this);
			
				lastNameField = new JTextField();
				layout.putConstraint(SpringLayout.NORTH, userNumberLabel, 5, SpringLayout.SOUTH, lastNameField);
				layout.putConstraint(SpringLayout.NORTH, lastNameField, 6, SpringLayout.SOUTH, lastNameLabel);
				layout.putConstraint(SpringLayout.WEST, lastNameField, 0, SpringLayout.WEST, lastNameLabel);
	
				userNumberField = new JTextField();
				layout.putConstraint(SpringLayout.NORTH, userNumberField, 16, SpringLayout.SOUTH, userMailLabel);
				layout.putConstraint(SpringLayout.NORTH, createButton, 35, SpringLayout.SOUTH, userNumberField);
				layout.putConstraint(SpringLayout.WEST, userNumberField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.EAST, userNumberField, -485, SpringLayout.EAST, this);

				userMailField = new JTextField();
				layout.putConstraint(SpringLayout.EAST, lastNameField, 0, SpringLayout.EAST, userMailField);
				layout.putConstraint(SpringLayout.NORTH, userMailField, 0, SpringLayout.NORTH, userNumberField);
				layout.putConstraint(SpringLayout.WEST, userMailField, 17, SpringLayout.EAST, userNumberField);
				layout.putConstraint(SpringLayout.EAST, userMailField, 152, SpringLayout.EAST, userNumberField);
			

				buildComponents();
				buildListeners();
				buildPlacements();
			}

		private void buildComponents()
			{
				setLayout(layout);
				add(firstNameLabel);
				add(lastNameLabel);
				add(userNumberLabel);
				add(userMailLabel);

				add(firstNameField);
				add(lastNameField);
				add(userNumberField);
				add(userMailField);
				add(createButton);
				

			}

		private void buildListeners()
			{	
				createButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent clicked)
						{
							controller.createAccount();
						}
					});
			}

		private void buildPlacements()
			{
				
			}

		public JTextField getFirstNameField()
			{
				return firstNameField;
			}

		public JTextField getLastNameField()
			{
				return lastNameField;
			}

		public JTextField getUserNumberField()
			{
				return userNumberField;
			}

		public JTextField getUserMailField()
			{
				return userMailField;
			}

		public JComboBox<String> getSelectEmailBox()
			{
				return selectEmailBox;
			}
	}
