
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<c:set value="${mapindex.get(\"wx_menu\")}" var="wx_menu" />




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
  
  	<div class="alert alert-success " id="alertsuccess" style="display:none">
  		<a href="#" class="alert-link">修改成功</a>
	</div>
	
	<div class="alert alert-danger " id="alertfails" style="display:none">
 	 	<a href="#" class="alert-link">修改失败</a>
	</div>
 
   <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">
	  	菜单管理
	  	 <a  class="btn btn-link " style="float:right" onclick="addBasemenu()"><span class="glyphicon glyphicon-plus"> 添加主菜单</span></a>
  </div>
  <div class="panel-body">
  
  
  		<div class="panel-group" id="accordion">
  		
  		<c:forEach items="${mapindex.get(\"wx_menu\").getMainMenu()}" var = "rowmap" varStatus="status">
  <div class="panel panel-default basemenu">
    <div class="panel-heading">
    	<div class="form-inline hide">
                	<input  type="text"  class="indexkeyword" placeholder="keyword" required>
                	<button type="submit" class="btn btn-default btnchangemainmenu">确定</button>
        </div>
        <h4 class="panel-title">
         <a  class="mainmenuname mainmenuname${status.index }" data-toggle="collapse" data-toggle="collapse" data-parent="#accordion${status.index }" href="#collapse${status.index }" >
                ${rowmap.key }           
         </a>
         
         <a  class="editmainmenu col-md-offset-1" style="cursor: pointer" >
        	<span class=" glyphicon glyphicon-pencil"></span>
         </a>&nbsp;&nbsp;
          <a  class="delmainmenu " style="cursor: pointer" class="col-md-offset-1">
        	<span class=" glyphicon glyphicon-trash"></span>
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
      					<span class="col-md-offset-1 keywordorurl hide">${innerlist.getMenuType()}</span>
      					<span class="col-md-offset-1 keyword">${innerlist.getKeywordOrUrl()}</span>
      					<a  class="delchildmenu " style="float:right;cursor: pointer"><span class=" glyphicon glyphicon-trash"></span> </a>
      					<a  class="editchildmenu " style="float:right;cursor: pointer"><span class=" glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp; </a>
      					
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
  	
   <div class="panel-footer" style="text-align:center">
      <button type="button" id="saveMenubtn" class="btn btn-primary">确定</button>
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
	
	
		var baseMenuNum= "${wx_menu.getMainMenu().size() }";
		
		
		
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
			$(".delmainmenu").click(function(){
				
				baseMenuNum++;
				//alert($(this).parents('.panel-title').children(".mainmenuname").text());
				$(this).parents('.basemenu').remove();

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
				$('#'+obj).append('<li class="list-group-item"><span class="childmenuname">子菜单'+($('#'+obj).children().length+1)+'</span>'+
						'<span class="col-md-offset-1 keywordorurl hide"></span>'+
						'<span class="col-md-offset-1 keyword"></span>'+
						'<a  class="delchildmenu " style="float:right;cursor: pointer"><span class=" glyphicon glyphicon-trash"></span> </a>'+
						'<a class="editchildmenu" style="float:right;cursor: pointer"><span class=" glyphicon glyphicon-pencil"></span> &nbsp;&nbsp;&nbsp;</a></li>');
				
			}else{
				alert("子菜单书不超过5个");
			}
				

			
			//alert($('#'+obj+' li').hasClass('list-group-item'));
			childmenuInit($('#'+obj+" li").last().children('.editchildmenu'));
			childmenuDel($('#'+obj+" li").last().find('glyphicon-trash'));
			
		}	
	
		
		
		function addBasemenu(){
			if($("#accordion").children().length<3){
				$("#accordion").append(
				
		
				  '<div class="panel panel-default basemenu"><div class="panel-heading"><div class="form-inline hide">'+
				  '<input  type="text"  class="indexkeyword" placeholder="keyword" required>'+
				  '<button type="submit" class="btn btn-default btnchangemainmenu">确定</button></div>'+
				  '<h4 class="panel-title">'+
				  '<a  class="mainmenuname mainmenuname'+baseMenuNum+'" data-toggle="collapse" data-toggle="collapse" data-parent="#accordion'+baseMenuNum+'" href="#collapse'+baseMenuNum+'" >'+
				  '主菜单'+baseMenuNum+'</a>'+
				  '<a  class="editmainmenu col-md-offset-1" style="cursor: pointer" >'+
				  '<span class=" glyphicon glyphicon-pencil"></span></a>'+
				  '&nbsp;&nbsp; <a  class="delmainmenu " style="cursor: pointer" class="col-md-offset-"><span class=" glyphicon glyphicon-trash"></span></a> </h4></div>'+
				  '<div id="collapse'+baseMenuNum+'"  class="panel-collapse collapse in">'+
				  '<div class="panel-body"><div class="childmenu"><ul class="list-group" id="list-group'+baseMenuNum+'"></ul>'+
				  '<div ><a   style="cursor: pointer" class="btn btn-link " onclick="addchilmenu(\'list-group'+baseMenuNum+'\')"><span class="glyphicon glyphicon-plus"> 添加子菜单</span></a>'+
				  '</div></div></div></div></div>');
				  				                	
				
				baseMenuNum++;
		        	
		               	
				clickInit();
						    
			}
				      		      	
				      		

		}
		
		function childmenuDel(obj){
			
			
			$(obj).click(function(){
				$(this).remove();
			});
		
			
		}
		
		function childmenuInit(obj){
			
			
				obj.click(function(){
					
					
					
					$(this).addClass("edit");
					
					$(".modal-body").append('<form role="form"><div class="form-group">'+
							'<label for="childmenutitle">菜单名</label>'+
							'<input type="text" class="form-control" id="childmenutitle" placeholder="菜单名"></div>'+
							'<div class="form-group"><label for="childmenutype">菜单类型</label>'+
							'<select class="form-control" id="keywordorurl"><option value="0" >事件</option><option value="1">链接</option></select></div>'+
							'<div class="form-group"><label for="keyword">关键字/链接</label>'+
							'<input type="text" class="form-control" id="keyword" placeholder="关键词 /url"></div>'+
							
							'<div class="form-group hide"><label for"keyword">关键词</label>'+
							'<select class="form-control " id="keywordorurl">'+
							'<c:forEach items="${mapindex.get(\"indexlist\")}" var = "rowlist" varStatus="status">'+
							'<option>${rowlist.getKeyword()}</option></c:forEach>'+
							'</form>'
							
							
							);		
					
						
					
					
					$(".modal-body").find("#childmenutitle").val($(this).parent(".list-group-item").children(".childmenuname").html());
					//$("#childmenutitle").val($(this).parent(".list-group-item").children(".childmenuname").html());
					$(".modal-body").find("#keyword").val($(this).parent(".list-group-item").children(".keyword").html());
					$(".modal-body").find("#keywordorurl").val($(this).parent(".list-group-item").children(".keywordorurl").html());
					
					
					
					btnTextConfirm($(".editchildmenu"));
					/*
					$("#btnTextConfirm").click(function(){
					
						$(".editchildmenu").each(function(){
							
							if($(this).hasClass("edit")){
								
								$(this).parent(".list-group-item").children(".childmenuname").html($(".modal-body").find("#childmenutitle").val());
								$(this).parent(".list-group-item").children(".keyword").html($(".modal-body").find("#keyword").val());
								$(this).parent(".list-group-item").children(".keywordorurl").html($(".modal-body").find("#keywordorurl").val());
							}
							
							
						});
						$('#myModal').modal('hide');
						
					});
					*/
					  
			
					$('#myModal').modal('toggle');
					
				});
			
			
		}
		
		function btnTextConfirm(obj){
			
			
				
				$("#btnTextConfirm").click(function(){
					
					obj.each(function(){
						if($(this).hasClass("edit")){
							
							$(this).parent(".list-group-item").children(".childmenuname").html($(".modal-body").find("#childmenutitle").val());
							$(this).parent(".list-group-item").children(".keyword").html($(".modal-body").find("#keyword").val());
							$(this).parent(".list-group-item").children(".keywordorurl").html($(".modal-body").find("#keywordorurl").val());
						}
						
						
					});
					
					$('#myModal').modal('hide');
				});
				
				
			
		}
		
		$('#myModal').on('hidden.bs.modal', function (e) {
			$(".modal-body").empty();
			$(".editchildmenu").each(function(){
				$(this).removeClass("edit");
			});
		});
		
		$("#saveMenubtn").click(function(){
			
			var menu=new Array();
			
			var mainlen = $('#accordion').children().length;
			for(var i=0;i<mainlen;i++){
				
				var mainmenu =new Object();
				mainmenu.menuname= $(".mainmenuname"+i).text().trim();
				
				mainmenu.submenus=new Array();
				
				var submainlen =$("#list-group"+i).children().length;
				
				//alert(submainlen);
				
				$("#list-group"+i).children().each(function(){
					
					var submenu=new Object();
					submenu.menuname =$(this).children('.childmenuname').text().trim();
					submenu.menutype =$(this).children('.keywordorurl').text().trim();
					submenu.word =$(this).children('.keyword').text().trim();
					
					mainmenu.submenus.push(submenu);
					//alert(mainmenu.submenus[i].menuname);
				});
				
				menu[i]=mainmenu;
				/*
				for(var j=0;j<submainlen;j++){
					
					<li class="list-group-item">
  					<span class="childmenuname">${innerlist.getMenuName()}</span>
  					<span class="col-md-offset-1 menutype hide">${innerlist.getMenuType()}</span>
  					<span class="col-md-offset-1 keywordorurl">${innerlist.getKeywordOrUrl()}</span>
  					<a  class="editchildmenu" style="float:right;cursor: pointer"><span class=" glyphicon glyphicon-pencil"></span> </a>
  				</li>
  				
				}*/
				//alert(submenu.menuname);
			}
			
			
			//alert(menu[1].submenus[1].menuname);
			
			
			
			$.ajax({
				
				
				url:"${ctx}/protected/wx_index_menu",
				type:"POST",
				timeout:10000,
				beforeSend :function (XMLHttpRequest, textStatus, errorThrown){
					
		
					
			         
		        },
		        
		        complete:function (XMLHttpRequest, textStatus){
		        	
		        },
		        
		        data: {menu:JSON.stringify(menu)},
		        error: function (XMLHttpRequest, textStatus, errorThrown) {
		        	
		        },
		        
		        success:function (data, textStatus) {

		        	try{
		        		var data=eval('(' + data + ')'); 
			        	
			        	if(data.flag){
			        		$("#alertsuccess").fadeIn();;
			        		$("#alertsuccess").fadeOut(3000);
			        	}else{
			        		$("#alertfails").fadeIn();;
			        		$("#alertfails").fadeOut(3000);
			        	}
		        		
		        	}catch(e){
		        		
		        		$("#alertfails").fadeIn();;
		        		$("#alertfails").fadeOut(3000);
		        	}
		        	
		        	
		        
		        }
		        
			});
			
			
		});
	
		$(document).ready(function(){
		
			clickInit();
			$(".editchildmenu").each(function(){
				childmenuInit($(this));
			});
			
			$(".list-group-item").each(function(){

				childmenuDel($(this).find('glyphicon-trash'));
				
			});
			
	
			
		
		});
		
	</script>


<script src="${ctx}/js/json.js"></script>

		

<%@ include file="/protected/footer.jsp"%>