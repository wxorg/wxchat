package wx.com.controller.cms;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.cms.PlatForm;
import wx.com.service.cms.SelectPlatFormManager;

@Controller
@RequestMapping(value="protected")
public class TransitController {
	
	@RequestMapping(value="transit",method = RequestMethod.GET)
	public ModelAndView  Transit(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	
		SelectPlatFormManager selectPlatFormManager = new SelectPlatFormManager();
		
		List<PlatForm> platFormList = selectPlatFormManager.getPlatFormList();
//		platFormList.remove(0);
		System.out.println("1 "+platFormList.get(0).getOrigId()+platFormList.size());
		HttpSession session = request.getSession();
		
//		System.out.println(request.getSession().getAttribute("_platform_"));
		
		if(platFormList.size()!=1)
			return new ModelAndView("protected/transit","platFormList",platFormList);
		else{
			
			return new ModelAndView("/protected/index/wx_index.jsp?origId="+platFormList.get(0).getOrigId());
		}
			
	}
	
	@RequestMapping(value="transit",method = RequestMethod.POST)
	public void  TransitPost(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	
		String platname;
		String wxName;
		String origId;
		String plattype;
		
		
		platname = request.getParameter("platname");
		wxName = request.getParameter("wxName");
		origId = request.getParameter("origId");
		plattype = request.getParameter("plattype");
		
		
		request.getSession().setAttribute("addplatform_error", "platname is error");
		
		
		response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_error=1");
		
	}
	
	@RequestMapping(value="transitAdd",method = RequestMethod.POST)
	public void  TransitPostAdd(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	
		String platname;
		String wxName;
		String origId;
		String plattype;
		
		
		platname = request.getParameter("platname");
		wxName = request.getParameter("wxName");
		origId = request.getParameter("origId");
		plattype = request.getParameter("plattype");
		
		
		request.getSession().setAttribute("addplatform_error", "platname is error");
		System.out.println("TransitPostAdd");
		
		response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_error=1");
		
	}
	
	@RequestMapping(value="transitEdit",method = RequestMethod.POST)
	public void  TransitPostEdit(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	
		String platname;
		String wxName;
		String origId;
		String plattype;
		
		
		platname = request.getParameter("platname");
		wxName = request.getParameter("wxName");
		origId = request.getParameter("origId");
		plattype = request.getParameter("plattype");
		
		System.out.println("TransitPostEdit");
		request.getSession().setAttribute("addplatform_error", "platname is error");
		
		
		response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_error=1");
		
	}
}
