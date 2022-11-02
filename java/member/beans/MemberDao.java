package member.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.dao.MemberDAO;
import member.dao.MemberVO;

public class MemberDao {

	
	// DB 연결시  관한 변수 

	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@192.168.0.79:1521:xe";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";

		
	private static MemberDao memberDao;
	
	public static MemberDao getInstance() throws MemberException
	{
		if( memberDao == null )
		{
			memberDao =  new MemberDao();
		}
		return memberDao;
	}
	

	private MemberDao() throws MemberException
	{
			
		try{
			
			/********************************************
				1. 드라이버를 로딩
							
			*/
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       System.out.println("1. 드라이버 로딩 성공");
		       
		}catch( Exception ex ){
			throw new MemberException("DB 연결시 오류  : " + ex.toString() );	
		}
	}
	
	/*******************************************
	 * * 회원관리테이블 MEMBERTEST 에  회원정보를 입력하는 함수
	 * @param rec
	 * @throws MemberException
	 */
	public void insertMember( Member rec ) throws MemberException
	{
		

		      
		         Connection con = null;
		         PreparedStatement ps = null;
		         
		         
		         try {
		         // 0. 연결 객체 얻어 오기
		 
		         con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		         System.out.println("2. 연결 성공");
		         
		         // 1. sql 작성(emp 테이블에 insert)
		         String sql = "Insert into membertest values(?,?,?,?,?)" + "where id=?";
		         
		         // 2. 전송 객체 얻어 오기(+ ?에 값 지정)
		         ps = con.prepareStatement(sql);
		         
		         
		         ps.setString(1, rec.getId());
		         ps.setString(2, rec.getPassword());
		         ps.setString(3, rec.getName());
		         ps.setString(4, rec.getTel());
		         ps.setString(5, rec.getAddr());
		         
		         // 3. sql 전송
		         ps.executeUpdate();
		         // 4. 객체 닫기
		         ps.close();
	             con.close();
		         
		     
			 
		} catch ( Exception ex ){
			throw new MemberException("멤버 입력시 오류  : " + ex.toString() );			
		}			
	}
	
	/**********************************************************
	 * * 회원관리테이블 MEMBERTEST에서 기존의 id값과 중복되는지 확인하는 함수
	 */
	public boolean isDuplicatedId( String id ) throws MemberException
	{
		Connection con = null;
        PreparedStatement stmt = null;
		boolean flag = false;
		
		try{
			//변수 값 세팅
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
	         System.out.println("2-1. 연결 성공");
	        //sql문 작성
			String sql = "SELECT * FROM membertest WHERE id=?";
			// 2. 전송 객체 얻어 오기(+ ?에 값 지정)
	         stmt = con.prepareStatement(sql);
	        // 전송값 세팅
	        stmt.setString(1, id);
	        // 값 전송
	        ResultSet rs =stmt.executeQuery();
	        // id가 있을 경우
	        if(rs.next()) {
	        	flag=true;
	        }
	        // id가 없을 경우
	        else {
	        	flag=false;
	        }
	        // 닫기
	        con.close();
	           stmt.close();
	           rs.close(); 
			
		}catch( Exception ex ){
			throw new MemberException("중복아이디 검사시 오류  : " + ex.toString() );			
		}
			
		return flag;
	}
	/*
	public boolean checkLogin (String Id, String Password) throws MemberException
	{
	
	boolean result = false;
	Connection con = null;
    PreparedStatement ps = null;
    
    
    try {
    // 0. 연결 객체 얻어 오기

    con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
    System.out.println("2-1. 연결 성공");
    
    // 1. sql 작성(emp 테이블에 insert)
    String sql = "Insert into membertest values(?,?,?,?,?)" + "where id=? AND password=?";
    
    // 2. 전송 객체 얻어 오기(+ ?에 값 지정)
    ps = con.prepareStatement(sql);
    
    
    ps.setString(1, rec.getId());
    ps.setString(2, rec.getPassword());
    ps.setString(3, rec.getName());
    ps.setString(4, rec.getTel());
    ps.setString(5, rec.getAddr());
    
    // 3. sql 전송
    ps.executeUpdate();
    // 4. 객체 닫기
    ps.close();
    con.close();
    }
	
	return result;
	}*/
	
	public boolean checkLogin(String id, String pass) throws Exception{
	      boolean result = false;
	       Connection con = null;
	         PreparedStatement stmt = null;
	      
	      try{   
	         //변수 값 세팅
	           con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
	            System.out.println("2-2. 연결 성공");
	         //sql문 작성 
	           String sql = "select * from membertest where id=? and password=?";
	           //전송객체 얻어오기
	            stmt = con.prepareStatement(sql);
	           //전송값 세팅
	            stmt.setString(1, id);
	            stmt.setString(2, pass);
	           //값 전송 
	            ResultSet rs = stmt.executeQuery();
	            // id가 있을 경우
	           if(rs.next()) {
	              result = true;
	           //id가 없을 경우     
	           }else {
	              result = false;
	           }
	           //닫기
	           con.close();
	           stmt.close();
	           rs.close();           
	         
	      }catch( Exception ex ){
	         throw new MemberException("중복아이디 검사시 오류  : " + ex.toString() );         
	      }
	      return result;
	}
}
