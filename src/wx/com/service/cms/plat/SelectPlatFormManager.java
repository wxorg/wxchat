package wx.com.service.cms.plat;

import java.util.ArrayList;
import java.util.List;

import wx.com.entity.cms.PlatForm;

public class SelectPlatFormManager implements ISelectPlatFormManager{

	@Override
	public List<PlatForm> getPlatFormList() {
		// TODO Auto-generated method stub
		
		PlatForm platForm = new PlatForm();
		platForm.setId("1");
		platForm.setOrigId("gh_9cc49ccae03a");
		platForm.setPlatName("无线天利深圳分公司");
		
		PlatForm platForm1 = new PlatForm();
		platForm1.setId("1");
		platForm1.setOrigId("gh_9cc49ccae03a1");
		platForm1.setPlatName("无线天利深圳分公司订阅号");

		List<PlatForm> list = new ArrayList<PlatForm>();
		list.add(platForm);
		list.add(platForm1);
		return list;
	}

	@Override
	public PlatForm getPlatFormById(String str0) {
		// TODO Auto-generated method stub
		PlatForm platForm = new PlatForm();
		platForm.setId("1");
		platForm.setOrigId("gh_9cc49ccae03a");
		platForm.setPlatName("无线天利深圳分公司");
		return platForm;
	}

	@Override
	public boolean addPlatForm(PlatForm platForm) {
		// TODO Auto-generated method stub
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
