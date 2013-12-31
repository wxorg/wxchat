package wx.com.controller.cms.plat;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import wx.com.entity.cms.plat.PlatForm;
import wx.com.service.cms.plat.ISelectPlatFormManager;
import wx.com.service.cms.plat.SelectPlatFormManager;

@Controller
@RequestMapping(value="protected")
@SuppressWarnings("unused")
public class SelectPlatFormController {
	

	@Resource(name="selectPlatFormManager") 
    public ISelectPlatFormManager selectPlatFormManager; 
	
	public ISelectPlatFormManager getSelectPlatFormManager() {
		return selectPlatFormManager;
	}

	public void setSelectPlatFormManager(ISelectPlatFormManager selectPlatFormManager) {
		this.selectPlatFormManager = selectPlatFormManager;
	}
	
	@RequestMapping(value="transit",method = RequestMethod.GET)
	public ModelAndView  Transit(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	
		//SelectPlatFormManager selectPlatFormManager = new SelectPlatFormManager();
		
		List<PlatForm> platFormList = selectPlatFormManager.getPlatFormList();
//		platFormList.remove(0);
		//System.out.println("1 "+platFormList.get(0).getOrigId()+platFormList.size());
		
		HttpSession session = request.getSession();
		
//		System.out.println(request.getSession().getAttribute("_platform_"));
		
		//selectPlatFormManager.addPlatForm(null);
		
		if(platFormList.size()!=1)
			return new ModelAndView("protected/transit","platFormList",platFormList);
		else{
			
			return new ModelAndView("/protected/index/wx_index.jsp?origId="+platFormList.get(0).getOrigId());
			//protected/index/wx_index.jsp?origId=gh_9cc49ccae03a
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

		PlatForm platForm = new PlatForm();
		platForm.setCreateTime(new Timestamp(System.currentTimeMillis()));
		platForm.setPlatName(platname);
		platForm.setOrigId(origId);
		platForm.setServiceType(Short.parseShort(plattype));
		platForm.setWxCode(wxName);
		platForm.setValid(true);
		platForm.setPlatID(1);
		
		if(!selectPlatFormManager.addPlatForm(platForm)){
			request.getSession().setAttribute("addplatform_error", "platname is error");
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_error=1");
		}
	
		
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

		PlatForm platForm = new PlatForm();
		platForm.setCreateTime(new Timestamp(System.currentTimeMillis()));
		platForm.setPlatName(platname);
		platForm.setOrigId(origId);
		platForm.setServiceType(Short.parseShort(plattype));
		platForm.setWxCode(wxName);
		platForm.setValid(true);
		platForm.setPlatID(1);
		
		
		java.util.Enumeration enum1=request.getParameterNames();
		
		//Enumeration enu=request.getParameterNames(); 
        while(enum1.hasMoreElements()) 
        { 
            String name=(String)enum1.nextElement(); 
            System.out.println(name);
        }
        
		
        if(selectPlatFormManager.addPlatForm(platForm)){
        	request.getSession().setAttribute("addplatform_info", "platname is success");
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_success=1");
			
		}else{
			request.getSession().setAttribute("addplatform_info", "platname is error");
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_error=1");
		}
		
	}
	
	@RequestMapping(value="transitEdit",method = RequestMethod.POST)
	public void  TransitPostEdit(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	
		String platid;
		String platname;
		String wxName;
		String origId;
		String plattype;
		
		platid = request.getParameter("platid");
		platname = request.getParameter("platname");
		wxName = request.getParameter("wxName");
		origId = request.getParameter("origId");
		plattype = request.getParameter("plattype");
		
		PlatForm platForm = new PlatForm();
		platForm.setCreateTime(new Timestamp(System.currentTimeMillis()));
		platForm.setPlatName(platname);
		platForm.setOrigId(origId);
		platForm.setServiceType(Short.parseShort(plattype));
		platForm.setWxCode(wxName);
		platForm.setValid(true);
		platForm.setPlatID(Integer.valueOf(platid));
		
		System.out.println(plattype);
		
		
		if(selectPlatFormManager.editPlatForm(platid,platForm)){
			request.getSession().setAttribute("addplatform_info", "platname is success");
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_success=1");
		}else{
			
			request.getSession().setAttribute("addplatform_info", "platname is error");
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_error=1");
		}
		
		
	}
	
	
	@RequestMapping(value="transitDel",method = RequestMethod.GET)
	public void  TransitPostDel(HttpServletRequest request ,HttpServletResponse response) throws IOException{
	
		String platid;
		
		platid = request.getParameter("platid");
		
		
		
		
		if(selectPlatFormManager.delPlatForm(platid)){
			request.getSession().setAttribute("addplatform_info", "platname is success");
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_success=1");
		}else{
			
			request.getSession().setAttribute("addplatform_info", "platname is error");
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit?transit_error=1");
		}
		
		
	}
}
