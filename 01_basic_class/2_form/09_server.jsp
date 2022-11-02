<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="temp.*" %>
<%

 // 1. 이전 폼의 사용자 입력값을 얻어 오세요
	int empno =  Integer.parseInt(request.getParameter("empno"));
	String ename =  request.getParameter("ename");
	int deptno =  Integer.parseInt(request.getParameter("deptno"));
	String job = request.getParameter("job");
	int sal =  Integer.parseInt(request.getParameter("sal"));
 
 // 2. EmpVO 멤버변수에 지정
 	EmpVO vo = new EmpVO();
	vo.setEmpno(empno);
	vo.setEname(ename);
	vo.setDeptno(deptno);
	vo.setJob(job);
	vo.setSal(sal);
	
 // 3. DB에 입력	
 	EmpDAO dao = new EmpDAO();
 	dao.insert(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 사원등록 </title>
</head>
<body>
	 성공적으로 입력되었는지 DB에서 확인합니다.
	 <hr/>
	 <!-- 1-2)입력받은 값 춣력  -->
	 사원번호 : <%= empno %><br/>
	 사원이름 : <%= ename %><br/>
	 부서번호 : <%= deptno %><br/>
	 부서 : <%= job %>
	 월급 : <%= sal %>
</body>
</html>