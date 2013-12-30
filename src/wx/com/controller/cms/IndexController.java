package wx.com.controller.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.Sub_Menu;
import wx.com.entity.WX_Menu;
import wx.com.entity.cms.PlatForm;
import wx.com.entity.cms.index.Index;
import wx.com.entity.send.Article;
import wx.com.entity.send.Msg_News_Out;
import wx.com.service.cms.index.IIndexManager;
import wx.com.service.cms.plat.SelectPlatFormManager;
import wx.com.util.ConfigureClass;
import wx.com.util.StringUtil;

@Controller
@RequestMapping(value="protected")
public class IndexController {
	
	@Resource(name="indexManager")
	private IIndexManager indexManager;
	
	@RequestMapping(value="/wx_index",method = RequestMethod.GET)
	public ModelAndView  getwx_index(HttpServletRequest httpRequest){
	
		List<Index> indexList = new ArrayList<Index>();
		
		indexList.add(indexManager.getIndex("1","1"));
		indexList.add(indexManager.getIndex("2","1"));
		indexList.add(indexManager.getIndex("3","1"));
		SelectPlatFormManager selectPlatFormManager =new SelectPlatFormManager();
		String origId = httpRequest.getParameter("origId");
    	PlatForm platForm=selectPlatFormManager.getPlatFormById(origId);
		 
    	httpRequest.getSession().setAttribute("_platform_", platForm);
    	Map map = new HashMap();
    	map.put("indexList", indexList);
    	
    	Msg_News_Out msg_News = new Msg_News_Out();
//		msg_News.setToUserName(msg.getFromUserName());
//		msg_News.setFromUserName(msg.getToUserName());
		msg_News.setCreateTime(StringUtil.getTime());
//		msg_News.setMsgType("new");
		msg_News.setArticleCount(Integer.valueOf(2));
		Article article1 = new Article();
		article1.setTitle("图片1展示");
		article1.setDiscription("图片1展示图片1展示图片1展示图片1展示图片1展示");
		article1.setPicUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
		article1.setUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
		
		Article article2 = new Article();
		article2.setTitle("图片2展示");
		article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
		article2.setPicUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
		article2.setUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
		
		
		msg_News.getArticles().add(article1);
		msg_News.getArticles().add(article2);
	
//		System.out.println(msg_News.getArticles().size());
		List<Msg_News_Out> newslist = new ArrayList<Msg_News_Out>();
		newslist.add(msg_News);
		newslist.add(msg_News);
		
		
    	map.put("newslist",newslist);
    	map.get("indexList");
		return new ModelAndView("/protected/index/wx_index","indexList",indexList);
	}

	
	@RequestMapping(value="/wx_index",method = RequestMethod.POST)
	public String  checkSig(HttpServletRequest httpRequest,HttpServletResponse httpRespon){
	
		System.out.println("dsf");
		List<Index> indexList = new ArrayList<Index>();
		
		indexList.add(indexManager.getIndex("1","1"));
		indexList.add(indexManager.getIndex("2","1"));
		
		httpRequest.getSession().setAttribute("indexList", indexList);
	
		return "/protected/index/wx_index";
		
	}
	
	
	@RequestMapping(value="/wx_index_add",method = RequestMethod.GET)
	public ModelAndView  getwx_index_add(HttpServletRequest httpRequest){
	
		
		
		Msg_News_Out msg_News = new Msg_News_Out();
//		msg_News.setToUserName(msg.getFromUserName());
//		msg_News.setFromUserName(msg.getToUserName());
		msg_News.setCreateTime(StringUtil.getTime());
//		msg_News.setMsgType("new");
		msg_News.setArticleCount(Integer.valueOf(2));
		Article article1 = new Article();
		article1.setTitle("图片1展示");
		article1.setDiscription("图片1展示图片1展示图片1展示图片1展示图片1展示");
		article1.setPicUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
		article1.setUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
		
		Article article2 = new Article();
		article2.setTitle("图片2展示");
		article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
		article2.setPicUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
		article2.setUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
		
		
		msg_News.getArticles().add(article1);
		msg_News.getArticles().add(article2);
	
//		System.out.println(msg_News.getArticles().size());
		List<Msg_News_Out> newslist = new ArrayList<Msg_News_Out>();
		newslist.add(msg_News);
		newslist.add(msg_News);
		
		Map map = new HashMap();
    	map.put("newslist",newslist);
		return new ModelAndView("/protected/index/wx_index_add","newslist",newslist);
	}
	
	@RequestMapping(value="/wx_index_add",method = RequestMethod.POST)
	public ModelAndView  postwx_index_add(HttpServletRequest httpRequest){
	
		
		System.out.println("dd");
		 
		return new ModelAndView("/protected/index/wx_index_add");
	}
	
	@RequestMapping(value="/wx_index_menu",method = RequestMethod.GET)
	public ModelAndView  getwx_index_menu(HttpServletRequest httpRequest){
	
		WX_Menu wx_menu = new WX_Menu();
		
		wx_menu.setMainMenuCount(2);
		
		List<Sub_Menu> submenu1 = new Vector<Sub_Menu>(5);
		submenu1.add(new Sub_Menu((byte)0, "子菜单1", "11"));
		submenu1.add(new Sub_Menu((byte)0, "子菜单2", "12"));
		
		wx_menu.getMainMenu().put("主菜单一", submenu1);
		wx_menu.getMainMenu().put("主菜单二", submenu1);
//		submenu1.get(0).getMenuName()
		 
		return new ModelAndView("/protected/index/wx_index_menu","wx_menu",wx_menu);
	}
	
	
	
	public IIndexManager getIndexManager() {
		return indexManager;
	}

	public void setIndexManager(IIndexManager indexManager) {
		this.indexManager = indexManager;
	}
	
	
	

}
