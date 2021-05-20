package Contollers;

import GUI.FeedbackView;
import GUI.HomePageView;
import GUI.MainFrameView;

public class FeedbackController {
	MainFrameView mainFrameView;
	FeedbackView feedbackView;
    public FeedbackController(MainFrameView mainFrameView, FeedbackView feedbackView ) {
    	this.mainFrameView=mainFrameView;
        this.feedbackView = feedbackView;
    }
}
