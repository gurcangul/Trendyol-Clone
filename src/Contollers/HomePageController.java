package Contollers;

import GUI.BeforeLoginView;
import GUI.HomePageView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import User.User;

public class HomePageController {
	private final  MainFrameView mainFrameView;
	private final  HomePageView homePageView;
    public HomePageController(MainFrameView mainFrameView, HomePageView homePageView ) {
    	this.mainFrameView=mainFrameView;
        this.homePageView = homePageView;
    }

    
}
