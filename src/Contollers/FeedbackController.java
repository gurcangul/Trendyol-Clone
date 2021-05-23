package Contollers;

import GUI.FeedbackView;

import javax.swing.JPanel;

import GUI.BuyerHomePageView;
import GUI.MainFrameView;
import GUI.MenuViewForBuyer;

public class FeedbackController {
	MainFrameView mainFrameView;
	FeedbackView feedbackView;
	JPanel menuView;
    public FeedbackController(MainFrameView mainFrameView, FeedbackView feedbackView  ) {
    	this.mainFrameView=mainFrameView;
        this.feedbackView = feedbackView;
        this.menuView=(JPanel) menuView;
        
    }
}
