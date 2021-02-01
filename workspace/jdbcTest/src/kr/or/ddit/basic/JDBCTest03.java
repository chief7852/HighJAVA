package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest03{
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JYS02", "JAVA");
			
			
			// 사용자한테 입력받기
			System.out.println("lprodid 최솟값 입력");
			int min = Integer.parseInt(sc.nextLine());
			System.out.println("lprodid 최솟값 입력");
			int max = Integer.parseInt(sc.nextLine());
			
			String Sql = "select lprod_id from lprod where lprod_id BETWEEN "+min+" and "+max;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql);
			
			while(rs.next())
			{
				
					System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
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
