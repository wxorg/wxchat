<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglibs.jsp"%>
<%@ page import="wx.com.entity.cms.PlatForm"%>
<%@ page import="wx.com.service.cms.SelectPlatFormManager" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../static/favicon.png">
	<title>微信管理平台</title>
	<link href="${ctx}/css/uploadify.css" rel="stylesheet">
	<link href="${ctx}/css/bootstrap.css" rel="stylesheet">
	<link href="${ctx}/css/bootstrap-theme.min.css" rel="stylesheet">	
    <!-- Custom styles for this template -->
    <link href="${ctx}/css/navbar.css" rel="stylesheet">
    
    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>  
 
   
    <script type="text/javascript">
	
	
    	function changeNavCss(){
    		
    		$(".navbar-nav li").each(function(){
    			
    			alert("click");
    			if($(this).hasClass("active")){
    				return;
    			}else{
    				$(".nav li").each(function(){
    				    $(this).removeClass("active");
    				  });
    				$(this).addClass("active");

    			}
    		});
    	}
		
	</script>
	
	<style type="text/css">
		table thead{
			
			
		}
		table{
			margin-top:10px;
		}
	</style>
    
</head>
<body >
	<div id="wrap">

      <!-- Fixed navbar -->
      <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <%
            PlatForm  platForm=null;
    		boolean isnotnull=false;
            if(request.getSession().getAttribute("_platform_")!=null){
            	//platForm = (PlatForm)request.getSession().getAttribute("_platform_");	
            	platForm=(PlatForm)request.getSession().getAttribute("_platform_");
            	isnotnull = true;
            }else{
            	
            	response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/protected/transit");
            }
 
            
            %>
            
            <c:if test="<%=isnotnull %>">
         
            <a class="navbar-brand" 
            	
            	href="${ctx }/protected/transit?id=<%=((PlatForm)platForm).getOrigId()%>" >
            	<span >
            		<%=((PlatForm)platForm).getPlatName() %>
            			
            	</span>
            
            </a>
            
            </c:if>
          
          </div>
          <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
              <li id="indexmanager" class="active"><a href="${ctx}/protected/wx_index"><span class="glyphicon glyphicon-tasks">&nbsp;索引管理</span></a></li>
              <li id="usermanager"><a href="${ctx}/protected/wx_user"><span class="glyphicon glyphicon-user">&nbsp;用户管理</span></a></li>
              <li id="materialmanager"><a href="${ctx}/protected/wx_news"><span class="glyphicon glyphicon-file">&nbsp;素材管理</span></a></li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
              <li><a href="">
              	<%=request.getSession().getAttribute("_login_user_")%>
              </a></li>
              <li><a href="javascript:top.location.href='${ctx}/j_acegi_logout';void(0);">退出</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>

      <!-- Begin page content -->
      <div class="container">
        
       




    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   

