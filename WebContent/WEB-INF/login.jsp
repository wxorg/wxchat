<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="wx.auth.filter.ProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException"%>
<%@ include file="/protected/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="static/favicon.png">
	<title>微信后台管理</title>

	<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    
    <script src="js/bootstrap.js" ></script>
    <script src="js/jquery.js" ></script>
    
    <script>
    	function clickImg(obj){

    	   obj.src="captcha?"+ new Date().getTime();
    	}	
    
    
    </script>
    
</head>
<body>




 <div class="container">
  	<c:if test="${not empty param.login_error}">
			<c:set var="error">
				<%=((AuthenticationException) session
							.getAttribute(ProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY))%>
			</c:set>
			<c:set var="msg">
				<%=((AuthenticationException) session
							.getAttribute(ProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY)).getMessage()%>
			</c:set>
  	</c:if>
  <form action="<c:url value='j_acegi_security_check'/>" method="POST" class="form-signin">
	<h2 class="form-signin-heading">Please sign in</h2>
	
		<input type="text" name='j_username' class="form-control" placeholder="username"  <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(ProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY) %>'</c:if>  required >
    <input type="password" name='j_password' class="form-control" placeholder="Password" required>

    <div style="margin-bottom:10px">
    	<input type="text" class="form-control" style = "max-width:180px;display:inline" placeholder="imagecode" name="j_imagecode" required/>
    	<img  style="display:inline" src="captcha?+<%=System.currentTimeMillis()%>" onclick="clickImg(this)" />
	</div>
	<div>

		<c:if test="${fn:indexOf(error,'ImagecodeException') > 0}">
			
						<span id="imageCodeError" style="color: red; font-size: 12"> <c:out value="${msg}" />
						</span>
			
	   </c:if>
	   
	   <c:if
					test="${fn:indexOf(error,'UsernameNotFoundException') > 0
	  							|| fn:indexOf(error,'CredentialsExpiredException') > 0
	  							|| fn:indexOf(error,'BadCredentialsException') > 0
	  				}">
					<span id="imageCodeError" style="color: red; font-size: 12"> <c:out value="用户名或密码错误" />
					</span>
				</c:if>
				<c:if
					test="${fn:indexOf(error,'LockedException') > 0
	  							|| fn:indexOf(error,'DisabledException') > 0
	  							|| fn:indexOf(error,'AccountExpiredException') > 0
	  				}">
					<span id="imageCodeError" style="color: red; font-size: 12"> <c:out value="${msg}" />
					</span>
				</c:if>				
	
	</div>
	
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        


</form>
</div>
</body>
</html>
