<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script  type="text/javascript"  src="libs/jquery-1.9.1.min.js"> </script>

var param = { cate : 'book', name : 'hong'};
	
	$.ajax({
		type : 'post'
		data : param,
		url	 : '02_server.jsp',
		success : function(){},
		error : function(){
			alert('error');
			console.log(err);
		}
	}); 
	
</head>


<body>
서버로부터 넘겨받은 데이터<br/>
첫번째 데이터 : <input type="text" name="" id="cate"/><br/>
두번째 데이터 : <input type="text" name="" id="name"/><br/>
</body>
</html>


