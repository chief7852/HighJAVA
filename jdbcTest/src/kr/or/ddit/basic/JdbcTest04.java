package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 	문제 ) 사용자로부터 시, 군, 구 중 한가지를 입력받아
 		  DB의 Member테이블에서 회원의 주소에 입력한 값이 포함되는 데이터를 모두 출력하십시오 (아이디 이름 우편번호 주소1 주소2)
 */
public class JdbcTest04 {
	private static Connection conn = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JYS02", "JAVA");
			
			System.out.println("시,군,구 중 아무곳이나 입력하시오");
			String city = sc.nextLine();
			
			String sql = "select mem_id,mem_name,mem_zip,mem_add1,mem_add2"
					+ " from member where mem_add1 like '"+city+"%'"
					+" or mem_add2 like '"+city+"%'";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("아이디 : "+rs.getObject("mem_id"));
				System.out.println("이름 : "+rs.getObject("mem_name"));
				System.out.println("우편번호 : "+rs.getObject("mem_zip"));
				System.out.println("주소 : "+rs.getObject("mem_add1")+rs.getObject("mem_add2"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
