package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//이 클래스는 소켓을 이용해서 메시지를 보내는 역할을 담당하는 클래스 이다.

public class Sender extends Thread{
	//1.처음에는 소켓이 저장될 변수가 필요
	private Socket socket;
	//2.데이터를 보낼 객체
	private DataOutputStream dos;
	private Scanner scan;
	private String name;		// 접속한 사람의 이름이 저장될 변수
	
	//3.생성자 만들기
	public Sender(Socket socket)
	{
		this.socket = socket;
		scan = new Scanner(System.in);
		
		//이름받아내기
		System.out.println("이름 입력>> ");
		name = scan.nextLine();
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		while(dos!=null) {
			try {
				dos.writeUTF(name + " : " + scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
