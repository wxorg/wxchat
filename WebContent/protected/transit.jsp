<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="wx.auth.filter.ProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException"%>
<%@ include file="/protected/taglibs.jsp"%>
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
    		border:solid 1px #D4D4D4;
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
					<div>
						<a class="btn btn-default btn-lg btn-block" href="${ctx}/protected/wx_index?origId=${rowlist.getOrigId()}">
						
						${rowlist.getPlatName() }</a>
					</div>
		
				</c:forEach>
			</c:otherwise>
		</c:choose>


		<div >
			<a id="addplatformbtn" class="btn btn-default btn-lg btn-block " ><span class="glyphicon glyphicon-plus"></span></a>
		</div>
		
		<div id="addPlatModal" class="hide">
			<form role="form" class="addPlatform" >
  		 	
  		 		<div class="form-group" >
    				<label for="platname">名称</label>
  			    	<input type="text" class="form-control" id="platname" placeholder="名称" required>

  				</div>
  				<div class="form-group">
    				<label for="wxName">微信号</label>
  			    	<input type="text" class="form-control" id="wxName" placeholder="微信号" required>

  				</div>
  				<div class="form-group" >
    				<label for="origId">原始ID</label>
  			    	<input type="text" class="form-control" id="origId" placeholder="原始ID" required>

  				</div>
  				<div class="form-group" >
    				<label for="type">账号类型</label>
  			    	<select class="form-control">
  					<option value="0">服务号</option>
  					<option value="1">订阅号</option>
				</select>

  				</div>
  				<div class="form-group" style="text-align:center" >
  					<button type="button" class="btn btn-default" onclick="cancleBtn()">取消</button>
					<button type="button" id="btnTextConfirm" class="btn btn-primary" onclick="cancleBtn()">确定</button>
  				</div>
  				
  			</form>
		</div>

	
	</div>
	
	
	<script type="text/javascript">
		
	function cancleBtn(){
		$("#addPlatModal").addClass("hide");
		$("#addplatformbtn").removeClass("show");
	}
	
	$("#addplatformbtn").click(function(){
		if(!$("#addplatformbtn").hasClass("show")){
			$("#addPlatModal").removeClass("hide");
			$("#addplatformbtn").addClass("show");
		}else{
			$("#addPlatModal").addClass("hide");
			$("#addplatformbtn").removeClass("show");
		}
		
	});
	
	</script>
	

</body>
</html>