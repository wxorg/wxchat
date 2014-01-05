package wx.com.entity.cms.menu;

public class Sub_Menu{

	private byte menuType;
	private String menuName;
	private String keywordOrUrl;
	
	public Sub_Menu(byte _menuType,String _menuName,String _keywordOrUrl){
		this.menuName = _menuName;
		this.menuType = _menuType;
		this.keywordOrUrl = _keywordOrUrl;
	}

	public byte getMenuType() {
		return menuType;
	}

	public void setMenuType(byte menuType) {
		this.menuType = menuType;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getKeywordOrUrl() {
		return keywordOrUrl;
	}

	public void setKeywordOrUrl(String keywordOrUrl) {
		this.keywordOrUrl = keywordOrUrl;
	}

	
	
	
}