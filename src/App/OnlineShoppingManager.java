package App;

import GUI.MainFrame;
import GUI.WelcomePanel;

public class OnlineShoppingManager {
	 MainFrame mainFrame;

	    public OnlineShoppingManager() {
	        this.mainFrame = new MainFrame();
	    } 
		public void start(){ 
	        @SuppressWarnings("unused")
			WelcomePanel welcomePanel = new WelcomePanel(mainFrame);//First Panel to welcome our users
	        //LoginController loginController = new LoginController(loginView);//panel checker
	    }
		public MainFrame getMainFrame() {
			return mainFrame;
		}
		public void setMainFrame(MainFrame mainFrame) {
			this.mainFrame = mainFrame;
		}
}
