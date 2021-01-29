package consoleBoard_Controler;

import java.util.List;
import java.util.Scanner;

import consoleBoard_VO.MemberVO;
import consoleBoard_service.consoleBoard_Service;
import consoleBoard_service.consoleBoard_ServiceImpl;

public class ConsoleBoard_Controler {

	private consoleBoard_Service service;
	
	public ConsoleBoard_Controler() {
		service = new consoleBoard_ServiceImpl();
	}
	
	private static Scanner sc = new Scanner(System.in);	
	
	static ConsoleBoard_Controler cn = new ConsoleBoard_Controler();
	public static void main(String[] args) {
		
		while(true)
		{
			cn.mainView();
			switch(Integer.parseInt(sc.nextLine()))
			{
			case 1:cn.insertBoard();break;
			case 2:cn.detailBoard();break;
			case 3:
			case 0:System.out.println("프로그램 종료합니다");System.exit(0);
			}
		}

	}
	void mainView() {
		System.out.println("-------------------------------------------------------------\r\n"
				+ " No	        제 목            작성자 	조회수   \r\n"
				+ "-------------------------------------------------------------");
		if(service.board_call().size() == 0)
		{
			System.out.println(" No data ");
		}else
		{
			List<MemberVO> list =service.board_call();
			for(MemberVO vo : list)
			{
				System.out.printf("%s	        %s               %s 	  %s   \r\n",
						vo.getBoard_no(),vo.getTitle(),vo.getWriter(),vo.getCnt());
			}
		}
	
		System.out.print("-------------------------------------------------------------\r\n"
				+ "메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝\r\n"
				+ "작업선택 >>");
	
	}
	
	void insertBoard() {
		
		
		System.out.println("새글 작성하기\r\n"
				+ "-----------------------------------");
		System.out.print("- 제 목 : ");
		String title = sc.nextLine();
		System.out.print("- 작성자 : ");
		String writer = sc.nextLine();
		System.out.print("- 내 용 : ");
		String content = sc.nextLine();
		MemberVO vo = new MemberVO(title, content,writer);
		
		boolean tf =service.board_write(vo);
		
		if(tf == true)
		{
			System.out.println("작성 완료");
		}else
		{
			System.out.println("작성 실패");
		}
	}
	
	void detailBoard() {
		System.out.println("보기를 원하는 게시물 번호 입력 >>");
		int no = Integer.parseInt(sc.nextLine());
		MemberVO vo = service.board_detail(no);
		
		System.out.println(no+"번글 내용\r\n"
				+ "-----------------------------------");
		System.out.println("- 제 목 : "+vo.getTitle());
		System.out.println("- 작성자 : "+vo.getWriter());
		System.out.println("- 내 용 : "+vo.getContent());
		System.out.println("- 작성일 : "+vo.getDate());
		System.out.println("- 조회수 : "+vo.getCnt());
		System.out.println("-----------------------------------");
		System.out.print("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기\r\n"
				+ "작업선택 >>");
		switch(Integer.parseInt(sc.nextLine()))
		{
		case 1:cn.alterBoard(no);break;
		case 2:cn.deleteBoard(no);break;
		case 3:	return;
		default:return;
		}
		
	}
	
	void alterBoard(int board_no) {
		System.out.println();
	}
	void deleteBoard(int board_no) {
		
	}

}
