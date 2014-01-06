package wx.com.controller.cms.wxuser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.cms.wxuser.WxUser;
import wx.com.entity.cms.wxuser.WxUserGroup;

@Controller
@RequestMapping(value="protected")
public class WXUserController {
	
	@RequestMapping(value="/wx_user",method = RequestMethod.GET)
	public ModelAndView  getwxUser(){
	
		
		WxUser user = new WxUser();
		user.setUserId(1);
		user.setNickName("呵呵哈");
		user.setCity("深圳");
		user.setCountry("china");
		user.setProvince("江西");
		user.setHeadimgurl("/static/a1.jpg");
		user.setLanguage("c_zn");
		user.setSex((byte)1);
		user.setSubscribe_time("2014 12-12");
		
		user.getSubscribe_time();
		List<WxUser> userlist = new ArrayList<WxUser>();
		userlist.add(user);
		
		
		
		Map map = new HashMap();
		
		map.put("userlist", userlist);
		

		return new ModelAndView("/protected/wxuser/wx_user","userlist",userlist);
	}
	
	@RequestMapping(value="/wx_user_group",method = RequestMethod.GET)
	public ModelAndView  getwxUser_group(){
	
		WxUserGroup userGroup = new WxUserGroup();
		userGroup.setGroupId(1);
		userGroup.setGroupName("组1");
		userGroup.setWxuserNum(21);
		
		List<WxUserGroup> usergrouplist = new ArrayList<WxUserGroup>();
		usergrouplist.add(userGroup);
		usergrouplist.add(userGroup);
		
		return new ModelAndView("/protected/wxuser/wx_user_group","usergrouplist",usergrouplist);
	}
	
	@RequestMapping(value="/wx_user_custom",method = RequestMethod.GET)
	public String  getwxUser_custom(){
	

		return "/protected/wxuser/wx_user_custom";
	}

}
