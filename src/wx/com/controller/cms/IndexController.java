package wx.com.controller.cms;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.cms.PlatForm;
import wx.com.entity.cms.index.Index;
import wx.com.service.cms.IIndexManager;
import wx.com.service.cms.SelectPlatFormManager;

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
	
		List<Index> indexList = new ArrayList<Index>();
		
		indexList.add(indexManager.getIndex("1","1"));
		indexList.add(indexManager.getIndex("2","2"));
		indexList.add(indexManager.getIndex("3","3"));
		System.out.println("add_get");
		return new ModelAndView("/protected/index/wx_index_add","indexList",indexList);
	}
	
	@RequestMapping(value="/wx_index_add",method = RequestMethod.POST)
	public ModelAndView  postwx_index_add(HttpServletRequest httpRequest){
	
		
		System.out.println("dd");
		 
		return new ModelAndView("/protected/index/wx_index_add");
	}
	
	
	
	public IIndexManager getIndexManager() {
		return indexManager;
	}

	public void setIndexManager(IIndexManager indexManager) {
		this.indexManager = indexManager;
	}
	
	
	

}
