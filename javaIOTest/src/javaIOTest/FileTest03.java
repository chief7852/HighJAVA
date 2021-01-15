package javaIOTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		while(true)
//		{
//		FileTest03 test = new FileTest03();
//		Scanner s = new Scanner(System.in);
//		String fi = s.nextLine();
//		if(fi.equals("end")) {break;}
//		File file = new File(fi);
//		
//		test.displayFileList(file);
//		System.out.println("==================================");
//		System.out.println();
//		}
		FileTest03 test = new FileTest03();
		File file = test.getDir();
		if(file!=null)
			test.displayFileList(file);
	}
	public File getDir()
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
	
	// 디렉토리를 매개변수로 받아서 해당 디렉토리에 있는
	// 모든 파일과 디렉토리 목록을 출력하는 메서드
	public void displayFileList(File dir) {
		if(!dir.isDirectory())
		{
			System.out.println("디렉토리(폴더)만 가능합니다.");
			return;
		}
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
	
		// 해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구한다.
		File[] files = dir.listFiles();
//		String[] strfiles = dir.list();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:MM");
		
		//가져온 파일과 디렉토리 목록 개수만큼 반복
		
		for(int i=0; i < files.length; i++)
		{
			String fileName = files[i].getName();
			
			// 파일의 속성(읽기,쓰기, 히든, 디렉토리 구분)
			String attr = ""; 		
			String size = "";	// 파일 크기
			
			if(files[i].isDirectory())
			{
				attr = "<DIR>";
			}else
			{
				size = files[i].length() + "";
				
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			
			System.out.printf("%s %5s %12s %s\n",sdf.format(new Date(files[i].lastModified())),
								attr,size, fileName);
		}
	}
	
}
