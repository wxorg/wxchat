
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<style>

	.index_add_reuslt{
		padding:5px;
		height:50px;
		width:100%;
		background-color:#c1c1c1
	}


</style>

<c:set value="${maplist.get('index') }" var="index"> 
</c:set>

<c:set value="${maplist.get('newslist') }" var="newslist"> 
</c:set>

<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_index" class="list-group-item active">普通索引</a>
            <a href="${ctx}/protected/wx_index_menu" class="list-group-item">菜单管理</a>
			<a href="${ctx}/protected/wx_index_add" class="list-group-item  ">添加索引</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  	<div class="panel panel-default">
  	<div class="panel-heading">
    	<h3 class="panel-title">编辑索引</h3>
  	</div>
  	<div class="panel-body">
  		 <form role="form">
  		 	
  		 	<div class="form-group" style="max-width:600px">
    			<label for="indextype">索引类型</label>
  			    <select class="form-control" id="indextype" value="${index.getIndexId()}">
  			    	<option value="-1">选择索引类型</option>
  			    	<c:choose>
						<c:when test="${index.getIndexId()==0}">
							<option value="0" selected>关注索引</option>
  							<option value="1" >默认索引</option>
  							<option value="2">关键词索引</option>
  							<option value="3">搜索索引</option>
						</c:when>
						<c:when test="${index.getIndexId()==1}">
							<option value="0" >关注索引</option>
  							<option value="1" selected>默认索引</option>
  							<option value="2">关键词索引</option>
  							<option value="3">搜索索引</option>
						</c:when>
						<c:when test="${index.getIndexId()==2}">
							<option value="0" >关注索引</option>
  							<option value="1" >默认索引</option>
  							<option value="2" selected>关键词索引</option>
  							<option value="3">搜索索引</option>
						</c:when>
						<c:when test="${index.getIndexId()==3}">
							<option value="0" >关注索引</option>
  							<option value="1" >默认索引</option>
  							<option value="2" >关键词索引</option>
  							<option value="3" selected>搜索索引</option>
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					</c:choose>
  			    
  					
  					
				</select>

  			    
  			</div>
  			
 			 <div class="form-group" style="max-width:600px">
				<label for="keyword">索引关键词</label>
				<input type="text" class="form-control" id="indexkeyword" value="${index.getKeyWord()}" placeholder="keyword" required>
 			 </div>
  			
  			
  			<div class="form-group" >
   				 <label for="return">回复内容</label>
   				 <div class="row" >
   				 	<div  class="col-md-2">
   				 		<a data-toggle="modal" id ="add_Text_Index_Modal">
   				 			<span class="btn btn-lg btn-default glyphicon glyphicon-pencil">&nbsp;文字</span>
   				 		</a>
   				 	</div>
   				 	<!-- 
   				 	<div  class="col-md-2">
   				 		<a data-toggle="modal" id ="add_pic_Index_Modal">
   				 			<span class="btn btn-lg btn-default glyphicon glyphicon-picture">&nbsp;图片</span>
   				 		</a>
   				 	</div>
   				 	<div  class="col-md-2">
   				 		<a data-toggle="modal" id ="add_voice_Index_Modal">
   				 			<span class="btn btn-lg btn-default glyphicon glyphicon-volume-up">&nbsp;语音</span>
   				 		</a>
   				 	</div>
   				 	<div  class="col-md-2">
   				 		<a data-toggle="modal" id ="add_film_Index_Modal">
   				 			<span class="btn btn-lg btn-default glyphicon glyphicon-film">&nbsp;视频</span>
   				 		</a>
   				 	</div>
   				 	 -->
   				 	<div  class="col-md-2">
   				 		<a data-toggle="modal" id ="add_news_Index_Modal">
   				 			<span class="btn btn-lg btn-default glyphicon glyphicon-list-alt">&nbsp;图文</span>
   				 		</a>
   				 	</div>
   				 
   				 </div>
   				
   				
  			</div>
  			 <div id="index_add_result" class="form-group" style="width:100%">
   				 	
   			</div>
  		
  			
  		
			<div class="form-group">
				<div class="col-md-offset-4 col-md-10">
					<button  class="btn btn-default" type="button" onclick="saveIndex()">提交</button>
      			
				</div>
			</div>

  		
  		
  		
  		
		</form>
   	  </div>
   
  	
 	</div>
   
   
   </div>
   
  	
 </div>
 
 


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">添加回复</h4>
			</div>
			<div class="modal-body" style="max-height:450px;overflow:auto;">
				
       
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" id="btnTextConfirm" class="btn btn-primary">确定</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->





