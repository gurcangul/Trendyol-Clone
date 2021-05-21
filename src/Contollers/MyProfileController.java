package Contollers;

import GUI.HomePageView;
import GUI.MainFrameView;
import GUI.MyProfileView;

public class MyProfileController {
	private final  MainFrameView mainFrameView;
	private final  MyProfileView myProfileView;
    public MyProfileController(MainFrameView mainFrameView, MyProfileView myProfileView ) {
    	this.mainFrameView=mainFrameView;
        this.myProfileView = myProfileView;
        //myProfileView.addViewAllUsersButtonActionListener(new viewAllUsersButtonActionListener());	
    }

}
