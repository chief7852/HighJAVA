package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class A_TcpFileClient {
	private Socket socket;
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	private DataOutputStream dos;
	
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
	
	//클라이언트 프로그램의 시작 메서드
	public void clientStart() {
		// 전송할 파일을 이용한 File객체 생성
		File file = getFile();
		String fileName = file.getName();
		if(!file.exists()) {//전송할 파일이 있는지 검사
			System.out.println(fileName + " 파일이 없습니다. ");
			return;
		}
		
		try {
			socket = new Socket("localhost",7777);
			System.out.println("파일전송 시작...");
			OutputStream out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			
			//서버에 접속이 성공하면 첫번째로 파일 이름을 전송한다.
			dos.writeUTF(fileName);
			
			//파일 읽기용 InputStream객체 생성
			bis = new BufferedInputStream(new FileInputStream(file));
			
			//서버로 전송할 OutputStream객체 생성
			bos = new BufferedOutputStream(out);
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			// 파일의 내용을 읽어와 소켓을 통해서 전송한다.
			while((len=bis.read(temp))>0)
			{
				bos.write(temp,0,len);
			}
			bos.flush();
			System.out.println("파일 전송완료...");
			
		} catch (Exception e) {
			System.out.println("파일전송실패" + e.getLocalizedMessage());
		} finally {
			if(dos!=null) try {dos.close();}catch(IOException e) {}
			if(bos!=null) try {bos.close();}catch(IOException e) {}
			if(bis!=null) try {bis.close();}catch(IOException e) {}
			if(socket!=null) try {socket.close();}catch(IOException e) {}
		}
	}
	
	public static void main(String[] args) {
		new A_TcpFileClient().clientStart();

	}

}
