package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다
//		lprod_id가 큰 자료들을 출력하시오.

public class JdbcTest02 {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("dditbasic.csqutft2bzky.ap-northeast-2.rds.amazonaws.com", "DDIT", "JAVA");
			
			
			// 사용자한테 입력받기
			System.out.println("lprodid 값 입력");
			int id = Integer.parseInt(sc.nextLine());
			
			String Sql = "select lprod_id from lprod";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql);
			
			while(rs.next())
			{
				if(rs.getInt("lprod_id") > id)
				{
					System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				}
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//5. 자원 반납하기
			if(rs!=null) try { rs.close();} catch(SQLException e) {};
			if(rs!=null) try { rs.close();} catch(SQLException e) {};
			if(rs!=null) try { rs.close();} catch(SQLException e) {};
		}
		
	}

}
