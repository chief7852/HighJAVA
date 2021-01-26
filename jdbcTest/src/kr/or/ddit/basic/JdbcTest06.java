package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	LPROD테이블에 새로운 데이터를 추가하시오.
 	조건 ) lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 		  lprod_id는 현재의 lprod_id중 제일 큰값 보다 1 증가된 값으로 한다.
 		  그리고 , 입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다
 */

public class JdbcTest06 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement prpsmt = null;
		Statement stmt=null;
		ResultSet rs =null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DBUtil.getConnection();
			String lprod_Gu ="";
			String lprod_Name ="";
			String sql ="";
			boolean y = true;
			
			while(y)
			{
			System.out.println("상품 번호를 입력하시오");
			lprod_Gu = sc.nextLine();

			System.out.println("상품 이름을 입력하시오");
			lprod_Name = sc.nextLine();
			
			sql = "select lprod_gu, lprod_nm from lprod where lprod_gu = '"+lprod_Gu+"'";
			
			stmt = conn.createStatement();
			
			rs =stmt.executeQuery(sql);
			
			String temp = "";
			while(rs.next()) 
				{
					temp = rs.getString("lprod_gu"); 			
				}
				
				if(temp.equals(lprod_Gu)) {System.out.println("이미 존재하는 상품번호입니다.");}
				else { break;}
			}
			
			sql = "insert into lprod(lprod_gu,lprod_nm,lprod_id) values (?,?,(select max(lprod_id)+1 from lprod))";
			
			prpsmt = conn.prepareStatement(sql);
			prpsmt.setString(1, lprod_Gu);
			prpsmt.setString(2, lprod_Name);
			
			int cnt = prpsmt.executeUpdate();
			if(cnt == 0) {
			System.out.println("등록실패");
			}else {
			System.out.println("상품번호 : " + lprod_Gu);
			System.out.println("상품명 : " + lprod_Name);
			System.out.println("저장되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();;
		}finally {
			try {prpsmt.close();} catch(Exception e) {};
			try {conn.close();} catch(Exception e) {};
			try {stmt.close();} catch(Exception e) {};
			try {rs.close();} catch(Exception e) {};
		}

	}

}
