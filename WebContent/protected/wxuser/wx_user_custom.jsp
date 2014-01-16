
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<style>
	
	.alert{
	
		margin:0px;
		padding:2px 5px 2px 5px
	}
	#dialogbody{
		height:400px;
		overflow:auto
	}
	
</style>

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
   			 			<c:forEach items="${userdialoglist}" var = "rowlist">
   			 				<li class="" onclick="getDialogdetil(this,'${rowlist[1]}')">
   			 					<a class="hide" class="openidclass">
      								${rowlist[1]}
    							</a>
    							<a >
      							<span class="badge pull-right">${rowlist[2]}</span>
      								${rowlist[0]}
    							</a>
  							</li>	
   			 			</c:forEach>
  						
  						
					</ul>
  				</div>
			</div>
  
   			
	 	</div>
	 	<div class="col-md-9">
	 		<div class="panel panel-default">
  				<div class="panel-heading">
    				<h3 class="panel-title"><img class="media-object " src="..." alt="..."></h3>
  				</div>
  				<div class="panel-body" id="dialogbody" style="min-height:100px" id="dialogcontent">
 					<!-- <div class="media">
  						<a class="pull-left" href="#">
    						<img class="media-object" src="..." alt="..."/>
  						</a>
  						<div class="media-body" style="float:left">
  							<span>sdf</span>
  							<div class="alert alert-info" > 您好</div>
  							
    						
  						</div>
					</div>
					<div class="media">
					
  						<a class="pull-right" href="#">
  						
    						<img class="media-object" src="..." alt="...">
  						</a>
  						<div class="media-body" style="float:right">
  							<div class="alert alert-danger">请问有什么可以帮助你的	</div>
    						
  						</div>
					</div> -->
					
 				 </div>
 				 <div class="panel-footer">
					<div class="input-group">
      					<input type="text" class="form-control" id="sendcontent">
     					 <span class="input-group-btn">
       						 <button class="btn btn-default" id="btninput" type="button">发送</button>
      					</span>
    				</div> 
				</div>
 				 
			</div>
	 	
	 	
	 		<div > 
	 		<!-- 
   				<ul class=" pager " style="margin:5px 0px 5px 0px;text-align:center">
  					<li class=" disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span> </a></li>
  					<li class=" disabled" ><a href="#">1/3</a></li>
  					<li class=""><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>

				</ul>
				 -->
	 		</div>
	 	</div>
	 </div>
   
   
   
   
</div>
  	
  	
  	
  	

</div>

<script src="${ctx}/js/user.js"></script>
<script type="text/javascript">


	$("#btninput").click(function(){
		
		var openId;
		$(".nav-pills").children("li").each(function(){
			if($(this).hasClass("active")){
				openId = $(this).find(".openidclass").text().trim();
			}
			
		});
		
		var content = $("#sendcontent").val();
		

		var sendcontent={
				openId:openId,
				content:content
		};
		$.ajax({
			url:"${ctx}/protected/wx_user_dialogDeail",
			type:"POST",
			timeout:10000,
			beforeSend :function (XMLHttpRequest, textStatus, errorThrown){
	      
	        },
	        
	        complete:function (XMLHttpRequest, textStatus){
	        	
	        	
	        },
	        
	        data: sendcontent,
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	        
	        	alert("数据提交失败："+textStatus);
	        },
	        
	        success:function (data, textStatus) {

	        	if(textStatus=='success'&&data){
	        		
	        		
	        		$("#dialogbody").append('<div class="media"><a class="pull-right" >'+
							'</a>'+
							
	  						'<div class="media-body" style="float:right">&nbsp;<span>'+new Date().toLocaleDateString()+' '+new Date().toLocaleTimeString()+'</span>'+
	  						'<div class="alert alert-danger" >'+$("#sendcontent").val()+'</div>'+
							'</div></div>');
	        	}
	        	
	        	
	        	
	        	
	        
	        }
	        
		});
	});

	function getDialogdetil(obj,openid){
		
		$(".nav-pills").children("li").each(function(){
			$(this).removeClass("active");
		});
		$(obj).addClass("active");
		

		$.ajax({
			url:"${ctx}/protected/wx_user_dialogDeail",
			type:"GET",
			timeout:10000,
			beforeSend :function (XMLHttpRequest, textStatus, errorThrown){
	      
	        },
	        
	        complete:function (XMLHttpRequest, textStatus){
	        	
	        	
	        },
	        
	        data: {openid:openid},
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	        
	        	alert("数据提交失败："+textStatus);
	        },
	        
	        success:function (data, textStatus) {

	        	
	        	
	        	if(textStatus=='success'&&data){
	        		
	        		$("#dialogbody").empty();
	        		
	        		var obj = JSON.parse(data); 
	        		for(var i=0;i<obj.length;i++){
	        			//alert(obj[0].createtime);
	        			if(obj[i].inorout==1){
	        				$("#dialogbody").append('<div class="media"><a class="pull-left" ></a>'+
	    							
	    	  						'<div class="media-body" style="float:left"><span>'+obj[i].fromusername+'</span>&nbsp;<span>'+obj[i].createtime+'</span>'+
	    	  						'<div class="alert alert-info" > '+obj[i].content+'</div>'+
	    							'</div></div>');
	        				
	        			}else{
	        				$("#dialogbody").append('<div class="media"><a class="pull-right" >'+
	    							'</a>'+
	    							
	    	  						'<div class="media-body" style="float:right">&nbsp;<span>'+obj[i].createtime+'</span>'+
	    	  						'<div class="alert alert-danger" >'+obj[i].content+'</div>'+
	    							'</div></div>');
	        				
	        			}
	        			
	        		}
	        		
	        	}
	        	
	        	
	        
	        }
	        
		});
		
	}
	var time =1000*10;
	var timer = setInterval(function(){
	
		$(".nav-pills").children("li").each(function(){
			if($(this).hasClass("active")){
				getDialogdetil(this,$(this).find(".openidclass").text().trim());
			}
			
		});
		
        
    }, time);
	
	$(document).ready(function(){
		

	
	});
	
</script>

<script src="${ctx}/js/json.js"></script>
		

<%@ include file="/protected/footer.jsp"%>