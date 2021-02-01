package kr.or.ddit.basic.tcp;
// 서베에 접속되면 'D:/D_Other/코알라.jpg'파일을 서버로 전송한다.

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class TcpFileClient {
	public static File getFile()
	{
		JFileChooser filechooser = new JFileChooser();
		File curr = new File("D:/");
		filechooser.setCurrentDirectory(curr);
		
//		filechooser.setCurrentDirectory(dir);
		
		int result = filechooser.showSaveDialog(new JPanel());
//		int result = filechooser.showOpenDialog(new JPanel());
		
		File selectFile = null;
		if(result == JFileChooser.APPROVE_OPTION)
		{
			selectFile = filechooser.getSelectedFile();
		}
		return selectFile;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "localhost";
		Scanner sc = new Scanner(System.in);
		System.out.println(serverIp + " 서버에 접속 중입니다.");
		
		Socket socket = new Socket(serverIp,7777);
		System.out.println("서버에 연결되었습니다.");
		System.out.println();
		System.out.println("보내고싶은 파일의 주소를 입력하시오");
//		String fileName =  sc.nextLine();
		
		File file = getFile();
		
		FileInputStream fis = new FileInputStream(file);
		
		
		
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		int c;
		while((c=fis.read())!=-1)
		{
			dos.write(c);
		}
		System.out.println("전송완료");
		
		dos.close();
		socket.close();
		
	}

}
