package wx.com.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="protected")
public class UserController {
	
	@RequestMapping(value="/wx_user",method = RequestMethod.GET)
	public String  getwxUser(){
	

		return "/protected/wxuser/wx_user";
	}
	
	@RequestMapping(value="/wx_user_group",method = RequestMethod.GET)
	public String  getwxUser_group(){
	

		return "/protected/wxuser/wx_user_group";
	}

}
