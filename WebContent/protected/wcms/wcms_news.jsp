

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<style>
	.img-size{
		width:50px;
		height:50px
	}
</style>


<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wcms_index" class="list-group-item ">滑动图片</a>
            <a href="${ctx}/protected/wcms_nav" class="list-group-item">导航链接</a>
			<a href="${ctx}/protected/wcms_news" class="list-group-item active">新闻动态</a>
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
    		Panel content
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