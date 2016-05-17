package appView;

import javax.swing.*;
import appController.AppController;

public class AppFrame extends JFrame
	{
		private AppPanel panel;
		
		public AppFrame(AppController controller)
		{
			panel = new AppPanel(controller);
			
			buildWindow();
		}
		
		private void buildWindow()
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setContentPane(panel);
			this.setTitle("The Regex will work");
			this.setSize(600,600);
			this.setVisible(true);
		}
		
		public AppPanel getPanel()
		{
			return panel;
		}
	}