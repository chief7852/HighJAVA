package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
  	UDP방식 : 비연결 지향, 신뢰성이 없다. 데이터가 순서대로 도착한다는 보장이 없다.
  			그렇지만 TCP방식보다 속도가 빠르다.
  
  	DatagramSocket객체와 DatagramPacket객체를 이용하여 통신한다.
  	- DatagramSocket : 데이터의 송수신과 관련된 작업을 수행한다.(우체부)
  	- DatagramPaccket : 주고받는 데이터와 관련된 작업을 수행한다.(소포)
  		==> 수신을 위한 생성자와 송신을 위한 생성자를 따로 제공한다.
  		
  	TCP의 경우에는 스트림 객체를 이용하여 송수신하지만
  	UDP의 경우에는 데이터 그램 객체를 이용하여 송수신한다.
  	
 */

public class UdpClient {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//수신용, 송신용 패킷 객체 변수 선언
		DatagramPacket inpacket, outpacket;
		
		//수신받은 데이터가 저장될 byte형 배열선언
		byte[] bMsg = new byte[512];
		
		try {
			// 포트 번호를 지정하지 않고 Socket객체 생성(클라이언트용)
			DatagramSocket socket = new DatagramSocket();
			
			// 접속할 곳(서버)의 주소 생성
//			InetAddress address = InetAddress.getByName("localhost");
			InetAddress address = InetAddress.getByName("192.168.0.88");
			
			while(true){
				//전송할 메세지 입력
				System.out.println("보낼 메세지 입력 : ");
				String msg = scan.nextLine();
				
				//메세지 중지여부 검사
				if("/end".equals(msg)) {
					
					break;
				}
				byte[] sendMsg = msg.getBytes();
				//전송할 패킷 객체 생성
				outpacket = new DatagramPacket(sendMsg,sendMsg.length,address,8888);
				
				
				//전송하기
				socket.send(outpacket);
				
				if("/end".equals(msg)) {
					break;
				}
				
				//==============================================================
				// 서버에서 온 데이터를 받아서 출력하기;
				
				// 수신용 패킷 객체 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//수신하기
				socket.receive(inpacket);
				
				System.out.println("서버의 응답 데이터 : " + new String(bMsg, 0, inpacket.getLength()));
				
				System.out.println();
			}// while문 끝
			
			System.out.println("통신 끝....");
		} catch (Exception e) {
			// TODO: handle exception
		}
				

	}

}
