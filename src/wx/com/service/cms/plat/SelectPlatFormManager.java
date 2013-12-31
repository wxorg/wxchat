package wx.com.service.cms.plat;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;


import org.springframework.stereotype.Service;

import wx.com.common.util.JsonBuilder;
import wx.com.dao.plat.ISelectPlatFormDAO;
import wx.com.entity.cms.plat.PlatForm;
import wx.com.service.base.IBaseManager;

@Service
public class SelectPlatFormManager extends IBaseManager implements ISelectPlatFormManager{
	
	@Resource
	private ISelectPlatFormDAO selectPlatFormDAO;
	

	public ISelectPlatFormDAO getSelectPlatFormDAO() {
		return selectPlatFormDAO;
	}

	public void setSelectPlatFormDAO(ISelectPlatFormDAO selectPlatFormDAO) {
		this.selectPlatFormDAO = selectPlatFormDAO;
	}

	@Override
	public List<PlatForm> getPlatFormList() {
		// TODO Auto-generated method stub
		List<PlatForm> list = new ArrayList<PlatForm>();
		try {
			String json=JsonBuilder.getJsonFromList(selectPlatFormDAO.getAllPlatFormList());
			//System.out.println(json);
			
			JSONObject jsonobj=new JSONObject(json);//将字符串转化成json对象 
			 // String name=jsonobj.getString("name");//获取字符串。
			  JSONArray array=jsonobj.getJSONArray("array");//获取数组
			  
			//遍历数组
			  for (int i = 0; i < array.length(); i++) {   
			  // System.out.println("item "+ i + " :" + array.getString(i)); 
			   JSONObject jsonobj_tmp=array.getJSONObject(i);
			   PlatForm platForm = new PlatForm();
			   platForm.setPlatID(jsonobj_tmp.getInt("platid"));
			   platForm.setOrigId(jsonobj_tmp.getString("origid"));
			   platForm.setWxCode(jsonobj_tmp.getString("wxcode"));
			   platForm.setPlatName(jsonobj_tmp.getString("platname"));
			   platForm.setServiceType((short)jsonobj_tmp.getInt("servicetype"));
			  // System.out.println("item "+ i + " :" + jsonobj_tmp.getString("platname")); 
			   list.add(platForm); 
			  }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PlatForm getPlatFormById(String str0) {
		// TODO Auto-generated method stub
		PlatForm platForm = new PlatForm();
		platForm.setPlatID(1);
		platForm.setOrigId("gh_9cc49ccae03a");
		platForm.setPlatName("无线天利深圳分公司");
		return platForm;
	}

	@Override
	public boolean addPlatForm(PlatForm platForm) {
		// TODO Auto-generated method stub
	/*	PlatForm platForm2 = new PlatForm();
		platForm2.setPlatID(1);
		platForm2.setOrigId("gh_9cc49ccae03a");
		platForm2.setPlatName("无线天利深圳分公司");
		platForm2.setValid(true);	
		platForm2.setCreateTime(new Timestamp(System.currentTimeMillis()));
		platForm2.setServiceType((short)0);
		
		PlatForm platForm1 = new PlatForm();
		platForm1.setPlatID(1);
		platForm1.setOrigId("gh_9cc49ccae03a1");
		platForm1.setPlatName("无线天利深圳分公司订阅号");
		platForm1.setValid(true);	
		platForm1.setCreateTime(new Timestamp(System.currentTimeMillis()));
		platForm1.setServiceType((short)0);*/
		
		
		try {
			selectPlatFormDAO.savePlatForm(platForm);
			//selectPlatFormDAO.savePlatForm(platForm);
//			selectPlatFormDAO.savePlatForm(platForm2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean editPlatForm(int platId, PlatForm platForm) {
		// TODO Auto-generated method stub
		try{
			selectPlatFormDAO.updatePlatForm(platForm);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delPlatForm(String origId, PlatForm platForm) {
		// TODO Auto-generated method stub
		try{
			selectPlatFormDAO.updatePlatForm(platForm);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean searchPlatForm(String platname,String wxCode,String origId,int platId){
		try{
			return selectPlatFormDAO.searchIsExistPlatForm(platname, wxCode, origId,platId);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public PlatForm getPlatFormById(int platid) throws Exception {
		return (PlatForm)selectPlatFormDAO.getPlatFormById(platid);
	}

}
