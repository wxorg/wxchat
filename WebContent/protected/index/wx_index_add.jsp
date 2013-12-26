
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


<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_index" class="list-group-item">普通索引</a>
            <a href="#" class="list-group-item">菜单管理</a>
			<a href="${ctx}/protected/wx_index_add" class="list-group-item  active">添加索引</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  	<div class="panel panel-default">
  	<div class="panel-heading">
    	<h3 class="panel-title">添加索引</h3>
  	</div>
  	<div class="panel-body">
  		 <form role="form">
  		 	
  		 	<div class="form-group" style="max-width:600px">
    			<label for="indextype">索引类型</label>
  			    <select class="form-control">
  					<option value="-1">选择索引类型</option>
  					<option value="0">关注索引</option>
  					<option value="1">关键词索引</option>
  					<option value="2">搜索索引</option>
  					<option value="3">默认索引</option>
				</select>

  			    
  			</div>
  			
 			 <div class="form-group" style="max-width:600px">
				<label for="keyword">索引关键词</label>
				<input type="text" class="form-control" id="keyword" placeholder="keyword" required>
 			 </div>
  			
 			 <div class="form-group" style="max-width:600px">
   				 <label for="msgtype">消息类型</label>
   				 <select class="form-control">
  					<option value =-1>消息类型</option>
 					<option value =0>文本</option>
  					<option value =1>图片</option>
  					<option value =2>声音</option>
  					<option value =3>视频</option>
  					<option value =4>图文</option>
				</select>
  			</div>
  			
  			<div class="form-group" style="background-color: #E1E1E1;padding:10px 10px 10px 10px">
   				 <label for="return">回复内容</label>
   				 <div class="row" >
   				 	<div  class="col-md-2">
   				 		<a data-toggle="modal" id ="add_Text_Index_Modal">
   				 			<span class="btn btn-lg btn-default glyphicon glyphicon-pencil">&nbsp;文字</span>
   				 		</a>
   				 	</div>
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
					<button  class="btn btn-default" type="submit" onclick="saveIndex()">提交</button>
      			
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
			<div class="modal-body">
				
       
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" id="btnTextConfirm" class="btn btn-primary">确定</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script>

	var saveUrl ="${ctx}/protected/wx_index_add";

	var content ={
			msgType:0,
			text:"sdf"
	}
	$("#btnTextConfirm").click(function(){
		
		$("#index_add_result").append('<div class="alert alert-success alert-dismissable"><div class="row" ><div class="col-md-11"><strong>'+$("#index_add_text").val()
				+'</strong></div><div class="col-md-1"><a  href=""><span style="text-align:center" class="btn-lg glyphicon glyphicon-trash"></span></a></div></div>');
		content.msgType=1;
		content.text=$("#index_add_text").val();
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
		
		
		$('#myModal').modal('toggle');
		
	});
	
	
	
	
	
	
	function saveIndex(){
		
		$.ajax({
			
			url:saveUrl,
			type:"POST",
			timeout:3000,
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

	        	
	        	
	        
	        }
	        
		});
		
	}
	

	
	
	
</script>



		

<%@ include file="/protected/footer.jsp"%>