<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglibs.jsp"%>
<%@ page import="wx.com.entity.cms.PlatForm"%>
<%@ page import="wx.com.service.cms.SelectPlatFormManager" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>Flat UI Free</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${ctx}/css/uploadify.css" rel="stylesheet">
	<link href="${ctx}/css/bootstrap.css" rel="stylesheet">
	<link href="${ctx}/css/bootstrap-theme.min.css" rel="stylesheet">	
    <!-- Custom styles for this template -->
    <link href="${ctx}/css/navbar.css" rel="stylesheet">
    <link href="${ctx}/css/flat-ui.css" rel="stylesheet">
    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>  
	<style type="text/css">
		.centercontroller{
			padding:5px;
			margin:5px
		}    
		
		.centercontroller .btn {
			margin:5px
		}

    </style>
</head>
<body>
	<div class="container" style="text-align:center">
    	<span >深圳市和禾文化管理有限公司</span>
		<div id="carousel-example-captions" class="carousel slide"  data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-captions" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-captions" data-slide-to="1"></li>
          <li data-target="#carousel-example-captions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="item active">
            <img src="${ctx}/img/1.png" alt="First slide image" style="max-height:200px">
            <div class="carousel-caption">
              
              <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
            </div>
          </div>
          <div class="item">
            <img src="${ctx}/img/2.jpg" alt="Second slide image" style="max-height:200px">
            <div class="carousel-caption">
              <h3>Second slide label</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </div>
          </div>
          <div class="item">
            <img src="${ctx}/img/3.jpg" alt="Third slide image" style="max-height:200px">
            <div class="carousel-caption">
              <h3>Third slide label</h3>
              <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
            </div>
          </div>
        </div>
         <a class="left carousel-control" href="#carousel-example-captions" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-captions" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
	  
	  <div class="container centercontroller">
      <a class="btn btn-hg btn-primary" href="${ctx}/showjsp/cuisine.jsp" >
		
		<span class="glyphicon glyphicon-cutlery"></span>
		<div>创意餐饮</div>
		</a>
		
		<a class="btn btn-hg btn-info">
		<span class="glyphicon glyphicon-picture"></span>
		<div>奇趣收藏</div>
		</a>
		
		<a class="btn btn-hg btn-success">
		<span class="glyphicon glyphicon-eye-open"></span>
		<div>心灵派对</div>
		</a>
		
		<a class="btn btn-hg btn-inverse">
		<span class="glyphicon glyphicon-user"></span>
		<div>关于我们</div>
		</a>
	  </div>
	  
	  <div class="panel panel-primary">
 		 <div class="panel-heading">
    		<h3 class="panel-title">中心动态</h3>
  		</div>
  		
  		<ul class="list-group media-list">
    		<li class="list-group-item media">
    				<a class="pull-left" href="#">
     					<img class="media-object" src="${ctx}/img/exaple-image.jpg" alt="..." width="50">
    				</a>
    				<div class="media-body">
    					
     					<h7 class="media-heading">《精灵的乐宴》推出</h7>
     						
    				</div>
    				<a  href=""><span style="font-size:14px">精灵的乐宴是以小朋友最喜欢的精灵为主题，结合...</span></a>
			</li>
    		<li class="list-group-item media">
    				<a class="pull-left" href="#">
     					<img class="media-object" src="${ctx}/img/exaple-image.jpg" alt="..." width="50">
    				</a>
    				<div class="media-body">
    					
     					<h7 class="media-heading">《精灵的乐宴》推出</h7>
     						
    				</div>
    				<a  href=""><span style="font-size:14px">精灵的乐宴是以小朋友最喜欢的精灵为主题，结合...</span></a>
			</li>
			<li class="list-group-item media">
    				<a class="pull-left" href="#">
     					<img class="media-object" src="${ctx}/img/exaple-image.jpg" alt="..." width="50">
    				</a>
    				<div class="media-body">
    					
     					<h7 class="media-heading">《精灵的乐宴》推出</h7>
     						
    				</div>
    				<a  href=""><span style="font-size:14px">精灵的乐宴是以小朋友最喜欢的精灵为主题，结合...</span></a>
			</li>
			<li class="list-group-item media">
    				<a class="pull-left" href="#">
     					<img class="media-object" src="${ctx}/img/exaple-image.jpg" alt="..." width="50">
    				</a>
    				<div class="media-body">
    					
     					<h7 class="media-heading">《精灵的乐宴》推出</h7>
     						
    				</div>
    				<a  href=""><span style="font-size:14px">精灵的乐宴是以小朋友最喜欢的精灵为主题，结合...</span></a>
			</li>
			<li class="list-group-item media">
    				<a class="pull-left" href="#">
     					<img class="media-object" src="${ctx}/img/exaple-image.jpg" alt="..." width="50">
    				</a>
    				<div class="media-body">
    					
     					<h7 class="media-heading">《精灵的乐宴》推出</h7>
     						
    				</div>
    				<a  href=""><span style="font-size:14px">精灵的乐宴是以小朋友最喜欢的精灵为主题，结合...</span></a>
			</li>
			<li class="list-group-item media">
  			<button type="button" class="btn btn-lg btn-primary">进入消息中心<span class="glyphicon glyphicon-chevron-right"></span></button>
		</li>
  		</ul>
  		
	</div>

    </div>
    
    
    

</body>
</html>