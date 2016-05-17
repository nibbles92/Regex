package appController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import appView.AppFrame;
import appView.AppPanel;

public class AppController
	{
		private AppFrame frame;

		private String firstNameError;
		private String lastNameError;
		private String numberError;
		private String emailError;
		
		private String firstName;
		private String lastName;
		private String userNumber;
		private String userEmail;

		public AppController()
			{
				frame = new AppFrame(this);
			}

		public void createAccount()
			{
				nameChecker();
				numberChecker();
				emailChecker();

				if (nameChecker() == true && numberChecker() == true && emailChecker() == true)
					{
						JOptionPane.showMessageDialog(null, "Account Created!"
								+ "\nName: " + firstName + " " + lastName + "\nPhone Number: " + userNumber
								+ "\nEmail: " + userEmail);
					}
				else
					{
							JOptionPane.showMessageDialog(null, firstNameError + "\n" + lastNameError + "\n" + numberError + "\n" + emailError);
					}
			}

		private boolean nameChecker()
			{
				firstName = panel().getFirstNameField().getText();
				lastName = panel().getLastNameField().getText();

				firstNameError = "";
				lastNameError = "";

				boolean doesPass = true;

				if (firstName.contains(" ") || firstName.matches(".*\\d.*") || firstName.length() > 30 || firstName.length() < 2)
					{
						firstNameError = "FIRST NAME ERROR: errors or too long or too short";
						doesPass = false;
					}
				if (lastName.contains(" ") || lastName.length() > 40 || lastName.length() < 2)
					{
						lastNameError = "LAST NAME ERROR: have involed illegal symbols";
						doesPass = false;
					}

				return doesPass;
			}

		private boolean numberChecker()
			{
				userNumber = panel().getUserNumberField().getText();

				numberError = "";
				boolean doesPass = true;

				if (userNumber.length() > 10)
					{
						numberError = "NUMBER ERROR: Too many numbers were entered.";
						doesPass = false;
					}
				if (userNumber.length() < 10)
					{
						numberError = "NUMBER ERROR: Too few numbers were entered.";
						doesPass = false;
					}
				if (userNumber.matches(".*[a-zA-Z]+.*"))
					{
						numberError = "NUMBER ERROR: Contains letters!";
						doesPass = false;
					}

				return doesPass;
			}

		private boolean emailChecker()
			{
				userEmail = panel().getUserMailField().getText();

				String EMAL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				Pattern emailPattern = Pattern.compile(EMAL_PATTERN);
				Matcher matcher = emailPattern.matcher(userEmail);
				
				emailError = "";
				boolean doesPass = true;

				if (matcher.matches() == true|| userEmail.length() > 20 || userEmail.isEmpty())
					{
						emailError = "EMAIL ERROR: Cannot contain spaces or characters and must be less than 20 characters.";
						doesPass = false;
					}
				return doesPass;
			}

		public void clearFields()
			{
				panel().getFirstNameField().setText(null);
				panel().getLastNameField().setText(null);
				panel().getUserNumberField().setText(null);
				panel().getUserMailField().setText(null);
			}

		public AppPanel panel()
			{
				return frame.getPanel();
			}
	}