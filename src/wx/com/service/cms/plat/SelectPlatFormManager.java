package wx.com.service.cms.plat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wx.com.common.util.JsonBuilder;
import wx.com.dao.plat.ISelectPlatFormDAO;
import wx.com.entity.cms.plat.PlatForm;

public class SelectPlatFormManager implements ISelectPlatFormManager{
	
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
			System.out.println(json);
			
			JSONObject jsonobj=JSONObject.fromObject(json);//将字符串转化成json对象 
			 // String name=jsonobj.getString("name");//获取字符串。
			  JSONArray array=jsonobj.getJSONArray("array");//获取数组
			  
			//遍历数组
			  for (int i = 0; i < array.size(); i++) {   
			   System.out.println("item "+ i + " :" + array.getString(i)); 
			   JSONObject jsonobj_tmp=JSONObject.fromObject(array.getString(i));
			   PlatForm platForm = new PlatForm();
			   platForm.setPlatID(jsonobj_tmp.getInt("platid"));
			   platForm.setOrigId(jsonobj_tmp.getString("origid"));
			   platForm.setPlatName(jsonobj_tmp.getString("platname"));
			   //System.out.println("item "+ i + " :" + jsonobj_tmp.getString("platname")); 
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
		
		PlatForm platForm1 = new PlatForm();
		platForm1.setPlatID(1);
		platForm1.setOrigId("gh_9cc49ccae03a1");
		platForm1.setPlatName("无线天利深圳分公司订阅号");
		platForm1.setValid(true);	
		platForm1.setCreateTime(new Timestamp(System.currentTimeMillis()));*/
		
		//selectPlatFormDAO.savePlatForm(platForm);
		try {
			selectPlatFormDAO.savePlatForm(platForm);
			//selectPlatFormDAO.savePlatForm(platForm2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editPlatForm(String origId, PlatForm platForm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delPlatForm(String origId) {
		// TODO Auto-generated method stub
		return false;
	}

}
