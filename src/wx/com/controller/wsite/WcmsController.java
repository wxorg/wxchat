package wx.com.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="protected")
public class WcmsController {
	
	
	@RequestMapping(value="wcms_index",method = RequestMethod.GET)
	public ModelAndView  getwcms_Index(){
	

		return new ModelAndView("/protected/wcms/wcms_index");
	}
	
	@RequestMapping(value="wcms_nav",method = RequestMethod.GET)
	public ModelAndView  getwcms_New(){
	

		return new ModelAndView("/protected/wcms/wcms_nav");
	}
	
	@RequestMapping(value="wcms_news",method = RequestMethod.GET)
	public ModelAndView  getwcms_nav(){
	

		return new ModelAndView("/protected/wcms/wcms_news");
	}

}
