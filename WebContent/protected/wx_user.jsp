
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>


<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="#" class="list-group-item active">用户管理</a>
            <a href="#" class="list-group-item">分组管理</a>

          </div>
	</div>
  </div>
  <div class="col-md-8">
  	<div style="background-color: #E1E1E1;padding:10px 10px 0px 10px"> 
  	<form class="form-inline" role="form" style="background-color: #c9c9c9;margin-bottom:0px">
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
      <div > 
   		<ul class=" pager col-md-offset-2" style="margin:5px 0px 5px 0px;text-align:right">
  			<li class=" disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span> </a></li>
  			<li class=" disabled" ><a href="#">1/3</a></li>
  			<li class=""><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>

		</ul>
	  </div>
   </div>
   <div class="table-responsive">
  		<table class="table table-striped  table-hover">
		<thead>
			<tr>
				<th></th>
				<th></th>
				<th>分组</th>
				<th>修改备注</th>
			</tr>
		</thead>
	
		<tbody>
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
		</tbody>
	</table>
  </div>
   
   
   </div>
   
  	
  </div>
</div>



		

<%@ include file="/protected/footer.jsp"%>