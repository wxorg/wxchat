

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
     
  	<form class="form-inline" role="form" >
  		<div class="row">
  			<div class="col-md-3">
 
  					<div class="form-group">
  	 					<label class="sr-only control-label" for="nickname">昵称</label>
   			   			 <input type="text" class="form-control" id="nickname" placeholder="昵称">
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
			<tr>
				<td><img src="${ctx }/static/a1.jpg" alt="..." class="img-rounded img-responsive img-size">
				</td>
				<td>alice
				</td>
				<td>
					<select >
  						<option value="-1">未分组</option>
  						<option value="0">组1</option>
  						<option value="1">组2</option>
					</select>
				</td>
				<td>1
				</td>
			</tr>
			<c:forEach items="${aa}" var = "rowlist">
			
			<tr>
				<td>1
				</td>
				<td>1
				</td>
				<td>1
				</td>
				<td>1
				</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
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


<script src="${ctx}/js/user.js"></script>
		

<%@ include file="/protected/footer.jsp"%>