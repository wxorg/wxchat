package wx.com.entity;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class WX_Menu {
	
	private String id;
	private int mainMenuCount;
	private Map mainMenu = new Hashtable(3);
	
	
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getMainMenuCount() {
		return mainMenuCount;
	}



	public void setMainMenuCount(int mainMenuCount) {
		this.mainMenuCount = mainMenuCount;
	}


	public Map getMainMenu() {
		return mainMenu;
	}



	public void setMainMenu(Map mainMenu) {
		this.mainMenu = mainMenu;
	}





	
	
	
	

}
