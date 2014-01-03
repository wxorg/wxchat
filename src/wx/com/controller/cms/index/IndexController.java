package wx.com.controller.cms.index;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
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
	
	@RequestMapping(value="/wx_index",method = RequestMethod.GET)
	public ModelAndView  getwx_index(HttpServletRequest httpRequest){
		
		short msgtype =-1;
		
		short currentpage=1;
		short numPerpage=10;
		short indextype =-1;
		
		
		
		String numPpage = httpRequest.getParameter("numPerpage");
		
	/*	out======>keyword
		out======>indextype
		out======>msgtype*/
		
		@SuppressWarnings("rawtypes")
		java.util.Enumeration enum1=httpRequest.getParameterNames();		
		//Enumeration enu=request.getParameterNames(); 
        while(enum1.hasMoreElements()) 
        { 
            String name=(String)enum1.nextElement(); 
            System.out.println("out======>"+name);
        }
		
		String sqlWhere="";		
		try {
			String keyword = httpRequest.getParameter("keyword");
			if(null!=keyword && keyword.length()>0 ){
				keyword=new String(keyword.getBytes("iso8859-1"),"utf-8");		
				sqlWhere=" and ( t.keyWord like '%"+keyword+"%'";
			}
			
			String currpage = httpRequest.getParameter("currentpage");
			if(null!= currpage){
				currentpage = Short.valueOf(currpage);
			}else{
				currentpage=0;
			}
			
			String indexType  = httpRequest.getParameter("indextype");
			if(null!= indexType && !indexType.equals("-1")){
				indextype = Short.valueOf(indexType);
				if(sqlWhere.length()>5)
					sqlWhere=sqlWhere+" or t.indexType = "+indextype;
				else
					sqlWhere=" and ( t.indexType = "+indextype;
			}
			
			String msgType = httpRequest.getParameter("msgtype");
			if(null!= msgType && !msgType.equals("-1")){
				msgtype = Short.valueOf(msgType);
				if(sqlWhere.length()>5)
					sqlWhere=sqlWhere+" or t.msgType = "+msgtype;
				else
					sqlWhere="and ( t.msgType = "+msgtype;
			}
			if(sqlWhere.length()>5)
				sqlWhere = sqlWhere + ")";
			
			System.out.println("keyWord="+keyword+";currpage="+currpage+";numPpage="+numPpage+";msgttype="+msgType+";indexType"+indexType);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		List<Index> indexList = new ArrayList<Index>();
		
		indexList.add(indexManager.getIndex("1",1));
		indexList.add(indexManager.getIndex("2",2));
		indexList.add(indexManager.getIndex("3",3));
		
		//此步骤需要 用注解实例化
		//SelectPlatFormManager selectPlatFormManager =new SelectPlatFormManager();
		if(null!=httpRequest.getParameter("platId")){
			String platId = httpRequest.getParameter("platId");
			
			PlatForm platForm=null;
			try{
	    		platForm=selectPlatFormManager.getPlatFormById(Integer.valueOf(platId));
			}catch(Exception ex){
				ex.printStackTrace();
			}
			 
	    	httpRequest.getSession().setAttribute("_platform_", platForm);
		}
		PlatForm platForm = (PlatForm) httpRequest.getSession().getAttribute("_platform_");
    	Map map = new HashMap();
//    	keyWord=null;currpagenull;numPpage=null;msgttype=null
    	System.out.println("numPerpage="+numPerpage+";currentpage"+currentpage+";PlatID="+ platForm.getPlatID());
    	map.putAll(indexManager.getIndexBySelect(sqlWhere,numPerpage,currentpage, platForm.getPlatID()));
		
		return new ModelAndView("/protected/index/wx_index","indexmap",map);
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
		
		String indextype = httpRequest.getParameter("indextype");
		String keyword = httpRequest.getParameter("keyword");
		String msgtype = httpRequest.getParameter("msgType");
		String text = httpRequest.getParameter("text");
		
		if(indextype.equals("0")|| indextype.equals("1") || null == keyword )
			keyword="";
		short indexType=0;
		short msgType=0;
		try{
			indexType = Short.valueOf(indextype);
			msgType = Short.valueOf(msgtype);
		}catch(Exception ex){
			httpRequest.getSession().setAttribute("addIndex_info", "indexType or msgType is error");
			return new ModelAndView("/protected/index/wx_index_add?index_error=1");
		}
		
		System.out.println("keyword="+keyword+";indextype="+indextype+";msgtype="+msgtype+";text="+text);
		System.out.println("==================================");
		PlatForm platForm = (PlatForm)httpRequest.getSession().getAttribute("_platform_");//.setAttribute("_platform_", platForm);
		Index index = new Index();
		index.setIndexType(indexType);
		index.setKeyWord(keyword);
		index.setMsgType(msgType);
		index.setPlatId(platForm.getPlatID());
		index.setCreatTime(new Timestamp(System.currentTimeMillis()));
		index.setValid(true);
		if(msgType==2){
			index.setMediaId(Long.valueOf(text));
		}else{
			index.setText(text);
		}
		
		boolean isOK=false;
		
		if(!indexManager.isExistIndex(index))
			isOK=indexManager.addIndex(index);
		if(isOK)
			return new ModelAndView("/protected/index/wx_index_add?index_success=1");
		else{
			httpRequest.getSession().setAttribute("addIndex_info", "addIndex fail");
			return new ModelAndView("/protected/index/wx_index_add?index_error=1");
		}
		
	}
	
	@RequestMapping(value="/wx_index_menu",method = RequestMethod.GET)
	public ModelAndView  getwx_index_menu(HttpServletRequest httpRequest){
	
		WX_Menu wx_menu = new WX_Menu();
		
		wx_menu.setMainMenuCount(2);
		
		List<Sub_Menu> submenu1 = new Vector<Sub_Menu>(5);
		submenu1.add(new Sub_Menu((byte)0, "子菜单1", "http://localhost/SpringMVC/protected/wx_index_menu"));
		submenu1.add(new Sub_Menu((byte)1, "子菜单2", "12"));
		
		
		wx_menu.getMainMenu().put("主菜单一", submenu1);
		wx_menu.getMainMenu().put("主菜单二", submenu1);
//		submenu1.get(0).getMenuName()
		
		List<Index> indexlist= new ArrayList<Index>();
		indexlist.addAll(indexManager.getIndexByIndexType((byte)2,((PlatForm) httpRequest.getSession().getAttribute("_platform_")).getPlatID()));
		//indexlist.get(0).getKeyword();
		 Map map = new HashMap();
		 map.put("wx_menu", wx_menu);
		 map.put("indexlist", indexlist);
//		 map.get("wx_menu")
		return new ModelAndView("/protected/index/wx_index_menu","mapindex",map);
	}
	
	
	@RequestMapping(value="/wx_index_menu",method = RequestMethod.POST)
	public ModelAndView  postwx_index_menu(HttpServletRequest httpRequest) throws JSONException{
	
		String menujson =  httpRequest.getParameter("menu");
		
		
		
		System.out.println(menujson);
		
		
		return new ModelAndView("/protected/index/wx_index_menu");
	}
	
	
	
	
	
	public IIndexManager getIndexManager() {
		return indexManager;
	}

	public void setIndexManager(IIndexManager indexManager) {
		this.indexManager = indexManager;
	}
	
	public ISelectPlatFormManager getSelectPlatFormManager() {
		return selectPlatFormManager;
	}

	public void setSelectPlatFormManager(ISelectPlatFormManager selectPlatFormManager) {
		this.selectPlatFormManager = selectPlatFormManager;
	}
	
	
	

}
