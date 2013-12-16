package wx.com.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="protected")
public class TransitRedict {
	
	@RequestMapping(value="transit",method = RequestMethod.GET)
	public String  Transit(){
	
		
//		System.out.println("dsf");
		return "protected/transit";
	}
}
