
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>




<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_index" class="list-group-item ">普通索引</a>
            <a href="${ctx}/protected/wx_index_menu" class="list-group-item active">菜单管理</a>
			<a href="${ctx}/protected/wx_index_add" class="list-group-item">添加索引</a>
        </div>
        
	</div>
  </div>
  <div class="col-md-8">
 
   <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">
	  	菜单管理
	  	 <a  class="btn btn-link " style="float:right" onclick="addBasemenu()"><span class="glyphicon glyphicon-plus"> 添加主菜单</span></a>
  </div>
  <div class="panel-body">
  
  
  		<div class="panel-group" id="accordion">
  		
  		<c:forEach items="${wx_menu.getMainMenu()}" var = "rowmap" varStatus="status">
  <div class="panel panel-default">
    <div class="panel-heading">
    	<div class="form-inline">
                	<input  type="text" class="form-control" id="indexkeyword" placeholder="keyword" required>
                	<button type="submit" class="btn btn-default">Sign in</button>
                </div>
      <h4 class="panel-title">
        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion${status.index }" href="#collapse${status.index }" >
                ${rowmap.key }
               
                
        </a>
         
        <a  id="editmainmenu${status.index }" style="cursor: pointer" class="col-md-offset-1">
        	<span class=" glyphicon glyphicon-pencil"></span>
        </a>
      </h4>
    </div>
    <div id="collapse${status.index }"  class="panel-collapse collapse in">
      <div class="panel-body">
      	
      	<div class="childmenu">	
      		<ul class="list-group" id="list-group${status.index }">
      			<c:forEach items="${rowmap.value}" var = "innerlist">
      				<li class="list-group-item">
      					<span>${innerlist.getMenuName()}</span>
      					<span class="col-md-offset-1">${innerlist.getKeywordOrUrl()}</span>
      					<a href="" style="float:right"><span class=" glyphicon glyphicon-pencil"></span> </a>
      				</li>
      			</c:forEach>
  				
			</ul>
      		
      		<div >
			  <a  class="btn btn-link " onclick="addchilmenu('list-group${status.index }')"><span class="glyphicon glyphicon-plus"> 添加子菜单</span></a>
		    </div>
      	</div>
      	
        
      </div>
    </div>
  </div>
  </c:forEach>

</div>
  
  
  </div>
  
   
  </div>

   
   
   </div>
   
  	
  </div>
  
  <div class="modal"  >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">创建子菜单</h4>
			</div>
			<div class="modal-body">
				<div class="form-group" style="max-width:600px">
    				<label for="indextype">菜单类型</label>
  			    	<select class="form-control" id="indextype">
  						<option value="0">事件</option>
  						<option value="1">链接</option>
					</select>

  			    
  				</div>
  				
  				<div class="form-group" style="max-width:600px">
					<label for="titl">菜单名</label>
					<input type="text" class="form-control" id="menutitl" placeholder="菜单名" required>
 			 	</div>
 			 	
				<div class="form-group" style="max-width:600px">
					<label for="keyword">事件关键词/链接地址</label>
					<input type="text" class="form-control" id="keywordorurl" placeholder="事件关键词/链接地址" required>
 			 	</div>
       
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" id="btnTextConfirm" class="btn btn-primary">确定</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">添加回复</h4>
			</div>
			<div class="modal-body">
				
       
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" id="btnTextConfirm" class="btn btn-primary">确定</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

	<script type="text/javascript">
	
	
	
	
		function addBasemenu(){
			if($("#accordion").children().length<3){
				$("#accordion").append('<div class="panel panel-default">'+
						'<div class="panel-heading"><h4 class="panel-title">'+
						' <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion${wx_menu.getMainMenu().size()+1 }" '+
						'href="#collapse${wx_menu.getMainMenu().size()+1 }" >主菜单${wx_menu.getMainMenu().size()+1 }</a>'+
						'<a href="" class="col-md-offset-1"><span class=" glyphicon glyphicon-pencil"></span></a>'+
						'</h4></div><div id="collapse${wx_menu.getMainMenu().size()+1 }"  class="panel-collapse collapse in"><div class="panel-body">'+
						'<div class="childmenu"><ul class="list-group" id="list-group${wx_menu.getMainMenu().size()+1 }">'+
						'</ul><div ><a  class="btn btn-link " onclick="addchilmenu(\'list-group${wx_menu.getMainMenu().size()+1}\')">'+
						'<span class="glyphicon glyphicon-plus"> 添加子菜单</span></a> </div></div></div></div></div>');
				
			    
					      
			      	
			      		
			      		
				
			    
			      
			}
		}
	
	
		function addchilmenu(obj){
			
			if($('#'+obj).children().length<5){
				$('#'+obj).append('<li class="list-group-item">子菜单'+($('#'+obj).children().length+1)+'<a href="" style="float:right"><span class=" glyphicon glyphicon-pencil"></span> </a></li>');
				
			}else{
				alert("子菜单书不超过5个");
			}
			
			
		}	
	
		$('#myModal1').modal({
			  keyboard: false,
			  show:false
		});
		
		$("#editmainmenu0").click(function(){
			
			$('#myModal1').modal('toggle');
		});
	
		$(document).ready(function(){
		
			
				
			
		
		});
		
	</script>



		

<%@ include file="/protected/footer.jsp"%>