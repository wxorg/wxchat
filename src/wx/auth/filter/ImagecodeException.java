package wx.auth.filter;

import org.acegisecurity.AuthenticationException;

public class ImagecodeException extends AuthenticationException
{
  private static final long serialVersionUID = 5474418070231224277L;

  public ImagecodeException(String msg)
  {
    super(msg);
  }
}