
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>
<link href="css/jquery-ui.css" rel="stylesheet" />
  <link href="css/jquery.dataTables.css" rel="stylesheet">

<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_news" class="list-group-item ">图文预览</a>
            <a href="${ctx}/protected/wx_news_add" class="list-group-item active">图文添加</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  	<div class="row">
  		<div class="col-md-6">
  		
  			<div class="panel panel-default">
  				<div class="panel-heading">
    				<h3 class="panel-title">添加图文</h3>
  				</div>
  				<div class="panel-body">
    				<ul class="media-list">
					
				
  				
					</ul>
			
					
  				</div>
			</div>
  			<div >
				<a id="addplatformbtn" class="btn btn-default btn-lg btn-block " onclick="addArticle()"><span class="glyphicon glyphicon-plus"></span></a>
			</div>
	
			
			<button  class="btn btn-default col-md-offset-5" type="button" onclick="savenews()">提交</button>
			
      		
			
  		</div>
  		<div class="col-md-6">
  			<form  role="form ">
   				<div class="panel-group hide" id="accordion">
   					<div class="panel panel-default">
   						<div class="panel-heading">
   							<h4 class="panel-title">
   								<a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
          							图文
        						</a>
      						</h4>
    					</div>
    					<div id="collapseOne" class="panel-collapse collapse in">
      						<div class="panel-body">
      							<div class="form-group " style="max-width:600px">
   				 					<label for="id">id</label>
   				 					<input type="text" class="form-control" id="articalid" placeholder="id" required>
  								</div>
  								
      							<div class="form-group" style="max-width:600px">
   				 					<label for="title">标题</label>
   				 					<input type="text" class="form-control" id="title" placeholder="标题" required>
  								</div>
  							
  							
  								<div class="form-group" style="max-width:600px">
  									<img  id="img1" src="" class="img-rounded" style="max-width:200px;max-height:200px"  />
   				 					<label for="picurl">上传图片</label>
    			 					<input  type="file" id="picurl1"    onchange='showimg("img1","picurl1")'>
  								</div>
  			
  								<div class="form-group" style="max-width:600px">
   				 					<label for="descrip">描述</label>
   				 					<input type="text" class="form-control" id="descrip" placeholder="描述" required>
  								</div>
  		
  								<div class="form-group" style="max-width:600px">
   				 					<label for="url">链接</label>
   				 					<input type="text" class="form-control" id="url" placeholder="链接" required>
  								</div>
  							
  								<div class="form-group">
									<div class="col-md-offset-4 col-md-10">
										<button  class="btn btn-default" type="button" onclick="delaltical()">删除</button>
										<button  class="btn btn-default" type="button" onclick="saveartical()">确定</button>
      			
									</div>

								</div>
  							</div>
       						 
       					</div>
    				</div>
  				</div>
  				
  				
  				
			</form>
   
   
  		</div>
  	
			
   	
   
   </div>
   
  	
</div>
</div>


<script src="${ctx}/js/news.js"></script>
<script src="${ctx}/js/jquery.uploadify.js"></script>

<script type="text/javascript">

function clearaddArtical(){
	document.getElementById("img1").src="";
	//alert($(this).children($(".media-body")).text().trim());
	
	$("#articalid").val("");
	$("#title").val("");
	//alert($(this).children("#listid").text().trim());
	$("#descrip").val("");
	$("#url").val("");
	//$(".panel-group").addClass("hide");
}



var index=0;
var thisindex=0;

