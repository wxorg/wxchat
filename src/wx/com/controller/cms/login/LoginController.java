package wx.com.controller.cms.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
private Logger logger = Logger.getLogger(getClass());
	

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String  checkSig(){
	
//		System.out.println("dsf");
		return "WEB-INF/login";
	}

}
