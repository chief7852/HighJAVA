package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	- 회원을 관리하는 프로그램을 작성하시오.
 	(오라클 DB의 MyMember테이블 이용)
 	
 	- 아래 메뉴의 기능을 모두 구현하시오(CRUD 구현하기 연습)
 	주소,아이디,이름,전화번호
 	메뉴예시
 	-- 작업선택--
 	1. 자료 추가
 	2. 자료삭제
 	3. 자료수정
 	4. 전체 자료 출력
 	0. 작업 끝.
 	-----------
 	작업선택 >
 */
public class JdbcTest07 {
	private static Connection conn = DBUtil.getConnection();
	private static PreparedStatement prsm = null;
	private static Scanner sc = new Scanner(System.in);	
	private static ResultSet rs = null;
	static JdbcTest07 hc = new JdbcTest07();
	
	public static void main(String[] args) {
		
		
		
		while(true)
		{
			hc.mainView();
			switch(sc.nextLine())
			{
			case "1" :hc.addDB();
				break;
			case "2" :hc.removeDB();
				break;
			case "3" :hc.alterDB();
				break;
			case "4" :hc.printDBAll();
				break;
			case "0" :try {prsm.close();} catch(Exception e) {};
					  try {conn.close();} catch(Exception e) {};
			          try {rs.close();} catch(Exception e) {};
			          System.out.println("프로그램 종료");
			          System.exit(0);
				
			}
		}

	}

	
	void mainView() {
		System.out.println("--작업선택--");
		System.out.println("1. 자료추가");
		System.out.println("2. 자료삭제");
		System.out.println("3. 자료수정");
		System.out.println("4. 전체자료 출력");
		System.out.println("0. 작업 끝.");
		System.out.println("--------------");
		System.out.print("작업선택 >");
	}
	
	void addDB() {
		System.out.println("아이디 : ");
		String userId = sc.nextLine();
		System.out.println("이름 : ");
		String userName = sc.nextLine();
		System.out.println("전화번호 : ");
		String userTel = sc.nextLine();		
		System.out.println("주소 : ");
		String userAddr = sc.nextLine();
		hc.addcheck(userId, userName, userTel, userAddr);
		
		
	}
	void addcheck(String userId,String userName,String userTel,String userAddr) {
		try {
			String sql = "insert into mymember(mem_id,mem_name,mem_tel,mem_addr)"
					+ " values (?,?,?,?)";
			prsm = conn.prepareStatement(sql);
			prsm.setString(1, userId);
			prsm.setString(2, userName);
			prsm.setString(3, userTel);
			prsm.setString(4, userAddr);
			int cnt = prsm.executeUpdate();
			if(cnt == 0)
			{
				System.out.println("등록실패");
				
			}
			else 
			{
				System.out.println(userId+"(의)정보가 저장되었습니다.");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {
			try {prsm.close();} catch(Exception e) {};
//			try {conn.close();} catch(Exception e) {};
			try {rs.close();} catch(Exception e) {};
		}
	}
	
	void removeDB() {
		try {
			System.out.println("지우려는 id 값");
			System.out.print(">");
			String mem_id = sc.nextLine();
			String sql = "delete from mymember where mem_id = ?";
			prsm = conn.prepareStatement(sql);
			prsm.setString(1, mem_id);
			int cnt = prsm.executeUpdate();
			if(cnt == 0)
			{
				System.out.println("등록실패");
				
			}
			else 
			{
				System.out.println(mem_id+"(의)정보가 삭제되었습니다.");
				
			}
			
		} catch (Exception e) {
			System.out.println("아이디가 존재하지 않습니다.");
			
			
		}finally {
			try {prsm.close();} catch(Exception e) {};
//			try {conn.close();} catch(Exception e) {};
			try {rs.close();} catch(Exception e) {};
		}
	}
	
	void alterDB() {
		System.out.println("수정할 자료의 아이디를 입력하십시오");
		String userId = sc.nextLine();
		try {
			String sql = "select mem_id from mymember where mem_id = "+userId;
			prsm = conn.prepareStatement(sql);
			rs = prsm.executeQuery();
			String result ="";
			while(rs.next())
			{
				result = (String) rs.getObject("mem_id");
			}
			if(result.equals(userId))
			{
				System.out.print("변경할 이름 입력");
				String userName = sc.nextLine();
				System.out.print("변경할 전화번호");
				String userTel = sc.nextLine();
				System.out.print("변경할 주소");
				String userAddr = sc.nextLine();
				sql = "update mymember set mem_name = ? ,MEM_TEL=?,"
						+ " MEM_ADDR=? where mem_id = ?";
				prsm = conn.prepareStatement(sql);
				prsm.setString(1, userName);
				prsm.setString(2, userTel);
				prsm.setString(3, userAddr);
				prsm.setString(4, userId);
				int cnt = prsm.executeUpdate();
				if(cnt == 0) {
				 System.out.println("등록실패");
				}else {
					System.out.println("수정완료");
				}
				
			}else {System.out.println(userId+"라는 아이디가 존재하지 않습니다.");}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {prsm.close();} catch(Exception e) {};
//			try {conn.close();} catch(Exception e) {};
			try {rs.close();} catch(Exception e) {};
		}
		
		
	}
	
	void printDBAll() {
		try {
			String sql = "select * from mymember";
			prsm = conn.prepareStatement(sql);
			rs = prsm.executeQuery();
			System.out.println("아이디\t이름\t전화번호\t주소");
			while(rs.next())
			{
				String id = rs.getString("mem_id");
				String name = rs.getString("mem_name");
				String tel = rs.getString("mem_tel");
				String addr = rs.getString("mem_addr");
				System.out.println(id+"\t"+name+"\t"+tel+"\t"+addr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {prsm.close();} catch(Exception e) {};
//			try {conn.close();} catch(Exception e) {};
			try {rs.close();} catch(Exception e) {};
		}
	}
}
