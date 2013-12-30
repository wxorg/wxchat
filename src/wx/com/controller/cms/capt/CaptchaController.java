package wx.com.controller.cms.capt;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.patchca.background.SingleColorBackgroundFactory;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.AbstractCaptchaService;
import org.patchca.text.renderer.BestFitTextRenderer;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CaptchaController {

	private Logger logger = Logger.getLogger(getClass());
	private static MyCaptchaService cs = null;
	
	@RequestMapping(value="captcha",method = RequestMethod.GET)
	public void  getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		cs = new MyCaptchaService();
		response.setContentType("image/png");
	    response.setHeader("cache", "no-cache");
	    HttpSession session = request.getSession(true);
	    OutputStream os = response.getOutputStream();
	    String patchca = EncoderHelper.getChallangeAndWriteImage(cs, "png", os);
	    session.setAttribute("rand_image_code", patchca);
//	    System.out.println(session.getAttribute("rand_image_code"));
	    os.flush();
	    os.close();
	    
	    
	}
	
	private class MyWordFactory extends RandomWordFactory
	{
	    public MyWordFactory()
	    {
	      this.characters = "1234567890";
	      this.minLength = 4;
	      this.maxLength = 4;
	    }
	  }
	
	class MyCaptchaService extends AbstractCaptchaService
	{
	    public MyCaptchaService()
	    {
	      this.wordFactory = new CaptchaController.MyWordFactory();

	      this.fontFactory = new RandomFontFactory(25, new String[] { "Verdana", "Tahoma" });

	      this.textRenderer = new BestFitTextRenderer();

	      this.backgroundFactory = new SingleColorBackgroundFactory();
	

	      this.colorFactory = new org.patchca.color.RandomColorFactory();
//	    		  new SingleColorFactory(new Color(125, 80, 70));
	      
	      this.filterFactory = new CurvesRippleFilterFactory(this.colorFactory);

	      this.width = 100;
	      this.height = 30;
	    }
	  }
}
