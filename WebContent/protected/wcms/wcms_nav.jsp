

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<style>
	.btn-inverse {
		color: #ffffff;
		background-color: #34495e;
	}
	
	.btn-inverse:hover, .btn-inverse:focus{
		background-color: #34495e;
    	background-position: 0 -15px;
    	color: #FFFFFF;
	}
</style>


<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wcms_index" class="list-group-item ">滑动图片</a>
            <a href="${ctx}/protected/wcms_nav" class="list-group-item active">导航链接</a>
			<a href="${ctx}/protected/wcms_news" class="list-group-item">新闻动态</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  
  	<div class="panel panel-default">
 		<div class="panel-heading">
    		<h3 class="panel-title">
     			asd
   			</h3>
      
   		</div>
   		
   		<div class="panel-body">
    		<div class="container centercontroller">
      			<a class="btn btn-lg  btn-primary" href="${ctx}/showjsp/cuisine.jsp" >
		
				<span class="glyphicon glyphicon-cutlery"></span>
				<div>创意餐饮</div>
				</a>
		
				<a class="btn btn-lg btn-info">
				<span class="glyphicon glyphicon-picture"></span>
				<div>奇趣收藏</div>
				</a>
		
				<a class="btn btn-lg  btn-success">
				<span class="glyphicon glyphicon-eye-open"></span>
				<div>心灵派对</div>
				</a>
		
				<a class="btn btn-lg  btn-inverse">
				<span class="glyphicon glyphicon-user"></span>
				<div>关于我们</div>
				</a>
	  		</div>
	  		
	  		
	  		
  		</div>
   
    </div>
  
   
   
 </div>
  	
</div>



<script type="text/javascript">
	

$(".navbar-nav li").each(function(){

	$(this).removeClass("active");

});

$(document).ready(function(){

	$("#wxcmsmanager").addClass("active");

});
</script>
		

<%@ include file="/protected/footer.jsp"%>