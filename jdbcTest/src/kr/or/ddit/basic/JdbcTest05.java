package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt =null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JYS02","JAVA");
			
			System.out.println("계좌번호 정보 추가하기");
			System.out.println("계좌번호 : ");
			String bankNo = scan.next();
			
			System.out.println("은 행 명 : ");
			String bankName = scan.next();
			
			System.out.println("예금주명 : ");
			String userName = scan.next();	
			
			
			
			//방법 1. Statement객체 사용
//			String sql = "insert into bankinfo(bank_no, bank_name, bank_user_name, bank_date) values('"+bankNo+"','"+bankName+"'"
//					+ ",'"+userName+"', sysdate)";
//			stmt =conn.createStatement();
//			
//			// SQL 문이 select문일 때 실행한느 메서드는 executeQuery()메서드를 사용하고
//			
//			// SQL문 insert, update ,delete등과 같이 select문이 아닐경우 
//			// executeUpdate()메서드를 사용하여 실행한다.
//			// executeIpdate()메서드의 반환값은 작업에 성공한 레코드 수 이다
//			
//			int cnt = stmt.executeUpdate(sql);
			
			
			//방법2 prpareStatement객체 생성하기
			// ===> 실행할 SQL문을 인수값으로 지정하여 생성한다.
			String sql = "insert into bankinfo(bank_no, bank_name, bank_user_name, bank_date) values(?,?,?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			
			//SQL문의 물음표(?) 자리에 들어갈 데이터를 셋팅한다.
			// 형식) pstmt.set자료형 이름(물음표번호, 데이터);
			// 			==> 물음표번호는 1번부터 시작한다.
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, userName);
			
			// 데이터의 셋팅이 완료되면 SQL문을 실행한다.
			int cnt = pstmt.executeUpdate();
			
			System.out.println("SQL : " + sql);
			

//			
			System.out.println("반환값 : " +cnt);
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) try {stmt.close();}catch(Exception e) {};
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {};
			if(conn!=null) try {conn.close();}catch(Exception e) {};
		}

	}

}
