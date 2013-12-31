<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="wx.auth.filter.ProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException"%>
<%@ include file="/WEB-INF/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${ctx}/static/favicon.png">
	<title>平台选择</title>
	
	<!-- Bootstrap core CSS -->
    <link href="${ctx}/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ctx}/css/signin.css" rel="stylesheet">
    <script src="${ctx}/js/jquery.js" ></script>
    <script src="${ctx}/js/bootstrap.js" ></script>

    
    <style type="text/css">
    	.container {
    		margin-top:30px
    	}
    	
    	.container div{
    		margin-top:10px
    	}
    	
    	.addPlatform{
    		
    		padding-top:20px
    	}
    	.addPlatform .form-group{
    		max-width:600px;
    		margin:0 auto 10px;
    	}
    
    
    </style>
</head>
<body>

	<div class="container">
		<c:if test="${not empty param.transit_error }">
			<div class="alert alert-danger">
  				<a href="" ><%=session.getAttribute("addplatform_error") %></a>
			</div>
		
		</c:if>
		
	
		<c:choose>
			<c:when test="${platFormList.size()==0}">
				<div>
					<a class="btn btn-default btn-lg btn-block" href="${ctx}/protected/wx_platFormAdd">没有公众平台，请先接入 </a>
				</div>
			</c:when>
			
			<c:when test="${platFormList.size()==1}">
				<div>
					<c:url value='${ctx}/protected/wx_index'/>
				</div>
			</c:when>
		
			<c:otherwise>
				<c:forEach items="${platFormList}" var = "rowlist">
					<div class="btn btn-default btn-lg btn-block">
						<a  href="${ctx}/protected/wx_index?origId=${rowlist.getOrigId()}">${rowlist.getPlatName() }</a>
					
							<a type="button" class="btn btn-link EditplatForm" onclick="EditplatForm('${rowlist.getWxCode()}','${rowlist.getWxCode()}','${rowlist.getOrigId()}','${rowlist.getServiceType()}')">
								<span class="glyphicon glyphicon-edit"></span></a>
							<a type="button"  class="btn btn-link" onclick="EditplatForm('${rowlist.getPlatName()}','${rowlist.getWxCode()}','${rowlist.getOrigId()}','${rowlist.getServiceType()}')">
								<span class="glyphicon glyphicon-trash"></span></a>
						
						
					</div>
		
				</c:forEach>
			</c:otherwise>
		</c:choose>


		<div >
			<a id="addplatformbtn" class="btn btn-default btn-lg btn-block " ><span class="glyphicon glyphicon-plus"></span></a>
		</div>
		
		<div class="panel-group hide" id="addPlatModal">
   					<div class="panel panel-default">
   						<div class="panel-heading">
   							<h4 class="panel-title">
   								<a data-toggle="collapse" data-toggle="collapse" data-parent="#addPlatModal" href="#collapseOne">
          							平台添加
        						</a>
      						</h4>
    					</div>
    					<div id="collapseOne" class="panel-collapse collapse in">
      						<div class="panel-body">
								<form role="form" class="addPlatform" action="${ctx }/protected/transitAdd"  method="POST">
  		 							
  		 							<div class="form-group" >
    									<label for="platname">名称</label>
  			    						<input type="text" class="form-control" id="platname" name="platname" placeholder="名称" required>

  									</div>
  									<div class="form-group">
    									<label for="wxName">微信号</label>
  			    						<input type="text" class="form-control" id="wxName" name="wxName" placeholder="微信号" required>

  									</div>
  									<div class="form-group" >
    									<label for="origId">原始ID</label>
  			    						<input type="text" class="form-control" id="origId" name="origId" placeholder="原始ID" required>

  									</div>
  									<div class="form-group" >
    									<label for="type">账号类型</label>
  			    						<select class="form-control" name="plattype">
  											<option value="0">服务号</option>
  											<option value="1">订阅号</option>
										</select>

  									</div>
  									<div class="form-group" style="text-align:center" >
  										<button type="button" class="btn btn-default" onclick="cancleBtn()">取消</button>
										<button type="submit" id="btnTextConfirm" class="btn btn-primary" >确定</button>
  									</div>
  				
  								</form>
							</div>
						</div>
				</div>
			</div>
		
			<div class="panel-group hide" id="editPlatModal">
   					<div class="panel panel-default">
   						<div class="panel-heading">
   							<h4 class="panel-title">
   								<a data-toggle="collapse" data-toggle="collapse" data-parent="#editPlatModal" href="#collapseOne">
          							平台修改
        						</a>
      						</h4>
    					</div>
    					<div id="collapseOne" class="panel-collapse collapse in">
      						<div class="panel-body">
      							<form role="form" class="addPlatform" action="${ctx }/protected/transitEdit"  method="POST">
  		 		
  		 							<div class="form-group" >
    									<label for="platname">名称</label>
  			    						<input type="text" class="form-control" id="editplatname" name="platname" placeholder="名称" required>

  										</div>
  										<div class="form-group">
    										<label for="wxName">微信号</label>
  			    							<input type="text" class="form-control" id="editwxName" name="wxName" placeholder="微信号" required>

  										</div>
  										<div class="form-group" >
    										<label for="origId">原始ID</label>
  			    							<input type="text" class="form-control" id="editorigId" name="origId" placeholder="原始ID" required>

  										</div>
  										<div class="form-group" >
    										<label for="type">账号类型</label>
  			    							<select class="form-control" name="editplattype">
  												<option value="0">服务号</option>
  												<option value="1">订阅号</option>
											</select>

  										</div>
  										<div class="form-group" style="text-align:center" >
  											<button type="button" class="btn btn-default" onclick="cancleBtn()">取消</button>
											<button type="submit" id="btnTextConfirm" class="btn btn-primary" >确定</button>
  										</div>
  				
  								</form>
  							</div>
       						 
       					</div>
    				</div>
  			</div>
		
			
	
	
	</div>
	
	
	<script type="text/javascript">
		
	function cancleBtn(){
		$("#addPlatModal").addClass("hide");
		$("#editPlatModal").addClass("hide");
	}
	
	$("#addplatformbtn").click(function(){
		if($("#addPlatModal").hasClass("hide")){
			//打开添加面板
			$("#addPlatModal").removeClass("hide");
			//关闭编辑面板
			$("#editPlatModal").addClass("hide");

			
		}else{
			//关闭添加面板
			$("#addPlatModal").addClass("hide");

			
		}
		
	});
	
	function addplatformBtn(){
		$("#addPlatModal").addClass("hide");
		$("#addplatformbtn").removeClass("show");
	}
	
	function EditplatForm(PlatName,WxName,OrigId,getType){
				
		//$("#editPlatModal").removeClass("hide");
		
		$("#editplatname").val(PlatName);
		$("#editwxName").val(WxName);
		$("#origId").val(OrigId);
		$("#editplattype").value=getType;
		
		
		if($("#editPlatModal").hasClass("hide")){
			
			$("#editPlatModal").removeClass("hide");
			
			$("#addPlatModal").addClass("hide");
			

		}else{
		
			$("#editPlatModal").addClass("hide");
			
			
		}

	}
	</script>
	

</body>
</html>