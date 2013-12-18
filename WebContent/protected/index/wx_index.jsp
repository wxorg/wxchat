
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>


<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_index" class="list-group-item active">普通索引</a>
            <a href="#" class="list-group-item">接口索引</a>
			<a href="${ctx}/protected/wx_index_add" class="list-group-item">添加索引</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  	<div style="background-color: #E1E1E1;padding:10px 10px 0px 10px"> 
  	<form class="form-inline" action='${ctx}/protected/wx_index' method="POST" role="form" style="background-color: #c9c9c9;margin-bottom:0px">
  		<div class="row">
  			<div class="col-md-6">
  				<div class="row">
  					<div class="col-md-6 form-group">
  	 					<label class="sr-only control-label" for="keyword">关键词：</label>
   			   			 <input type="text" class="form-control" id="keyword" placeholder="关键词">
  	 				</div>
  	 				<div class="col-md-6 form-group">
  	 					<label class="sr-only" for="indextype">索引类型</label>
    					<select class="form-control">
  							<option value="-1">选择索引类型</option>
  							<option value="0">关注索引</option>
  							<option value="1">关键词索引</option>
  							<option value="2">搜索索引</option>
  							<option value="3">默认索引</option>
						</select>
  	 				</div>
  				</div>
  			</div>
  	 		<div class="col-md-6">
  				<div class="row">
  	 				<div class="col-md-6 form-group">
  	 					<label class="sr-only" for="msgtype">消息类型</label>
    					<select class="form-control">
  							<option value =-1>消息类型</option>
 							<option value =0>文本</option>
  							<option value =1>图片</option>
  							<option value =2>声音</option>
  							<option value =3>视频</option>
  							<option value =4>图文</option>
						</select>
  	 				</div>
  	 				<div class="col-md-6 form-group" >
  	 					<button type="submit" class="btn btn-default">搜索</button>
   						
  	 				</div>
  	 		
  	 			</div>
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
				<th>索引关键词</th>
				<th>索引类型</th>
				<th>消息类型</th>
				<th>发布日期</th>
				<th>操作</th>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach items="${indexList}" var = "rowlist">
			<tr>
				<td>
				 	${rowlist.getId() }
				</td>
				<td>
				 	${rowlist.getIndexType() }
				</td>
				<td>
				 	${rowlist.getMsgType() }
				</td>
				<td>
				 	${rowlist.getCreatTime() }
				</td>
				<td>
					<a href="${ctx}/wx_msg/edit?id=${row.ID}"><span class="">编辑</span></a>
					<a href="javascript:void(0);" onclick="msgo.delTxtMsg('${row.ID}', $(this).parent().prevAll(':eq(4)').text().trim(),'${row.MENUCOUNT}');"><span
								class="">删除</span> </a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
   
   
   </div>
   
  	
  </div>


	<script type="text/javascript">
	
		$(".nav li").each(function(){
		
			$(this).removeClass("active");

		});
	
		$(document).ready(function(){
		
			$("#indexmanager").addClass("active");
		
		});
		
	</script>



		

<%@ include file="/protected/footer.jsp"%>