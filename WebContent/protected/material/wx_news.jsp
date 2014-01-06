
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/protected/header.jsp"%>
<link href="css/jquery-ui.css" rel="stylesheet" />
  <link href="css/jquery.dataTables.css" rel="stylesheet">

<div class="row">
  <div class="col-md-2 col-md-offset-1">
  	<div class="btn-group-vertical sidebar-offcanvas" role="navigation">

		<div class="list-group">
            <a href="${ctx}/protected/wx_news" class="list-group-item active">图文预览</a>
            <a href="${ctx}/protected/wx_news_add" class="list-group-item">图文添加</a>
          </div>
	</div>
  </div>
  <div class="col-md-8">
  	
  		
    	
  		
  
  	 	<div class="list-group">
  	 	<div class="row">
  		<c:forEach items="${newslist}" var = "rowlist">
  			<div class="col-md-6">
  			<div class="panel panel-default">
  			<div class="panel-heading">
   			 <h3 class="panel-title">图文预览</h3>
  			</div>
  			<div class="panel-body">
  			<ul class="media-list list-group-item">
  				
  				<c:forEach items="${rowlist.getArticles()}" var = "aticallist">
  					
  					<li class="media "> 					
    					<a class="pull-right" href=" ">
      						<img class="media-object" src="${ctx }/${aticallist.getPicUrl()}" style="max-width:100px;max-height:100px" width="100",height="100"/>
    					</a>
    					<div class="media-body ">
    						<a style="display:block;font-weight:bold" href="${ctx }/protected/wx_news_edit?newsId=${rowlist.getId()}" >
    							<h5>${aticallist.getTitle()}</h5>
    						</a>
    						<a style="display:block;color:#000" href="${aticallist.getUrl() }">
    							${aticallist.getDiscription()}
    						</a>
      						
      						
   					 	</div>
   					 
  					</li>
  					
  				
  				</c:forEach>
  				
			</ul>
  			</div>
	</div>
  			</div>
  		</c:forEach>
  		
  		</div>
  		<!--  
  		<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
  		<a href="#" class="list-group-item">Morbi leo risus</a>
  		<a href="#" class="list-group-item">Porta ac consectetur ac</a>
  		<a href="#" class="list-group-item">Vestibulum at eros</a>-->
	</div>
   
  	
  </div>

</div>


<script src="${ctx}/js/news.js"></script>
<script src="${ctx}/js/jquery.uploadify.js"></script>

<script type="text/javascript">
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

function saveIndex()
{
	
} 
</script>
		

<%@ include file="/protected/footer.jsp"%>