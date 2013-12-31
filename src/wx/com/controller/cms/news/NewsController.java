package wx.com.controller.cms.news;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.cms.plat.PlatForm;
import wx.com.entity.send.Article;
import wx.com.entity.send.Msg_News_Out;
import wx.com.service.cms.news.INewsManager;
import wx.com.util.ConfigureClass;
import wx.com.util.StringUtil;

@Controller
@RequestMapping(value="protected")
public class NewsController {
	
	private INewsManager newsManager;
	
	@RequestMapping(value="wx_news",method = RequestMethod.GET)
	public ModelAndView  getWXNews(HttpServletRequest request){
		
		PlatForm platForm=(PlatForm) request.getSession().getAttribute("_platform_");
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
		article1.setUrl("/static/a1.jpg");
		
		Article article2 = new Article();
		article2.setTitle("图片2展示");
		article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
		article2.setPicUrl("/static/a2.jpg");
		article2.setUrl("/static/a2.jpg");
		
		
		msg_News.getArticles().add(article1);
		msg_News.getArticles().add(article2);
		msg_News.getId();
//		System.out.println(msg_News.getArticles().size());
		List<Msg_News_Out> newslist = new ArrayList<Msg_News_Out>();
		newslist.add(msg_News);
		newslist.add(msg_News);
//				newsManager.getMsgNewsAll(platForm.getOrigId());
	
//		newslist.get(0)
		return new ModelAndView("/protected/material/wx_news","newslist",newslist);
	}
	
	@RequestMapping(value="wx_news_edit",method = RequestMethod.GET)
	public ModelAndView  getWXNews_edit(HttpServletRequest request){
		
		Object newsId =request.getParameter("newsId");
		System.out.println(newsId);
		if(newsId!=null){
			newsId = (String)newsId ;
			
//			PlatForm platForm=(PlatForm) request.getSession().getAttribute("_platform_");
			Msg_News_Out msg_News = new Msg_News_Out();
//			msg_News.setToUserName(msg.getFromUserName());
//			msg_News.setFromUserName(msg.getToUserName());
			msg_News.setCreateTime(StringUtil.getTime());
//			msg_News.setMsgType("new");
			msg_News.setArticleCount(Integer.valueOf(2));
			Article article1 = new Article();
			article1.setId("11");
			article1.setTitle("图片1展示");
			article1.setDiscription("图片1展示图片1展示图片1展示图片1展示图片1展示");
			article1.setPicUrl("/static/a1.jpg");
			article1.setUrl("/static/a1.jpg");
			
			Article article2 = new Article();
			article2.setId("12");
			article2.setTitle("图片2展示");
			article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
			article2.setPicUrl("/static/a2.jpg");
			article2.setUrl("/static/a2.jpg");
//			article2.getId()
			
			msg_News.getArticles().add(article1);
			msg_News.getArticles().add(article2);
			
//			System.out.println(msg_News.getArticles().size());
			List<Msg_News_Out> newslist = new ArrayList<Msg_News_Out>();
			newslist.add(msg_News);
			
			return new ModelAndView("/protected/material/wx_news_edit","msg_News",msg_News);
		}else{
			
			return new ModelAndView("/protected/material/wx_news_edit");
		}
		
		
		
		
		
		
		//return "/protected/material/wx_news_add";
	}
	
	@RequestMapping(value="wx_news_add",method = RequestMethod.GET)
	public ModelAndView  getWXNews_add(HttpServletRequest request){
		
		Object newsId =request.getParameter("newsId");
	
		if(newsId!=null){
			newsId = (String)newsId ;
			
//			PlatForm platForm=(PlatForm) request.getSession().getAttribute("_platform_");
			Msg_News_Out msg_News = new Msg_News_Out();
//			msg_News.setToUserName(msg.getFromUserName());
//			msg_News.setFromUserName(msg.getToUserName());
			msg_News.setCreateTime(StringUtil.getTime());
//			msg_News.setMsgType("new");
			msg_News.setArticleCount(Integer.valueOf(2));
			Article article1 = new Article();
			article1.setId("11");
			article1.setTitle("图片1展示");
			article1.setDiscription("图片1展示图片1展示图片1展示图片1展示图片1展示");
			article1.setPicUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
			article1.setUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
			
			Article article2 = new Article();
			article2.setId("12");
			article2.setTitle("图片2展示");
			article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
			article2.setPicUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
			article2.setUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
//			article2.getId()
			
			msg_News.getArticles().add(article1);
			msg_News.getArticles().add(article2);
			
//			System.out.println(msg_News.getArticles().size());
			List<Msg_News_Out> newslist = new ArrayList<Msg_News_Out>();
			newslist.add(msg_News);
			
			return new ModelAndView("/protected/material/wx_news_add","msg_News",msg_News);
		}else{
			
			return new ModelAndView("/protected/material/wx_news_add");
		}
		
		
		
		
		
		
		//return "/protected/material/wx_news_add";
	}
	
	@RequestMapping(value="wx_news_edit",method = RequestMethod.POST)
	public ModelAndView  postWXNews_Edit(HttpServletRequest request){
		
		return new ModelAndView("/protected/material/wx_news");
	}
	
	@RequestMapping(value="wx_news_add",method = RequestMethod.POST)
	public ModelAndView  postWXNews_Add(HttpServletRequest request){
		
		System.out.println("ddd");
		return new ModelAndView("/protected/material/wx_news_add");
	}
	
	
	@RequestMapping(value="uploaderPic",method = RequestMethod.POST)
	public void  postUploader(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String savePath = request.getServletContext().getRealPath("");
        savePath = savePath + "/uploads/";
        File f1 = new File(savePath);
        System.out.println(savePath);
        if (!f1.exists()) {
            f1.mkdirs();
        }
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("utf-8");
        List fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            return;
        }
        Iterator<FileItem> it = fileList.iterator();
        String name = "";
        String extName = "";
        while (it.hasNext()) {
            FileItem item = it.next();
            if (!item.isFormField()) {
                name = item.getName();
                long size = item.getSize();
                String type = item.getContentType();
                System.out.println(size+"字节" + " " + type);
                if (name == null || name.trim().equals("")) {
                    continue;
                }
                   
                if (name.lastIndexOf(".") >= 0) {
                    extName = name.substring(name.lastIndexOf("."));
                }
                File file = null;
                do {
                    name = UUID.randomUUID().toString();
                    file = new File(savePath + name + extName);
                } while (file.exists());
                File saveFile = new File(savePath + name + extName);
                try {
                    item.write(saveFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name + extName);
        response.getWriter().print(name + extName);
		
	}

	public INewsManager getNewsManager() {
		return newsManager;
	}

	public void setNewsManager(INewsManager newsManager) {
		this.newsManager = newsManager;
	}
	
	
	

}
