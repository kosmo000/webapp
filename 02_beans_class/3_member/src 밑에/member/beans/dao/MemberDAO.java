package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {
   
   

   private MemberDAO() throws Exception{
       // 1. 드라이버 로딩
       Class.forName("oracle.jdbc.driver.OracleDriver");
       System.out.println("1. 드라이버 로딩 성공");
       }
       
       static MemberDAO memDAO =null;
       public static MemberDAO getInstance() throws Exception{
          if(memDAO  ==null) memDAO = new MemberDAO();
          return memDAO;
       }

      public void insert(MemberVO vo) throws Exception{
         Connection con = null;
         PreparedStatement ps = null;
         
         
         try {
         // 2. 연결 객체 얻어 오기
         String url = "jdbc:oracle:thin:@192.168.0.2:1521:xe";
         String user = "scott";
         String pass = "tiger";
         con = DriverManager.getConnection(url, user, pass);
         System.out.println("2. 연결 성공");
         
         // 3. sql 작성(emp 테이블에 insert)
         String sql = "INSERT INTO REVIEW (본명,별명,이메일,나이) "
               + " VALUES (?, ?, ?, ?)  ";
         
         // 4. 전송 객체 얻어 오기(+ ?에 값 지정)
         ps = con.prepareStatement(sql);
         
         
         ps.setString(1, vo.getRealname());
         ps.setString(2, vo.getNickname());
         ps.setString(3, vo.getMyemail());
         ps.setInt(4, vo.getMyage());
         
         // 5. 전송
         ps.executeUpdate();
         
         // 6. 닫기
         
         
         }finally {
            ps.close();
             con.close();
             
         }
      }
      
   }