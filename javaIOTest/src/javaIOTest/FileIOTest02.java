package javaIOTest;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("d:/d_other/out.txt");
			for(char ch ='A'; ch <='Z';ch++)
			{
				//ch변수의 값을 파일로 출력한다.
				fos.write(ch);
			}
			System.out.println("작업완료!!");
			fos.close();
			//================================================
			// 위에서 저장한 데이터를 읽어와 화면에 출력하시오.
			File file = new File("d:/d_other/out.txt");
			FileInputStream in = new FileInputStream(file);
			
			int temp;
			while((temp=in.read()) != -1)
			{
				System.out.print((char)temp);
			}
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
