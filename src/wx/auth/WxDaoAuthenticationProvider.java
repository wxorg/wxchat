package wx.auth;

import org.acegisecurity.AccountExpiredException;
import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.CredentialsExpiredException;
import org.acegisecurity.DisabledException;
import org.acegisecurity.LockedException;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class WxDaoAuthenticationProvider extends DaoAuthenticationProvider{
	
	private final transient Logger log = Logger.getLogger(getClass());

	  public Authentication authenticate(Authentication authentication) throws AuthenticationException
	  {
	    Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication, this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.onlySupports", "Only UsernamePasswordAuthenticationToken is supported"));

	    String username = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();

	    boolean cacheWasUsed = true;
	    UserDetails user = getUserCache().getUserFromCache(username);

	    if (user == null) {
	      cacheWasUsed = false;
	      try
	      {
	        user = retrieveUser(username, (UsernamePasswordAuthenticationToken)authentication);
	      } catch (UsernameNotFoundException notFound) {
	        if (this.hideUserNotFoundExceptions) {
	          throw new UsernameNotFoundException("用户不存在");
	        }
	        throw notFound;
	      }

	      Assert.notNull(user, "retrieveUser returned null - a violation of the interface contract");
	    }

	    if (!user.isAccountNonLocked()) {
	    	
	      throw new LockedException("用户已被锁定,无法登录");
	      
	    }

	    if (!user.isEnabled()) {
	      throw new DisabledException("账号被注销,无法登录");
	    }

	    if (!user.isAccountNonExpired()) {
	      throw new AccountExpiredException("该帐号对应多个用户");
	    }
	
	    try
	    {
	      additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken)authentication);
	    } catch (AuthenticationException exception) {
	      if (cacheWasUsed)
	      {
	        cacheWasUsed = false;
	        user = retrieveUser(username, (UsernamePasswordAuthenticationToken)authentication);
	        additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken)authentication);
	      } else {
	        throw new BadCredentialsException("登录密码错误");
	      }
	    }

	    if (!user.isCredentialsNonExpired()) {
	      throw new CredentialsExpiredException("该帐号对应多个用户");
	    }

	    if (!cacheWasUsed) {
	      getUserCache().putUserInCache(user);
	    }

	    Object principalToReturn = user;

	    if (isForcePrincipalAsString()) {
	      principalToReturn = user.getUsername();
	    }

	    return createSuccessAuthentication(principalToReturn, authentication, user);
	  }

}