<script>


	var saveUrl ="${ctx}/protected/wx_index_edit";

	var content ={
			indextype:-1 ,//0 关注索引,1 默认索引 2、关键词 3 搜索
			keyword:"",
			msgType:0,//1 text 2 news
			text:""
	}
	$("#btnTextConfirm").click(function(){
		$("#index_add_result").empty();
		if(content.msgType==1){
			$("#index_add_result").append('<div class="alert alert-success alert-dismissable"><div class="row" ><div class="col-md-11"><strong id="textaddresult">文本内容：'+$("#index_add_text").val()
					+'</strong></div><div class="col-md-1"><a  href=""><span style="text-align:center" class="btn-lg glyphicon glyphicon-trash"></span></a></div></div>');
			
			content.text=$("#index_add_text").val();
		}else if(content.msgType==2){
			
			$(".list-group").children(".optionsRadios").each(function(){
				if($(this).prop("checked")){
					
					$("#index_add_result").append('<div class="alert alert-success alert-dismissable"><div class="row" ><div class="col-md-11"><strong id="textaddresult">图文ID：'+$(this).attr("id")
					+'</strong></div><div class="col-md-1"><a  href=""><span style="text-align:center" class="btn-lg glyphicon glyphicon-trash"></span></a></div></div>');
					
					content.text=$(this).attr("id");
				}
			});
			
		}
		
		$(".glyphicon-trash").on('click',function(){
			content.msgType=0;
			content.text="";
	  	})	;
		
		$("#myModal").modal("hide");
		
	});
	
	$('#myModal').on('hidden.bs.modal', function (e) {
        // do something…
    	$(".modal-body").empty();
    	
    });
	
	$('#myModal').modal({
		  keyboard: false,
		  show:false
	});
	
	$("#add_Text_Index_Modal").click(function(){
		
		content.msgType=1;
		
		$(".modal-body").append('<textarea id="index_add_text" rows="5" cols="" style="width:100%;height:100%"></textarea>');
		$('#myModal').modal('toggle');
		
	});
	
	$("#add_pic_Index_Modal").click(function(){
		
		$('#myModal').modal('toggle');
		
	});
	
	$("#add_voice_Index_Modal").click(function(){
		
		
		$('#myModal').modal('toggle');
		
	});
	
	$("#add_film_Index_Modal").click(function(){
		
		
		$('#myModal').modal('toggle');
		
	});
	
	$("#add_news_Index_Modal").click(function(){
		content.msgType=2;
		$(".modal-body").append('<div class="list-group"><c:forEach items="${newslist}" var = "rowlist">'+
				'<input type="radio" id="${rowlist.getId()}"name="optionsRadios" class="optionsRadios" value="option" >'+
				'<ul class="media-list list-group-item"><c:forEach items="${rowlist.getArticles()}" var = "aticallist">'+
				'<li class="media "><a class="pull-right" href=" ">'+
				'<img class="media-object" src="${ctx}/${aticallist.getPicUrl()}" style="max-width:100px;max-height:100px" width="100",height="100"/></a>'+
				'<div class="media-body ">'+
				'<a style="display:block;font-weight:bold" href="${ctx }/protected/wx_news_edit?newsId=${rowlist.getId()}" ><h4>${aticallist.getTitle()}</h4></a>'+
				'<a style="display:block;color:#000" href="${aticallist.getUrl() }">${aticallist.getDiscription()}</a>'+
				'</div></li></c:forEach></ul></c:forEach></div>');
		$('#myModal').modal('toggle');
		
	});
	
	
  			
  	$("#indextype").change(function(){
  		if($(this).val()<2){
  			$("#indexkeyword").attr("disabled",true);
  		}else{
  			$("#indexkeyword").attr("disabled",false);
  		}
  	})	;	
  					 					
    					
      						
    					
    					
    						
    							
    						
    						
    							
    						
      						
      						
   					 	
	
	
	
	
	function saveIndex(){
		
		content.indextype=$("#indextype").val();
		content.keyword=$("#indexkeyword").val();
		
		
		$.ajax({
			
			url:saveUrl,
			type:"POST",
			timeout:10000,
			beforeSend :function (XMLHttpRequest, textStatus, errorThrown){
				
				
				$(".bar-success").css("width","20%");
				$(".bar-success").animate({
					width:'100%'},3000);
				
		         
	        },
	        
	        complete:function (XMLHttpRequest, textStatus){
	        	
	        },
	        
	        data: content,
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	        	
	        },
	        
	        success:function (data, textStatus) {

	        	if(data){
	        		window.location.href="${ctx}/protected/wx_index";
	        	}
	        	
	        
	        }
	        
		});
		
	}
	
	

	$(document).ready(function(){
		
		
		
	});
	
	
</script>



		

<%@ include file="/protected/footer.jsp"%>