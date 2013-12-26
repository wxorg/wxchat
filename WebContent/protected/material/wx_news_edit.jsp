
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>
<link href="css/jquery-ui.css" rel="stylesheet" />
  <link href="css/jquery.dataTables.css" rel="stylesheet">

<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_news" class="list-group-item active">图文预览</a>
            <a href="${ctx}/protected/wx_news_add" class="list-group-item ">图文添加</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  	<div class="row">
  		<div class="col-md-6">
  			<div class="panel panel-default">
  			<div class="panel-heading">
    			<h3 class="panel-title">图文修改</h3>
  			</div>
  			<div class="panel-body">
			<ul class="media-list">
				<a class="hide" id="msgid">${msg_News.getId()}</a>
				<c:forEach items="${msg_News.getArticles()}" var = "article"  varStatus="status">
					<li class="media radio">
  					
  						<input type="radio" name="optionsRadios"  class="optionsRadios" value="option1" >
    					<a class="pull-right" href="#">
      						<img class="media-object img-rounded" id="listimg" src="${article.getPicUrl()}" alt="..." width="70",height="70">
    					</a>
    					<div class="media-body ">
      						
      						<h4 id="listtitle">${article.getTitle()}</h4>
      						
   					 	</div>
   					 	<a class="hide" id="listdescrip">${article.getDiscription()}</a>
   					 	<a class="hide" id="listurl">${article.getUrl()}</a>	
   					 	<a class="hide" id="listid">${article.getId()}</a>
  					</li>
				</c:forEach>
					
  				
			</ul>
			</div>
		</div>
			<button  class="btn btn-default col-md-offset-4" type="button" onclick="savenews()">提交</button>

			
  		</div>
  		<div class="col-md-6">
  			<form action="${ctx}/protected/wx_news_edit" method="POST" role="form">
   				<div class="panel-group" id="accordion">
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
										<button  class="btn btn-default" type="button" onclick="saveartical()">提交</button>
      			
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

function clearEditArtical(){
	document.getElementById("img1").src="";
	//alert($(this).children($(".media-body")).text().trim());
	
	$("#articalid").val("");
	$("#title").val("");
	//alert($(this).children("#listid").text().trim());
	$("#descrip").val("");
	$("#url").val("");
	
}




$(document).ready(function(){
	
	$(".optionsRadios").change(function(){
		
		$(".radio").each(function(){
			//alert($(this).children(".optionsRadios").attr("value"));
			if($(this).children(".optionsRadios").prop('checked')){
		
				document.getElementById("img1").src=$(this).children(".pull-right").children(".media-object").attr("src");
				//alert($(this).children($(".media-body")).text().trim());
				
				$("#title").val($(this).children(".media-body").children("#listtitle").text().trim());
				//alert($(this).children("#listid").text().trim());
				$("#descrip").val($(this).children("#listdescrip").text().trim());
				$("#url").val($(this).children("#listurl").text().trim());
			}
		});
		
	})	;
	


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

function addArticle(){
	clearEditArtical();
	$("#addArtical").removeClass("hide");
	$("#addArtical").children(".optionsRadios").prop('checked',true);
}

function saveartical()
{
	
    $(".media-list").children(".radio").each(function(){
    	if($(this).children(".optionsRadios").prop('checked')){
    		$(this).children(".pull-right").children(".media-object").attr("src",document.getElementById("img1").src);
			//alert($(this).children($(".media-body")).text().trim());
    		$(this).children(".media-body").html('<h4>'+$("#title").val()+'</h4>');
    		$(this).children("#listdescrip").text($("#descrip").val());
    		$(this).children("#listurl").text($("#url").val());
	
		}
    })  ;  
	
	
} 

function savenews()
{
	var i=0;
	var data={
			"MsgId":$("#msgid").text().trim(),
			"ArticleCount":0,
			"Articles":new Array()	
	};
	
	
	$(".media-list").children(".radio").each(function(){
		i++;
		var item = new Object();
		item.Id=$(this).children("#listid").text().trim();
		item.Title=$(this).children(".media-body").children("#listtitle").text().trim();
		item.Description=$(this).children("#listdescrip").text().trim();
		item.PicUrl=$(this).children(".pull-right").children(".media-object").attr("src");
		item.Url=$(this).children("#listurl").text().trim();
		
		data.Articles[i]=item;
		
	});
	
	data.ArticleCount=i;
	

	
	$.ajax({
		url:"${ctx}/protected/wx_news_edit",
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
        		
        	
        		window.location.href="${ctx}/protected/wx_news";
	        	
        	}catch(e){
	    		
	    		
	    	}
        	
        
        }
        
	});
	
} 






</script>
		

<%@ include file="/protected/footer.jsp"%>