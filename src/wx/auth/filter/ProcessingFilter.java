package wx.auth.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.encoding.PasswordEncoder;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
import org.acegisecurity.userdetails.User;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

public class ProcessingFilter extends AuthenticationProcessingFilter
{
	
  private Logger logger = Logger.getLogger(getClass());
  private static final String imagecodeField = "j_imagecode";
  public static String ACEGI_SECURITY_LAST_USERNAME = "ACEGI_SECURITY_LAST_USERNAME";
  public static String LOGIN_ERROR = "LOGIN_ERROR";
  
  
  
  
 

//  private AuthService authService;
  private PasswordEncoder passwordEncoder;

  public PasswordEncoder getPasswordEncoder()
  {
    return this.passwordEncoder;
  }

  public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

//  public AuthService getAuthService()
//  {
//    return this.authService;
//  }
//
//  public void setAuthService(AuthService authService) {
//    this.authService = authService;
//  }

  public Authentication attemptAuthentication(HttpServletRequest request) throws AuthenticationException
  {
    String username = obtainUsername(request);
    String password = obtainPassword(request);
    String imagecode = obtainImagecode(request);

    System.out.println(imagecode);
    if (StringUtils.isEmpty(username)) {
      username = "";
    }

    if (StringUtils.isEmpty(password)) {
      password = "";
    }

    request.getSession().setAttribute(ACEGI_SECURITY_LAST_USERNAME, username);
    
    if (StringUtils.isEmpty(imagecode)){
    	request.getSession().setAttribute(LOGIN_ERROR, "密码不能为空");
    	throw new ImagecodeException("验证码不能为空!");
    }
      
    if (!imagecode.equals(request.getSession().getAttribute("rand_image_code"))) {
    	request.getSession().setAttribute(LOGIN_ERROR, "验证码错误!");
        throw new ImagecodeException("验证码错误!");
    }

    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

    setDetails(request, authRequest);

    return getAuthenticationManager().authenticate(authRequest);
  }

  private String obtainImagecode(HttpServletRequest request) {
    return request.getParameter("j_imagecode");
  }
  
  
  	protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
		    throws IOException
	{
		    UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)authResult;
		    User user = (User) authentication.getPrincipal();
		    HttpSession session = request.getSession();
		    session.setAttribute("_login_user_", user.getUsername());
		    
	}

	  
	  
	  


}