function addArticle(){
	
	if(index>9){
		return;
	}
	
	$(".media-list").append('<li id="addArtical'+index+'" class="media radio">'+
			'<input type="radio" id="radio'+index+'"name="optionsRadios" class="optionsRadios" value="option'+index+'" >'+
			'<a class="pull-right" >'+
			'<img class="media-object img-rounded" id="listimg'+index+'" src="" alt=".." width="50",height="50"></a>'+
			'<div class="media-body "><h4 id="titlelist'+index+'"></h4>'+
			'<a class="" id="listdescrip'+index+'"></a></div>'+
			'<a class="hide" id="listurl'+index+'"></a></li>'
			
	);
	
	
	
	//clearEditArtical();
	//$("#addArtical").removeClass("hide");
	$("#radio"+index).prop('checked',true);
	
	if(index==0){
		$(".panel-group").removeClass("hide");
	}
	
	
	onchange(index);
	
	
	index=index+1;
}


function onchange(i){
	
	$("#radio"+i).change(function(){
		//alert($(this).parent().attr("id"));
		
		var obj =$(this).parent();
		document.getElementById("img1").src=document.getElementById("listimg"+i).src;
		//alert($(this).children($(".media-body")).text().trim());
		
		$("#articalid").val(obj.children("#listid").text().trim());
		$("#title").val($("#titlelist"+i).text().trim());
		//alert($(this).children("#listid").text().trim());
		$("#descrip").val($("#listdescrip"+i).text().trim());
		$("#url").val($("#listurl"+i).text().trim());
	});
	
	
}




	
	

		


		
		
		
function saveartical(){
	

	for(var i=0;i<index;i++){
		if($("#radio"+i).prop("checked")){
			document.getElementById("listimg"+i).src=document.getElementById("img1").src;
			//alert(document.getElementById("listimg"+i).src);
			$("#titlelist"+i).text($("#title").val());
			$("#listdescrip"+i).text($("#descrip").val());
			$("#listurl"+i).text($("#url").val());
			
			
		}
		
	}
	
	clearaddArtical();
	
}

function savenews()
{
	var data={
			"ArticleCount":index,
			"Articles":new Array()	
	};
	
	for(var i=0;i<index;i++){
		var item = new Object();
		item.Title=$("#titlelist"+i).text();
		item.Description=$("#listdescrip"+i).text();
		item.PicUrl=document.getElementById("listimg"+i).src;
		item.Url=$("#listurl"+i).text();
		
		data.Articles[i]=item;
	}
	
	$.ajax({
		url:"${ctx}/protected/wx_news_add",
		type:"POST",
		timeout:10000,
		beforeSend :function (XMLHttpRequest, textStatus, errorThrown){
      
        },
        
        complete:function (XMLHttpRequest, textStatus){
        	
        	
        },
        
        data: data,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        
        	alert("数据提交失败："+textStatus);
        },
        
        success:function (data, textStatus) {

        
        	try{
        		
        	
        		window.location.href="${ctx}/protected/wx_news_add";
	        	
        	}catch(e){
	    		
	    		
	    	}
        	
        
        }
        
	});
	
} 

$(document).ready(function(){
	
	
	


$("#picurl1").uploadify({
	"height": 30,
	"swf": "${ctx}/img/uploadify.swf",
    "uploader": "${ctx}/protected/uploaderPic;jsessionid=<%=session.getId()%>" ,
	"width": 120,
	'method'   : 'post',
	"buttonText": '<a class="icon-upload icon-white"></a><span style="font-size:14px">选择文件1</span>',
	"fileObjName":"fileMobile", //接收表示
	"fileTypeExts":'*',
	"fileSizeLimit" : '100MB',
	"multi": false,
	"queueSizeLimit": 1,
	'wmode': 'transparent' , 
	 "removeCompleted" : true , //进度条是否消失
	 'onSelect': function(e, queueId, fileObj){

		
	 },
	 'onUploadSuccess' : function(file, data, response) {	   
		 
		 try{

	            document.getElementById("img1").src='${ctx}/uploads/'+data;
	            
	            
			 }catch(e){
		    		
		    		alert("后台返会错误信息："+e);
		    	}
	            
	        
	
            
        }
	
	});
	

});
</script>
		

<%@ include file="/protected/footer.jsp"%>