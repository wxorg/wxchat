

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<style>
	.img-size{
		width:50px;
		height:50px
	}
</style>

<%
  		String nickName ="";
  		if(null!=request.getParameter("nickname"))
  		{
  			nickName=new String(request.getParameter("nickname").getBytes("iso8859-1"),"utf-8") ;
  		}
  				
  				
  		
  	%>
  	
<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_user" class="list-group-item active">用户管理</a>
            <a href="${ctx}/protected/wx_user_group" class="list-group-item">分组管理</a>
			<a href="${ctx}/protected/wx_user_custom" class="list-group-item">客服管理</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  
  	<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">
     
  	<form class="form-inline"  action='${ctx}/protected/wx_user' method="GET" role="form" >
  		<div class="row">
  			<div class="col-md-3">
 
  					<div class="form-group">
  	 					<label class="sr-only control-label" for="nickname">昵称</label>
   			   			 <input type="text" class="form-control" id="nickname" name="nickname" placeholder="昵称">
  	 				</div>

 
  			</div>
  	 		<div class="col-md-6">

  	 				<button type="submit" class="btn btn-default">搜索</button>

  	 		
  	 			
  			</div>
  	 			
  		 </div>

    
   </form>
   </h3>
      
   </div>
   
   <div class="table-responsive panel panel-default">
  		<table class="table table-striped  table-hover">
		<thead >
			<tr>
				<th width="80px"></th>
				<th></th>
				<th>分组</th>
				<th>关注时间</th>
			</tr>
		</thead>
	
		<tbody>
			
			<c:forEach items="${usermap.get('userlist')}" var = "rowlist">
			
			<tr>
				<td><img src="${ctx }${rowlist.getHeadimgurl()}" alt="..." class="img-rounded img-responsive img-size">
				</td>
				<td>
				${rowlist.getNickName()}
				</td>
				<td>
				${rowlist.getGroupId()}
				</td>
				<td>
				${rowlist.getSubscribe_time()}
				
				</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
  </div>
  </div>
  
	  
	  <div class="">
   				<ul class=" pager " id="pagerchange">
  					<li class="" id="pagerpre">
  						<a >
  							<span class="glyphicon glyphicon-chevron-left">
  							</span> 
  						</a>
  					</li>
  					<li class="" id="pagernum"><a ><span id="currentpage">${usermap.get("currpage")}</span>/<span id="totlepage">${usermap.get("totlepage")}</span></a></li>
  					<li class=""  id="pagerafter"><a><span class="glyphicon glyphicon-chevron-right"></span></a></li>
				</ul>

   		</div>
   
   
</div>
  	
  </div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	
	
	$("#nickname").val("<%= nickName%>");



	$("#pagerpre").click(function(){
		
		if($("#currentpage").text()==1){
			return;
		}else{
			var src="${ctx}/protected/wx_user?nickname="+$("#nickname").val()+"&currentpage="+(Number($("#currentpage").text())-1)+"&totlepage="+$("#totlepage").text();
	
			$(this).children("a").attr("href",src);
			//getIndex(Number($("#currentpage").text())-1);
		}
		
	});
	
	
	$("#pagerafter").click(function(){
		
		if($("#currentpage").text()==$("#totlepage").text()){
			return;
		}else{
			
			var src="${ctx}/protected/wx_user?nickname="+$("#nickname").val()+"&currentpage="+(Number($("#currentpage").text())+1)+"&totlepage="+$("#totlepage").text();

			$(this).children("a").attr("href",src);
		}
		
	});
	

});
</script>

<script src="${ctx}/js/user.js"></script>
		

<%@ include file="/protected/footer.jsp"%>