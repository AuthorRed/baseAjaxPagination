<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异步分页请求</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tip-twitter/tip-twitter.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/bootstrap.min.css"> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery.blockui.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery.poshytip.js"></script>
<%-- <td class="text-left" title="{{item.name}}>{{item.name}}</td> --%>
<script	id="userListItemList" type="text/html">
         {{each rows as item index}}
<tr>
<td>{{item.id}}</td>
<td class="text-left" title="{{item.name}}">{{item.name}}</td>
<td>{{item.date}}</td>
</tr>					
		{{/each}}
</script> 
<script type="text/javascript">
$(document).ready(function(){
	//console.log("ready function okay!");
	var data={};
	data.rows = 10;
    data.page = 1;
	loadGrid(data);
	});
</script>
<script type="text/javascript">
function my_initpage(startPage){
	if(!startPage){
		startPage=1;
	}
	//初始化分页插件
	  $("#pageBar").twbsPagination({
			totalPages:25,
			visiblePages:9,
			startPage:startPage,
			first:'first',
			prev:'prev',
			next:'next',
			last:'last',
			showGoto:true,
			onPageClick: function (event, page) {
				 //console.log(page);
				 if(!data) {
		var data={};
				};
				data.page=page;				
				loadGrid(data);
		    }
		});	
}

function loadGrid(sendData){
	sendData.rows=3;
	mypage=sendData.page;
	//console.log(sendData);
	$.ajax({		   
		   type: "POST",
		   data: sendData,
		   url:"${pageContext.request.contextPath}/user/listPage.do",
		   async: true,
		   dataType: "json",
		   beforeSend: function () {
				$.blockUI();
				console.log("我要效果！")
			},
		   success: function(data){
			   $.unblockUI();
			   //setTimeout($.unblockUI, 2000);
		   //console.log(data);
		   var myUserList = template('userListItemList' , data);
		   //console.log("myUserList:"+myUserList);
		   $("#tableBody").empty();
		   $("#tableBody").html(myUserList);
		   my_initpage(mypage);
		   //console.log(mypage);
		   $('.text-left').poshytip({
   			className: 'tip-twitter',
   			showTimeout: 1,
   			alignTo: 'target',
   			alignX: 'left',
   			alignY: 'center',
   			offsetX: 8,
   			offsetY: 5,
   		});
		   }
		});
}
</script>
</head>
<body>
<input id="jid" type="button" > 
<table border="1">
<thead>
<td>id</td><td>name</td><td>date</td>
</thead>
<tbody id="tableBody" class="container"></tbody>
</table>
<div class="container">
<div class="text-center page_box">
				<span id="currentTotalPage"><strong ></strong></span>
				<span class="ml15">共<strong  id="totalP"></strong>条</span>&nbsp;
				<div id="pageBar" class="pagergoto">
				</div>  
		    </div> 
</div>
</body>
</html>