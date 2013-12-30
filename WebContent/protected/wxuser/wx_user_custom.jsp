
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_user" class="list-group-item ">用户管理</a>
            <a href="${ctx}/protected/wx_user_group" class="list-group-item">分组管理</a>
			<a href="${ctx}/protected/wx_user_custom" class="list-group-item active">客服管理</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  	<div class="row">
  		<div class="col-md-3">
  			<div class="panel panel-default">
  				<div class="panel-heading">
    				<h3 class="panel-title">信息</h3>
  				</div>
  				<div class="panel-body">
   			 		<ul class="nav nav-pills nav-stacked">
  						<li class="active">
    						<a href="#">
      							<span class="badge pull-right">42</span>
      							Home
    						</a>
  						</li>	
  						<li class="">
    						<a href="#">
      							<span class="badge pull-right">42</span>
      							Home
    						</a>
  						</li>
					</ul>
  				</div>
			</div>
  
   			
	 	</div>
	 	<div class="col-md-9">
	 		<div class="panel panel-default">
  				<div class="panel-heading">
    				<h3 class="panel-title">Panel title</h3>
  				</div>
  				<div class="panel-body" style="min-height:100px" id="dialogcontent">
 					<div class="media">
  						<a class="pull-left" href="#">
    						<img class="media-object" src="..." alt="...">
  						</a>
  						<div class="media-body" style="float:left">
  							<div class="alert alert-info" > 您好</div>
  							
    						
  						</div>
					</div>
					<div class="media">
					
  						<a class="pull-right" href="#">
  						
    						<img class="media-object" src="..." alt="...">
  						</a>
  						<div class="media-body" style="float:right">
  							<div class="alert alert-danger">dsf</div>
    						
  						</div>
					</div>
					
 				 </div>
 				 <div class="panel-footer">
					<div class="input-group">
      					<input type="text" class="form-control">
     					 <span class="input-group-btn">
       						 <button class="btn btn-default" type="button">发送</button>
      					</span>
    				</div> 
				</div>
 				 
			</div>
	 	
	 	
	 		<div > 
   				<ul class=" pager " style="margin:5px 0px 5px 0px;text-align:center">
  					<li class=" disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span> </a></li>
  					<li class=" disabled" ><a href="#">1/3</a></li>
  					<li class=""><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>

				</ul>
	 		</div>
	 	</div>
	 </div>
   
   
   
   
</div>
  	
  	
  	
  	

</div>

<script src="${ctx}/js/user.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		

		$(".popover").popover('show');
	});
	
</script>


		

<%@ include file="/protected/footer.jsp"%>