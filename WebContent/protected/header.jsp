<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/protected/taglibs.jsp"%>
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
	
	<link href="../css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/navbar.css" rel="stylesheet">
    
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
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home">&nbsp;无线天利</span></a>
          </div>
          <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="${ctx}/protected/wx_index"><span class="glyphicon glyphicon-tasks">&nbsp;索引管理</span></a></li>
              <li><a href="${ctx}/protected/wx_user"><span class="glyphicon glyphicon-user">&nbsp;用户管理</span></a></li>
              <li><a href="#contact"><span class="glyphicon glyphicon-file">&nbsp;素材管理</span></a></li>
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
   

