package wx.com.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="protected")
public class UserController {
	
	@RequestMapping(value="/wx_user",method = RequestMethod.GET)
	public String  checkSig(){
	
		System.out.println("user");
		return "/protected/wx_user";
	}

}
