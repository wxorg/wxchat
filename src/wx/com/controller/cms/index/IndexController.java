package wx.com.controller.cms.index;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.Sub_Menu;
import wx.com.entity.WX_Menu;
import wx.com.entity.cms.plat.PlatForm;
import wx.com.entity.cms.index.Index;
import wx.com.entity.send.Article;
import wx.com.entity.send.Msg_News_Out;
import wx.com.service.cms.index.IIndexManager;
import wx.com.service.cms.plat.ISelectPlatFormManager;
import wx.com.util.ConfigureClass;
import wx.com.util.StringUtil;

@Controller
@RequestMapping(value="protected")
@SuppressWarnings("all")
public class IndexController {
	
	@Resource(name="indexManager")
	private IIndexManager indexManager;
	
	@Resource(name="selectPlatFormManager") 
    public ISelectPlatFormManager selectPlatFormManager; 
	
	public ISelectPlatFormManager getSelectPlatFormManager() {
		return selectPlatFormManager;
	}

	public void setSelectPlatFormManager(ISelectPlatFormManager selectPlatFormManager) {
		this.selectPlatFormManager = selectPlatFormManager;
	}
	
	
	
	@RequestMapping(value="/wx_index",method = RequestMethod.GET)
	public ModelAndView  getwx_index(HttpServletRequest httpRequest){
		
		byte msgtype =-1;
		
		byte currentpage=1;
		byte numPerpage=10;
		byte indextype =-1;
		String keyword = httpRequest.getParameter("keyword");
		String currpage = httpRequest.getParameter("currentpage");
		String numPpage = httpRequest.getParameter("numPerpage");
		String msgttype = httpRequest.getParameter("msgtype");
				
		try {
			if(null!=keyword){
				keyword=new String(keyword.getBytes("iso8859-1"),"utf-8");				
				System.out.println(keyword);
			}
			
			if(null!= currpage){
				currentpage = Byte.valueOf(currpage);
			}
			
			if(null!= numPpage){
				indextype = Byte.valueOf(numPpage);
			}
			
			if(null!= msgttype){
				msgtype = Byte.valueOf(msgttype);
			}

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Index> indexList = new ArrayList<Index>();
		
		indexList.add(indexManager.getIndex("1",1));
		indexList.add(indexManager.getIndex("2",2));
		indexList.add(indexManager.getIndex("3",3));
		
		//此步骤需要 用注解实例化
		//SelectPlatFormManager selectPlatFormManager =new SelectPlatFormManager();
		String platId = httpRequest.getParameter("platId");
		
//		System.out.println("platId="+platId);
    	//PlatForm platForm=selectPlatFormManager.getPlatFormById(platId);
		PlatForm platForm=null;
		try{
    		platForm=selectPlatFormManager.getPlatFormById(Integer.valueOf(platId));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		 
    	httpRequest.getSession().setAttribute("_platform_", platForm);
    	Map map = new HashMap();
    	/*
    	map.put("indexList", indexList);
    	map.put("totlepage",11);
    	map.put("currpage",2);
    	*/
    	map.putAll(indexManager.getIndexBySelect(keyword, indextype,msgtype,numPerpage,currentpage, platForm.getPlatID()));
		
		
		return new ModelAndView("/protected/index/wx_index","indexmap",map);
		
	/*	@SuppressWarnings("rawtypes")
		java.util.Enumeration enum1=httpRequest.getParameterNames();		
		//Enumeration enu=request.getParameterNames(); 
        while(enum1.hasMoreElements()) 
        { 
            String name=(String)enum1.nextElement(); 
            System.out.println(name);
        }*/
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
		submenu1.add(new Sub_Menu((byte)0, "子菜单1", "http://localhost/SpringMVC/protected/wx_index_menu"));
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
