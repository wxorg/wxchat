package wx.com.controller.cms.wxuser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import wx.com.entity.CustomDialog;
import wx.com.entity.cms.plat.PlatForm;
import wx.com.entity.cms.wxuser.WxUser;
import wx.com.entity.cms.wxuser.WxUserGroup;
import wx.com.service.cms.wxuser.IWxUserCustomManager;
import wx.com.service.cms.wxuser.IWxUserManager;

@Controller
@RequestMapping(value="protected")
public class WXUserController {
	
	private PlatForm platform;
	private Logger logger = Logger.getLogger(getClass());
	
	@Resource
	private IWxUserCustomManager wxUserCustomManager;
	
	@Resource
	private IWxUserManager wxUserManager;
	
	@RequestMapping(value="/wx_user",method = RequestMethod.GET)
	public ModelAndView  getwxUser(HttpServletRequest request){
		
		platform = (PlatForm) request.getSession().getAttribute("_platform_");
		
		
		
		if(null==platform){
			return new ModelAndView("/protected/transit");
		}
		String nickName = request.getParameter("nickname");
		String currentpage = request.getParameter("currentpage");
		String totlepage = request.getParameter("totlepage");
		
		
		
		
		logger.info("微信用户名："+nickName);
		
		List<WxUser> userlist = new ArrayList<WxUser>();
		
		
		if(null!=wxUserManager&&null!=wxUserManager.getWxUserByNickName(nickName, platform.getPlatID())){
			
			if(null!=nickName){
				userlist.addAll(wxUserManager.getWxUserByNickName(nickName, platform.getPlatID()));
			}else{
				wxUserManager.getAllWxUser(platform.getPlatID());
			}
		}
		else{
				logger.error("wxCustomManager is null or getWxUserByNickName id null");
		}
			
		
		
		/*
		
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
		userlist.add(user);
		userlist.add(user);
		
		*/
		Map map = new HashMap();
		
		map.put("userlist", userlist);
		map.put("currpage", 1);
		map.put("totlepage", 2);

		return new ModelAndView("/protected/wxuser/wx_user","usermap",map);
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
	public ModelAndView  getwxUser_custom(){
		
		
		String[] str1 = {"客户1","acdadad1", "31"};
		String[] str2 = {"客户2","abdadad1", "321"};
		
	
		
		List<String[]> userlist = new ArrayList<String[]>();
		userlist.add(str1);
		userlist.add(str2);
		
	
		return new ModelAndView("/protected/wxuser/wx_user_custom","userdialoglist",userlist);
	}
	
	@RequestMapping(value="/wx_user_dialogDeail",method = RequestMethod.GET)
	public void  getwxUser_dialogDetail(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
		
		String openId = request.getParameter("openid");
		
		List<CustomDialog> customdialoglist = new ArrayList<CustomDialog>(); 
		if(null!=openId){
			if(null!=wxUserCustomManager&&null!=wxUserCustomManager.getDialogByOpenId(openId, platform.getPlatID()))
				customdialoglist.addAll(wxUserCustomManager.getDialogByOpenId(openId, platform.getPlatID()));
			else{
				logger.error("wxUserCustomManager is null or getDialogByOpenId id null");
			}
			
			if(null==customdialoglist||customdialoglist.size()==0){
				response.getWriter().write("false");
			}else{
				
				JSONArray jsa = new JSONArray();
				int size=customdialoglist.size();
				for(int i=0;i<size;i++){
					JSONObject job = new JSONObject();
					CustomDialog dialogtmp = customdialoglist.get(i);
					job.put("fromusername", dialogtmp.getFromUserName());
					job.put("tousername", dialogtmp.getToUserName());
					job.put("inorout", dialogtmp.getInOrout());
					job.put("content", dialogtmp.getContent());
					job.put("createtime", dialogtmp.getCreatetime());
					
					jsa.put(job);
				}
				
				response.getWriter().write(jsa.toString());
			}
			
		}else{
			response.getWriter().write("false");
		}
		response.getWriter().close();
		
		/*
		CustomDialog customlist = new CustomDialog();
		customlist.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customlist.setFromUserName("213213dafcd1");
		customlist.setToUserName("gh_9cc49ccae03a");
		customlist.setInOrout(1);
		
		CustomDialog customlist2 = new CustomDialog();
		customlist2.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customlist2.setFromUserName("gh_9cc49ccae03a");
		customlist2.setToUserName("213213dafcd1");
		customlist2.setInOrout(2);
		
		
		List<CustomDialog> usergrouplist = new ArrayList<CustomDialog>();
		usergrouplist.add(customlist);
		usergrouplist.add(customlist2);
		
		JSONArray jsa = new JSONArray();
		
		
		JSONObject job = new JSONObject();
		job.put("fromusername", "213213dafcd1");
		job.put("tousername", "gh_9cc49ccae03a");
		job.put("inorout", 1);
		job.put("content", "请问a股有推荐的吗请问a股有推荐的吗请问a股有推荐的吗请问a股有推荐的吗请问a股有推荐的吗？");
		job.put("createtime", new Timestamp(System.currentTimeMillis()).toString());
		JSONObject job1 = new JSONObject();
		job1.put("fromusername", "213213dafcd1");
		job1.put("tousername", "gh_9cc49ccae03a");
		job1.put("inorout", 2);
		job1.put("content", "你好，最近不宜入市");
		job1.put("createtime", new Timestamp(System.currentTimeMillis()).toString());
		
		jsa.put(job);
		jsa.put(job1);
		System.out.println(jsa.toString());
		
		*/
		
	}
	
	@RequestMapping(value="/wx_user_dialogDeail",method = RequestMethod.POST)
	public void  postwxUser_dialogSend(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
		
		String content = request.getParameter("content");
		String openId =request.getParameter("openId");
		
		if(null!=content||null!=openId){
			wxUserCustomManager.replyDalog(openId,platform.getPlatID(),  content);
			
			response.getWriter().write("true");
		}else{
			response.getWriter().write("false");
		}
		response.getWriter().close();

	}
	
	

	public PlatForm getPlatform() {
		return platform;
	}

	public void setPlatform(PlatForm platform) {
		this.platform = platform;
	}

	public IWxUserCustomManager getWxUserCustomManager() {
		return wxUserCustomManager;
	}

	public void setWxUserCustomManager(IWxUserCustomManager wxUserCustomManager) {
		this.wxUserCustomManager = wxUserCustomManager;
	}
	
	
	

}
