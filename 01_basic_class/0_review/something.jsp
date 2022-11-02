<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.*" %>    
<%
// 0. 한글처리
request.setCharacterEncoding("utf-8");
// 1. 이전 폼의 입력값 얻어오기
	String realname =  request.getParameter("realname");
	String nickname =  request.getParameter("nickname");
	String myemail =  request.getParameter("myemail");
	String myage   =  request.getParameter("myage");

// 2. VO객체에 저장하기
	MemberVO vo = new MemberVO();
	vo.setRealname(realname);
	vo.setNickname(nickname);
	vo.setMyemail(myemail);
	vo.setMyage(Integer.parseInt(myage));
// 3. DB에 입력하기
	MemberDAO dao = new MemberDAO();
	dao.insert(vo);
// 4. 출력은 알아서

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 성공적으로 입력되었는지 DB에서 확인합니다.
	 <hr/>
	 <!-- 1-2)입력받은 값 춣력  -->
	 본명 : <%= realname %><br/>
	 별명 : <%= nickname %><br/>
	 이메일 : <%= myemail %><br/>
	 나이 : <%= myage %>

</body>
</html>