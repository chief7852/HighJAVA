package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpServer {
	public static void main(String[] args) {
		
	
	try {
		// 통신할 포트번호를 지정하여 소켓을 생성한다.
		DatagramSocket socket = new DatagramSocket(8888);

		// 수신용 패킷 변수와 송신용 패킷 변수 선언
		DatagramPacket inpacket, outPacket;

		System.out.println("서버 실행 중...");

		while (true) {
			// 데이터가 저장될 byte형 배열을 선언한다.
			byte[] bMsg = new byte[512];
			
			//수신용 패킷 객체 생성
			//	==> 데이터가 저장될 byte형 배열, 배열의 길이를 인수값으로 주어서 생성한다.
			inpacket = new DatagramPacket(bMsg, bMsg.length);
			
			// 데이터를 수신한다.
			// 이 메서드는 데이터가 올 때까지 기다린다.
			// 수신된 데이터의 패킷정보는 지정한 패킷변수에 저장된다.
			socket.receive(inpacket);
			
			// 수신 받은 패킷에서 상대방의 주소, 포트번호등을 알 수 있다.
			InetAddress address = inpacket.getAddress();
			int port = inpacket.getPort();
			
			System.out.println("상대방의 IP정보 : " + address);
			System.out.println("상대방의 port정보 : " + port);
			
			//상대방이 보낸 메시지(데이터) 출력하기
			//inpacket.getLength() ==> 실제 읽어온 데이터의 길이
			//inpacket.getData() ==> 실제읽어온 데이터를 byte배열로 반환한다.
			//					==> 실제 읽어온 데이터는 수신용 패킷을 생성할때 사용한 byte배열에도 저장된다.
			
			//방법1
			String msg = new String(inpacket.getData(), 0 , inpacket.getLength());
			//방법2
			String msg2 = new String(bMsg, 0, inpacket.getLength());
			
			System.out.println("상대방이 보낸 메시지1 : " + msg);
			System.out.println("상대방이 보낸 메시지2 : " + msg2);
			System.out.println();
			
			if("/end".equals(msg)) {
				break;
			}
			
			//=-----------------------------------------------------------=
			//상대방에게 메세지 보내기(수신받은 메세지를 그대로 송신)
			
			//송신할 메시지를 byte배열로 변환한다.
			byte[] sendMsg = msg.getBytes();
			
			// 수신용 패킷객체 생성
			//		==> 전송할 데이터가 저장된 byte배열, 전송할 자료의 길이(배열의 길이)
			//			상대방 주소정보, 상대방 포트번호를 인수로 지정하여 생성한다.
			outPacket = new DatagramPacket(sendMsg, sendMsg.length, address,port);
			
			//송신하기 ==>send()메서드 사용
			socket.send(outPacket);
			System.out.println("송신완료....");
			
			
			
			
			
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
 }
}
