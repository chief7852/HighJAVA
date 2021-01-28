package kr.or.ddit.mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

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
public class MemberController {
	// Controller는 Service객체를 사용하기 때문에
	// Service객체가 저장될 변수가 필요하다.
	private IMemberService service;
	
	public MemberController() {
		service = new MemberServiceImpl();
	}
	
	private static Scanner sc = new Scanner(System.in);	
	
	static MemberController hc = new MemberController();
	
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
			case "0" :
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
		// Service로 보낼 MemberVO객체를 생성하고
		// 입력한 자료를 셋팅한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_name(userName);
		memVo.setMem_tel(userTel);
		memVo.setMem_addr(userAddr);
		
		
		//service의 insert하는 메서드 호출하기
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");			
		}
	}

	
	void removeDB() {
		

			System.out.println("지우려는 id 값");
			System.out.print(">");
			String mem_id = sc.nextLine();
			int cnt = service.deleteMember(mem_id);
	
			if(cnt == 0)
			{
				System.out.println("등록실패");
				
			}
			else 
			{
				System.out.println(mem_id+"(의)정보가 삭제되었습니다.");
				
			}
			

	}
	
	void alterDB() {
		
		System.out.println("수정할 자료의 아이디를 입력하십시오");
		String userId = sc.nextLine();
	
		int cnt = service.getMemberCount(userId);
		
			if(cnt >0)
			{
				System.out.println("이름 : ");
				String userName = sc.nextLine();
				System.out.println("전화번호 : ");
				String userTel = sc.nextLine();		
				System.out.println("주소 : ");
				String userAddr = sc.nextLine();
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(userId);
				memVo.setMem_name(userName);
				memVo.setMem_tel(userTel);
				memVo.setMem_addr(userAddr);
				cnt = service.updateMember(memVo);
				if(cnt == 0) {
				 System.out.println("등록실패");
				}else {
					System.out.println("수정완료");
				}
				
			}else {System.out.println(userId+"라는 아이디가 존재하지 않습니다.");}
			
		
	}
	
	private String alter2(String userId) {
		System.out.println("수정할 정보를 고르십시오");
		System.out.println("1.이름 2.주소 3.전화번호");
		switch(sc.nextLine())
		{
		case "1":System.out.print("변경할 이름 입력");
				 String userName = sc.nextLine();
				 return "update mymember set mem_name = '"+userName+"' where mem_id ='"+userId+"'";
		case "2":System.out.print("변경할 전화번호");
				 String userTel = sc.nextLine();
				 return "update mymember set mem_tel = '"+userTel+"' where mem_id ='"+userId+"'";
		case "3":System.out.print("변경할 주소");
				 String userAddr = sc.nextLine();
				 return "update mymember set mem_name = '"+userAddr+"' where mem_id ='"+userId+"'";
			default : break;
		}
		return "";
	}
	void printDBAll() {
			System.out.println("아이디\t이름\t전화번호\t주소");
			List<MemberVO> list =service.getAllMember();
			if(list ==null || list.size() == 0)
			{
				System.out.println(" 등록된 회원이 하나도 없습니다..");
			}else {
				for(MemberVO mem : list)
				{
					System.out.printf("%s\t%s\t%s\t%s\n",mem.getMem_id(),mem.getMem_name(),mem.getMem_tel(),mem.getMem_addr());
				}
			}
			
	}
}
