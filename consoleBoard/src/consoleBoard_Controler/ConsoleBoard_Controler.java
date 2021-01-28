package consoleBoard_Controler;

import java.util.Scanner;

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
		cn.mainView();
		while(true)
		{
			
		}

	}
	void mainView() {
		System.out.println("-------------------------------------------------------------\r\n"
				+ " No	        제 목            작성자 	조회수   \r\n"
				+ "-------------------------------------------------------------");
		service.board_call();
	
		System.out.println("-------------------------------------------------------------\r\n"
				+ "메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝\r\n"
				+ "작업선택 >>");
	
	}

}
