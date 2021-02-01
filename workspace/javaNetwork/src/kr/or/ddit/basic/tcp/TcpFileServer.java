package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.OutputStream;

// 클라이언트가 보낸파일을 받아서 'D:/D_Other/data'폴더에
// 보낸 파일과 같은 이름으로 저장한다.
public class TcpFileServer {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 접속을 기다립니다.");
		
		Socket socket = server.accept();
		System.out.println("클라이언트와 연결이 되었습니다.");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);	
		System.out.println("상대방이 파일을 보내려고합니다 받으시겠습니까?");
		String agr = sc.nextLine();
		
		if(agr.equals("y")) {
		File file = new File("D:/D_Other/data/koala.jpg");
		FileOutputStream fos = new FileOutputStream(file);
		file.createNewFile();
		int c;
		while((c=dis.read()) != -1)
		{
			fos.write(c);
		}
		}else {
			OutputStream os =(OutputStream) socket.getOutputStream();
		}
	}

}
