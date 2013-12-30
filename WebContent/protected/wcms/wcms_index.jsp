

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>

<style>
	.img-size{
		width:50px;
		height:50px
	}
</style>


<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wcms_index" class="list-group-item active">滑动图片</a>
            <a href="${ctx}/protected/wcms_nav" class="list-group-item">导航链接</a>
			<a href="${ctx}/protected/wcms_news" class="list-group-item">新闻动态</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  
  	<div class="panel panel-default">
 		<div class="panel-heading">
    		<h3 class="panel-title">
     			asd
   			</h3>
      
   		</div>
   		<div class="panel-body " >
			    <div id="carousel-example-captions" class="carousel slide" style="max-width:360px;text-align:center" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-captions" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-captions" data-slide-to="1"></li>
          <li data-target="#carousel-example-captions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" style="text-align:center">
          <div class="item active">
            <img src="${ctx}/img/1.png" alt="First slide image" style="max-height:200px">
            <div class="carousel-caption">
              
              <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
            </div>
          </div>
          <div class="item">
            <img src="${ctx}/img/2.jpg" alt="Second slide image" style="max-height:200px">
            <div class="carousel-caption">
              <h3>Second slide label</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </div>
          </div>
          <div class="item">
            <img src="${ctx}/img/3.jpg" alt="Third slide image" style="max-height:200px">
            <div class="carousel-caption">
              <h3>Third slide label</h3>
              <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
            </div>
          </div>
        </div>
         <a class="left carousel-control" href="#carousel-example-captions" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-captions" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>

		<legend></legend>
		<div class="row">
			<div class="col-md-4">
				<img  id="img1" src="${ctx}/img/1.png" class="img-rounded" style="max-width:200px;max-height:200px"  />
    			<input   type="file" id="picurl1"    onchange='showimg("img1","picurl1")'>
			</div>
			<div class="col-md-4">
				<button  style="display:inline" class="btn btn-default " type="button" >修改</button>
			</div>
		</div>

  		
  		<legend></legend>
  		<div class="row">
			<div class="col-md-4">
				<img  id="img2" src="${ctx}/img/2.jpg" class="img-rounded" style="max-width:200px;max-height:200px"  />
    			<input style="display:inline"  type="file" id="picurl2"    onchange='showimg("img1","picurl1")'>
			</div>
			<div class="col-md-4">
				<button  style="display:inline" class="btn btn-default " type="button" >修改</button>
			</div>
		</div>
		
  		<legend></legend>
  		<div class="row">
			<div class="col-md-4">
				<img  id="img3" src="${ctx}/img/3.jpg" class="img-rounded" style="max-width:200px;max-height:200px"  />
    			<input style="display:inline" type="file" id="picurl3"    onchange='showimg("img1","picurl1")'>
			</div>
			<div class="col-md-4">
				<button  style="display:inline" class="btn btn-default " type="button" >修改</button>
			</div>
		</div>
 		

  		</div>
   		
   
    </div>
  
   
   
 </div>
  	
</div>



<script type="text/javascript">
	

$(".navbar-nav li").each(function(){

	$(this).removeClass("active");

});

$(document).ready(function(){

	$("#wxcmsmanager").addClass("active");
	
	
	$("#picurl1").uploadify({
		"height": 30,
		"swf": "${ctx}/img/uploadify.swf",
	    "uploader": "${ctx}/protected/uploaderPic;jsessionid=<%=session.getId()%>" ,
		"width": 120,
		'method'   : 'post',
		"buttonText": '<a class="icon-upload icon-white"></a><span style="font-size:14px">选择文件</span>',
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
	
	$("#picurl2").uploadify({
		"height": 30,
		"swf": "${ctx}/img/uploadify.swf",
	    "uploader": "${ctx}/protected/uploaderPic;jsessionid=<%=session.getId()%>" ,
		"width": 120,
		'method'   : 'post',
		"buttonText": '<a class="icon-upload icon-white"></a><span style="font-size:14px">选择文件</span>',
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
	
	$("#picurl3").uploadify({
		"height": 30,
		"swf": "${ctx}/img/uploadify.swf",
	    "uploader": "${ctx}/protected/uploaderPic;jsessionid=<%=session.getId()%>" ,
		"width": 120,
		'method'   : 'post',
		"buttonText": '<a class="icon-upload icon-white"></a><span style="font-size:14px">选择文件</span>',
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
		
<script src="/SpringMVC/js/jquery.uploadify.js"></script>
<%@ include file="/protected/footer.jsp"%>