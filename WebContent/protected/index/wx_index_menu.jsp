
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
    	<div class="form-inline hide">
                	<input  type="text"  class="indexkeyword" placeholder="keyword" required>
                	<button type="submit" class="btn btn-default btnchangemainmenu">确定</button>
        </div>
        <h4 class="panel-title">
         <a  class="mainmenuname" data-toggle="collapse" data-toggle="collapse" data-parent="#accordion${status.index }" href="#collapse${status.index }" >
                ${rowmap.key }           
         </a>
         
         <a  class="editmainmenu" style="cursor: pointer" class="col-md-offset-">
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
      					<span class="childmenuname">${innerlist.getMenuName()}</span>
      					<span class="col-md-offset-1 keywordorurl">${innerlist.getKeywordOrUrl()}</span>
      					<a  class="editchildmenu" style="float:right;cursor: pointer"><span class=" glyphicon glyphicon-pencil"></span> </a>
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
  


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">子菜单修改</h4>
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
	
		$('#myModal1').modal({
		  keyboard: false,
		  show:false
		});
	
		function clickInit(){

			
			$(".editmainmenu").click(function(){
				
				$(this).parent('.panel-title').addClass('hide');
				//alert($(this).parents('.panel-title').children(".mainmenuname").text());
				$(this).parents('.panel-heading').find('.indexkeyword').val($(this).parents('.panel-title').children(".mainmenuname").text().trim());
				
				$(this).parents('.panel-heading').children('.form-inline').removeClass('hide');
				//$('#myModal1').modal('toggle');
			});
			
			
			$(".btnchangemainmenu").click(function(){
				//alert($(this).parents('.panel-heading').find(".mainmenuname").text());
				$(this).parents('.panel-heading').find('.panel-title').children(".mainmenuname").text($(this).parents('.panel-heading').find('.indexkeyword').val());
				$(this).parents('.panel-heading').children('.form-inline').addClass('hide');
				$(this).parents('.panel-heading').children('.panel-title').removeClass('hide');
			});
			
			
		}
	

	
	
		function addchilmenu(obj){
			
			if($('#'+obj).children().length<5){
				$('#'+obj).append('<li class="list-group-item"><span class="childmenuname">子菜单'+($('#'+obj).children().length+1)+'</span><span class="col-md-offset-1 keywordorurl"></span><a class="editchildmenu" style="float:right;cursor: pointer"><span class=" glyphicon glyphicon-pencil"></span> </a></li>');
				
			}else{
				alert("子菜单书不超过5个");
			}
			
			childmenuInit();
			
			
		}	
	
		
		
		function addBasemenu(){
			if($("#accordion").children().length<3){
				$("#accordion").append(
				
		
				  '<div class="panel panel-default"><div class="panel-heading"><div class="form-inline hide">'+
				  '<input  type="text"  class="indexkeyword" placeholder="keyword" required>'+
				  '<button type="submit" class="btn btn-default btnchangemainmenu">确定</button></div>'+
				  '<h4 class="panel-title">'+
				  '<a  class="mainmenuname" data-toggle="collapse" data-toggle="collapse" data-parent="#accordion${wx_menu.getMainMenu().size()+1 }" href="#collapse${wx_menu.getMainMenu().size()+1 }" >'+
				  '主菜单${wx_menu.getMainMenu().size()+1 }</a>'+
				  '<a  class="editmainmenu" style="cursor: pointer" class="col-md-offset-1">'+
				  '<span class=" glyphicon glyphicon-pencil"></span></a></h4></div>'+
				  '<div id="collapse${wx_menu.getMainMenu().size()+1 }"  class="panel-collapse collapse in">'+
				  '<div class="panel-body"><div class="childmenu"><ul class="list-group" id="list-group${wx_menu.getMainMenu().size()+1 }"></ul>'+
				  '<div ><a  class="editchildmenu" style="cursor: pointer" class="btn btn-link " onclick="addchilmenu(\'list-group${wx_menu.getMainMenu().size()+1 }\')"><span class="glyphicon glyphicon-plus"> 添加子菜单</span></a>'+
				  '</div></div></div></div></div>');
				  				                	
				                	
				clickInit();
						    
			}
				      		      	
				      		

		}
		
		function childmenuInit(){
			$(".editchildmenu").click(function(){
				
				$(".modal-body").append('<form role="form"><div class="form-group">'+
						'<label for="childmenutitle">菜单名</label>'+
						'<input type="text" class="form-control" id="childmenutitle" placeholder="菜单名"></div>'+
						'<div class="form-group"><label for="childmenutype">菜单类型</label>'+
						'<select class="form-control" id="keywordorurl"><option>事件</option><option>链接</option></select></div></form>'
						
						
						);		
				
				
				$(".modal-body").find("#childmenutitle").val($(this).parent(".list-group-item").children(".childmenuname").html());
				//$("#childmenutitle").val($(this).parent(".list-group-item").children(".childmenuname").html());
				
				  
		
				$('#myModal').modal('toggle');
				
			});
		}
		
		$('#myModal').on('hidden.bs.modal', function (e) {
			$(".modal-body").empty();
			});
	
		$(document).ready(function(){
		
			clickInit();
			childmenuInit();
			
			
		
		});
		
	</script>



		

<%@ include file="/protected/footer.jsp"%>