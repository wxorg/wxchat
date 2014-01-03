
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>



<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_index" class="list-group-item active">普通索引</a>
            <a href="${ctx}/protected/wx_index_menu" class="list-group-item">菜单管理</a>
			<a href="${ctx}/protected/wx_index_add" class="list-group-item">添加索引</a>
        </div>
        
	</div>
  </div>
  <div class="col-md-8">
 
   <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">
  	<form class="form-inline" action='${ctx}/protected/wx_index' method="GET" role="form" >
  		<div class="row">
  			<div class="col-md-6">
  				<div class="row">
  					<div class="col-md-6 form-group">
  	 					<label class="sr-only control-label" for="keyword">关键词：</label>
   			   			 <input type="text" class="form-control" id="keyword" name="keyword" placeholder="关键词">
  	 				</div>
  	 				<div class="col-md-6 form-group">
  	 					<label class="sr-only" for="indextype">索引类型</label>
    					<select class="form-control" name="indextype" id="indextype">
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
    					<select class="form-control" name="msgtype" id="msgtype">
  							<option value =-1>消息类型</option>
 							<option value =1>文本</option>							
  							<option value =2>图文</option>
						</select>
  	 				</div>
  	 				<div class="col-md-6 form-group" >
  	 					<button type="submit" class="btn btn-default">搜索</button>
   						
  	 				</div>
  	 		
  	 			</div>
  			</div>
  	 			
  		 </div>

    
   </form>
  
  </div>

   <div class="table-responsive panel panel-default">
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
		
			<c:forEach items="${indexmap.get('indexlist')}" var = "rowlist">
			<tr>
			   <!--  <td></td> -->
				<td>
				 	${rowlist.getKeyWord()}
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
 
   
   		<div class="">
   				<ul class=" pager " id="pagerchange">
  					<li class="" id="pagerpre">
  						<a href="">
  							<span class="glyphicon glyphicon-chevron-left">
  							</span> 
  						</a>
  					</li>
  					<li class="" id="pagernum"><a ><span id="currentpage">${indexmap.get("currpage")}</span>/<span id="totlepage">${indexmap.get("totlepage")}</span></a></li>
  					<li class=""  id="pagerafter"><a><span class="glyphicon glyphicon-chevron-right"></span></a></li>
				</ul>

   		</div>
 
   		
   		

   
   
   </div>

  	
  </div>


	<script type="text/javascript">
	
		
		
	
		function getIndex(pageindex){
		
		var content={
				keyword:$("#keyword").val(),
				indextype:$("#indextype").val(),
				msgtype:$("#msgtype").val(),
				page:pageindex
		};
			
		$.ajax({
			
			url:"${ctx}/protected/wx_index",
			type:"POST",
			timeout:10000,
			beforeSend :function (XMLHttpRequest, textStatus, errorThrown){
				
				 
	        },
	        context: document.body,
	        complete:function (XMLHttpRequest, textStatus){
	        	
	        },
	        
	        data: content,
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	        	
	        },
	        
	        success:function (data, textStatus) {

	        	$(this).html(data);
	        	
	        
	        }
	        
			});
		
		}
	
		$(".nav li").each(function(){
		
			$(this).removeClass("active");

		});
	
		$(document).ready(function(){
		
	
			$("#indexmanager").addClass("active");
			
			$("#pagerpre").click(function(){
				
				if($("#currentpage").text()==1){
					return;
				}else{
					var src="${ctx}/protected/wx_index?keyword="+$("#keyword").val()+"&indextype="+$("#indextype").val()+"&msgtype="+
							$("#msgtype").val()+"&currentpage="+(Number($("#currentpage").text())-1)+"&totlepage="+$("#totlepage").text();
			
					$(this).children("a").attr("href",src);
					//getIndex(Number($("#currentpage").text())-1);
				}
				
			});
			
			
			$("#pagerafter").click(function(){
				
				if($("#currentpage").text()==$("#totlepage").text()){
					return;
				}else{
					
					var src="${ctx}/protected/wx_index?keyword="+$("#keyword").val()+"&indextype="+$("#indextype").val()+"&msgtype="+
					$("#msgtype").val()+"&currentpage="+(Number($("#currentpage").text())+1)+"&totlepage="+$("#totlepage").text();
	
					$(this).children("a").attr("href",src);
				}
				
			});
			
		
		});
		
	</script>



		

<%@ include file="/protected/footer.jsp" %>