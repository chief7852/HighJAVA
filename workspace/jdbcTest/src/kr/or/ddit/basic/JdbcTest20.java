package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class JdbcTest20 {

	Scanner scan = new Scanner(System.in);
	   public static void main(String[] args) {
	      new JdbcTest20().memberStart();
	   }
	   
	   public void memberStart(){
	      while(true){
	         int choice = displayMenu();
	         switch(choice){
	         case 1:      insertMember();// 추가
	            break;
	         case 2:      // 삭제
	            break;
	         case 3:      // 수정
	            break;
	         case 4:      // 전체 출력
	            break;
	         case 0:      // 작업 끝.
	            System.out.println("작업을 마칩니다.");
	            break;
	         default:
	            System.out.println("번호를 잘못 입력했습니다.");
	            System.out.println("다시 입력하세요.");
	         }
	      }
	   }
	   // 메뉴 출력 및 작업번호를 입력 받아 반환하는 메서드
	   private int displayMenu(){
	      System.out.println();
	      System.out.println(" -- 작 업 선 택 -- ");
	      System.out.println(" 1. 자 료 추 가");
	      System.out.println(" 2. 자 료 추 가");
	      System.out.println(" 3. 자 료 수 정");
	      System.out.println(" 4. 전체 자료 출력");
	      System.out.println(" 0. 작 업 끝 ...");
	      System.out.println("---------------------");
	      System.out.print("작업 선택 >> ");
	      int num = scan.nextInt();
	      return num;
	   }
	   // 전체 회원 정보를 출력하는 메서드
	   private void displayMember(){
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      System.out.println();
	      System.out.println("-----------------------------------------");
	      System.out.println(" ID      이름       전화번호       주소");
	      System.out.println("-----------------------------------------");
	      
	      try {
	         conn = DBUtil.getConnection();
	         String sql = "select * from mymember";
	         stmt = conn.createStatement();
	         
	         rs = stmt.executeQuery(sql);
	         
	         while(rs.next()){
	            String memId = rs.getString("mem_id");
	            String memName = rs.getString("mem_name");
	            String memTel = rs.getString("mem_tel");
	            String memAddr = rs.getString("mem_addr");
	            System.out.println(memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);
	         }
	         System.out.println("-----------------------------------------");
	         System.out.println("출력 끝....");
	               
	      } catch (SQLException e) {
	         // TODO: handle exception
	      } finally{
	         if(stmt!= null) try{ stmt.close();}catch(SQLException e){};
	         if(conn!= null) try{ conn.close();}catch(SQLException e){};
	      }
	   }
	   
	   // 회원 정보를 추가하는 메서드
	   private void insertMember(){
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      System.out.println();
	      System.out.println("추가할 회원 정보를 입력하세요.");
	      
	      int count = 0;
	      String memId = "";  // 입력한 회원ID가 저장될 변수
	      do{
	         System.out.print("회원ID >> ");
	         memId = scan.next();
	         
	         count = getMemberCound(memId);
	         if(count>0){
	            System.out.println("회원ID가 " + memId+"인 회원은 이미 존재합니다.");
	            System.out.println("다른 ID로 다시 입력하세요.");
	            System.out.println();
	         }
	         
	      }while(count > 0);
	      
	      System.out.print("회원이름 >> ");
	      String memName = scan.next();
	      
	      System.out.print("전화번호 >> ");
	      String memTel = scan.next();
	      
	      scan.nextLine(); // 입력 버퍼 비우기
	      System.out.print("주 소 >> ");
	      String memAddr = scan.nextLine();
	      
	      try {
	         conn = DBUtil.getConnection();
	         
	         String sql = "insert into mymember "
	               + " (mem_id, mem_name, mem_tel, mem_addr) "
	               + " values(?, ?, ?, ?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memId);
	         pstmt.setString(2, memName);
	         pstmt.setString(3, memTel);
	         pstmt.setString(4, memAddr);
	         
	         int cnt = pstmt.executeUpdate();
	         
	         if(cnt >0)System.out.println(memId + "회원 추가 성공!");
	         else System.out.println(memId + "회원 추가 실패~!");
	         
	      } catch (SQLException e) {
	         // TODO: handle exception
	      } finally{
	         if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
	      }
	            
	   }
	   
	   // 회원ID를 인수로 받아서 해당 회원 ID의 개수를 반환하는 메서드
	   private int getMemberCound(String memId){
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      int count = 0; // 회원ID개수가 저장될 변수
	      
	      try {
	         conn = DBUtil.getConnection();
	         String sql = "select count(*) cnt from mymember WHERE mem_id = ?";
	            pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memId);
	         rs = pstmt.executeQuery();
	         if(rs.next()){
	            count = rs.getInt("cnt");
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally{
	         if(rs != null){try {rs.close();   } catch (Exception e2) { }};
	         if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
	      }
	      return count;
	   }


}
