package wx.com.entity.cms.menu;

import java.util.Hashtable;
//import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class WX_Menu {
	
	private String id;
	private int mainMenuCount;
	private Map mainMenu = new Hashtable(3);
	
	/*private short isMainMenu;//0：不是主菜单，1：为主菜单
	private short menuSort;//菜单的排序
	private int mainCount ;*/
	
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

