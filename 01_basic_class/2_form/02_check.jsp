<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%
	// 1) 이전 화면에서 사용자 입력값들을 얻어오기
	// 		- request.getParameter('')
	//		- request.getParameterValues('')
	String name =  request.getParameter("name");
	String gender =  request.getParameter("gender");
	String[] hobby = request.getParameterValues("hobby");
	String hobbyTxt = "";
	//if(hobby != null) {
		for(int i=0; hobby != null && i<hobby.length; i++){
			hobbyTxt += hobby[i] + '/';
		}
	//}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 2) 얻어온 입력값들을 화면에 출력하기 -->
	이름 : <%= name %><br/>
	성별 : <%= gender %><br/>
	취미 : <%= hobbyTxt %>
</body>
</html>