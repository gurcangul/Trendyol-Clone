package Contollers;

import GUI.FeedbackView;

import javax.swing.JPanel;

import GUI.AboutAppView;
import GUI.BuyerHomePageView;
import GUI.MainFrameView;
import GUI.MenuViewForBuyer;

public class AboutAppController {
	MainFrameView mainFrameView;
	AboutAppView aboutAppView;
	JPanel menuView;
    public AboutAppController(MainFrameView mainFrameView, AboutAppView aboutAppView  ) {
    	this.mainFrameView=mainFrameView;
        this.aboutAppView = aboutAppView;
        this.menuView=(JPanel) menuView;
        
    }
}
