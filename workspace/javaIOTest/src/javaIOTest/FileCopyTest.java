package javaIOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 문제)
 	'd:/d_other'폴더에 있는 '코알라.jpg'파일을 
 	'd:/d_other/연습용'폴더에 '복사본-코알라.jpg'파일로 복사하는
 	프로그램을 작성하시오.
 */

public class FileCopyTest {

	public static void main(String[] args) {
		
		try {
			
			File file2 = new File("d:/d_other/연습용/코알라.jpg");
			file2.createNewFile();
				
			FileOutputStream fos = new FileOutputStream(file2);
			
			File file = new File("D:\\D_Other\\Koala.jpg");

			
			FileInputStream fin = new FileInputStream(file);
			
			int c;
			while((c=fin.read()) != -1)
			{
				fos.write(c);
			}
			fin.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		File file2 = new File("D:/D_Other/연습용");
		
	}

}
