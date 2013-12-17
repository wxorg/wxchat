package wx.com.service.cms;

import java.util.ArrayList;
import java.util.List;

import wx.com.entity.cms.PlatForm;

public class SelectPlatFormManager implements ISelectPlatForm{

	@Override
	public List<PlatForm> getPlatFormList() {
		// TODO Auto-generated method stub
		
		PlatForm platForm = new PlatForm();
		platForm.setId("1");
		platForm.setPlatName("无线天利深圳分公司");
		
		List<PlatForm> list = new ArrayList<PlatForm>();
		list.add(platForm);
		return list;
	}

}
