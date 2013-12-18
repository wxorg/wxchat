

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
            <a href="${ctx}/protected/wx_user" class="list-group-item ">用户管理</a>
            <a href="${ctx}/protected/wx_user_group" class="list-group-item active">分组管理</a>

          </div>
	</div>
  </div>
  <div class="col-md-8">
  	
   
   <div class="table-responsive">
  		<table class="table table-striped  table-hover">
		<thead>
			<tr>
				<th>分组</th>
				<th>数量</th>
				<th>操作</th>
			</tr>
		</thead>
	
		<tbody>
			<tr>
				<td>星标组
				</td>
				<td>31
				</td>
				<td>
					<a href="#"><span class="glyphicon glyphicon-trash"></span></a>
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
   
  	
  </div>
</div>



		

<%@ include file="/protected/footer.jsp"%>