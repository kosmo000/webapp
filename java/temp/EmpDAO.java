package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

		public class EmpDAO {

		  private void insert(EmpVO vo) throws Exception{
		      
		      // 1. 드라이버 로딩
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      System.out.println("1. 드라이버 로딩 성공");
		      
		      // 2. 연결 객체 얻어 오기
		      String url = "jdbc:oracle:thin:@192.168.0.2:1521:xe";
		      String user = "scott";
		      String pass = "tiger";
		      Connection con = DriverManager.getConnection(url, user, pass);
		      System.out.println("2. 연결 성공");
		      
		      // 3. sql 작성(emp 테이블에 insert)
		      String sql = " INSERT INTO EMP ( EMPNO, ENAME, DEPTNO, JOB, SAL) "
		            + " VALUES (?, ?, ?, ?, ?)  ";
		      
		      // 4. 전송 객체 얻어 오기(+ ?에 값 지정)
		      PreparedStatement ps = con.prepareStatement(sql);
		      
		      ps.setInt(1, vo.getEmpno());
		      ps.setString(2, vo.getEname());
		      ps.setInt(3, vo.getDeptno());
		      ps.setString(4, vo.getJob());
		      ps.setInt(5, vo.getSal());
		      
		      // 5. 전송
		      ResultSet rs = ps.executeQuery();
		      
		      // 6. 닫기
		      ps.close();
		      rs.close();
		      
		   }
		   static EmpDAO empDAO = null;
		   public static EmpDAO getInstance() throws Exception{
			   if( empDAO == null ) empDAO = new EmpDAO();
			   return empDAO;
		   }
		
	}

