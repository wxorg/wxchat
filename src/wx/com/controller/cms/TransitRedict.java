package wx.com.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.service.cms.SelectPlatFormManager;

@Controller
@RequestMapping(value="protected")
public class TransitRedict {
	
	@RequestMapping(value="transit",method = RequestMethod.GET)
	public ModelAndView  Transit(){
	
		SelectPlatFormManager selectPlatFormManager = new SelectPlatFormManager();
		
		
//		System.out.println("dsf");
		return new ModelAndView("protected/transit","platFormList",selectPlatFormManager.getPlatFormList());
	}
}
