package wx.com.controller.cms.index;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletResponse;





import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.cms.menu.Sub_Menu;
import wx.com.entity.cms.menu.WXDBMenu;
import wx.com.entity.cms.menu.WX_Menu;
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
		
		/*@SuppressWarnings("rawtypes")
		java.util.Enumeration enum1=httpRequest.getParameterNames();		
		//Enumeration enu=request.getParameterNames(); 
        while(enum1.hasMoreElements()) 
        { 
            String name=(String)enum1.nextElement(); 
            System.out.println("out======>"+name);
        }*/
		
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
				currentpage=1;
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
    	try{
    		System.out.println("numPerpage="+numPerpage+";currentpage"+currentpage+";PlatID="+ platForm.getPlatID());
    		map.putAll(indexManager.getIndexBySelect(sqlWhere,numPerpage,currentpage, platForm.getPlatID()));
    	}catch(Exception ex){
    		//System.out.println("==========start========");
    		//ex.printStackTrace();
    		//System.out.println("==========end========");
    		map = null;
    	}
    	
		
		return new ModelAndView("/protected/index/wx_index","indexmap",map);
	}
	
	
	
	@RequestMapping(value="/wx_index_del",method = RequestMethod.POST)
	public void  getwx_index_del(HttpServletRequest httpRequest,HttpServletResponse response) throws IOException{
	
		
		String index = httpRequest.getParameter("id");
		System.out.println(index);
		response.getWriter().write("true");
		response.getWriter().flush();
		
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
		article1.setPicUrl("/static/a1.jpg");
		article1.setUrl("/static/a1.jpg");//ConfigureClass.getWEBURL()+
		
		Article article2 = new Article();
		article2.setTitle("图片2展示");
		article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
		article2.setPicUrl("/static/a2.jpg");//ConfigureClass.getWEBURL()+
		article2.setUrl("/static/a2.jpg");//ConfigureClass.getWEBURL()+
		
		
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
	
	@RequestMapping(value="/wx_index_edit",method = RequestMethod.GET)
	public ModelAndView  getwx_index_edit(HttpServletRequest httpRequest){
	
		String indexId = httpRequest.getParameter("indexId");
		System.out.println(indexId +"--------------------------------");
		
		Msg_News_Out msg_News = new Msg_News_Out();
//		msg_News.setToUserName(msg.getFromUserName());
//		msg_News.setFromUserName(msg.getToUserName());
		msg_News.setCreateTime(StringUtil.getTime());
//		msg_News.setMsgType("new");
		msg_News.setArticleCount(Integer.valueOf(2));
		Article article1 = new Article();
		article1.setTitle("图片1展示");
		article1.setDiscription("图片1展示图片1展示图片1展示图片1展示图片1展示");
		article1.setPicUrl("/static/a1.jpg");
		article1.setUrl("/static/a1.jpg");//ConfigureClass.getWEBURL()+
		
		Article article2 = new Article();
		article2.setTitle("图片2展示");
		article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
		article2.setPicUrl("/static/a2.jpg");//ConfigureClass.getWEBURL()+
		article2.setUrl("/static/a2.jpg");//ConfigureClass.getWEBURL()+
		
		
		msg_News.getArticles().add(article1);
		msg_News.getArticles().add(article2);
	
//		System.out.println(msg_News.getArticles().size());
		List<Msg_News_Out> newslist = new ArrayList<Msg_News_Out>();
		newslist.add(msg_News);
		newslist.add(msg_News);
		
		Map map = new HashMap();
    	map.put("newslist",newslist);
		return new ModelAndView("/protected/index/wx_index_edit","newslist",newslist);
	}
	
	@RequestMapping(value="/wx_index_add",method = RequestMethod.POST)
	public ModelAndView  postwx_index_add(HttpServletRequest httpRequest){
		
		String indextype = httpRequest.getParameter("indextype");
		String keyword = httpRequest.getParameter("keyword");
		String msgtype = httpRequest.getParameter("msgType");
		String text = httpRequest.getParameter("text");
		
		System.out.println("ddd");
		System.out.println("keyword="+keyword+";indextype="+indextype+";msgtype="+msgtype+";text="+text);
		if(indextype.equals("0")|| indextype.equals("1") || null == keyword )
			keyword="";
		short indexType=0;
		short msgType=0;
		boolean isRetrun = true;
		try{
			indexType = Short.valueOf(indextype);
			msgType = Short.valueOf(msgtype);
			if(indexType<0){
				isRetrun=false;
			}
		}catch(Exception ex){
			isRetrun=false;
		}
		
		if(!isRetrun){
			httpRequest.getSession().setAttribute("addIndex_info", "indexType or msgType is error");
			return new ModelAndView("/protected/index/wx_index_add","index_error",1);
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
			return new ModelAndView("/protected/index/wx_index_add","index_error",1);
		else{
			httpRequest.getSession().setAttribute("addIndex_info", "addIndex fail");
			return new ModelAndView("/protected/index/wx_index_add");
		}
		
	}
	
	@RequestMapping(value="/wx_index_menu",method = RequestMethod.GET)
	public ModelAndView  getwx_index_menu(HttpServletRequest httpRequest){
		
		
		PlatForm platForm = (PlatForm) httpRequest.getSession().getAttribute("_platform_");
		if(platForm==null || platForm.getPlatID()<=0){
			System.out.println("1");
			httpRequest.getSession().setAttribute("addIndex_info", "platForm is null");
			return new ModelAndView("/protected/index/wx_index_menu");
		}
		WXDBMenu menu = indexManager.queryMenuByPlatID(platForm.getPlatID());
		if(menu==null){
			System.out.println("2");
			httpRequest.getSession().setAttribute("addIndex_info", "menu is null");
			return new ModelAndView("/protected/index/wx_index_menu");
		}
		//System.out.println(menu.getMenuJson());
		WX_Menu wx_menu = new WX_Menu();
		try{
			JSONObject jsonobj=new JSONObject("{\"array\":"+menu.getMenuJson()+"}");//将字符串转化成json对象 
			
			
			String name=jsonobj.getString("array");//获取字符串。
			System.out.println("alljson==="+name);
			JSONArray array=jsonobj.getJSONArray("array");//获取数组
			
			wx_menu.setMainMenuCount(array.length());//主菜单个数
			System.out.println("len="+array.length());
			for(int i=0;i<array.length();i++){
				JSONObject tmpJson = array.getJSONObject(i);
				System.out.println("1====="+tmpJson.toString());
				JSONArray tmpArray = tmpJson.getJSONArray("submenus");
				List<Sub_Menu> submenuList = new Vector<Sub_Menu>(tmpArray.length());
				for(int k=0;k<tmpArray.length();k++){
					JSONObject tmpJson2 = tmpArray.getJSONObject(k);
					try{
						submenuList.add(new Sub_Menu((byte)tmpJson2.getInt("menutype"),tmpJson2.getString("menuname"), tmpJson2.getString("word")));
					}catch(Exception ex){
						ex.printStackTrace();
					}
					System.out.println("2==="+tmpJson2.toString());
					System.out.println("2=="+tmpJson2.getString("menuname"));
					//JSONArray tmpArray = tmpJson.getJSONArray("submenus");
				}
				if(submenuList!=null&&submenuList.size()>0)
					wx_menu.getMainMenu().put(tmpJson.getString("menuname"), submenuList);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			httpRequest.getSession().setAttribute("addIndex_info", "menujson is error");
			System.out.println("3");
			return new ModelAndView("/protected/index/wx_index_menu","index_error",1);
		}
		List<Index> indexlist= new ArrayList<Index>();
		//indexlist.addAll(indexManager.getIndexByIndexType((byte)2,((PlatForm) httpRequest.getSession().getAttribute("_platform_")).getPlatID()));
		//indexDAO.getIndexBySelect(whereQuery, numPerpage, curPage, platId)
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
		
		PlatForm platForm = (PlatForm) httpRequest.getSession().getAttribute("_platform_");
		if(platForm==null || platForm.getPlatID()<=0){
			httpRequest.getSession().setAttribute("addIndex_info", "platForm is null");
			return new ModelAndView("/protected/index/wx_index_menu","index_error",1);
		}
		WXDBMenu menu = indexManager.queryMenuByPlatID(platForm.getPlatID());
		int dealFlag=-1;
		if(menu==null){
			menu = new WXDBMenu();
			menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
			menu.setPlatId(platForm.getPlatID());
			menu.setMenuJson(menujson);
			menu.setValid(true);
			dealFlag=0;
		}else{
			menu.setMenuJson(menujson);
			menu.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			dealFlag=1;
		}
		
		if(!indexManager.saveOrUpdateMenu(menu,dealFlag)){
			httpRequest.getSession().setAttribute("addIndex_info", "save menu fail");
			return new ModelAndView("/protected/index/wx_index_menu","index_error",1);
		}else {
			return new ModelAndView("/protected/index/wx_index_menu","index_success",1);
		}
		
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
