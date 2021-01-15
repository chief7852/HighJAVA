package javaIOTest;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		// File객체 만들기 연습
		
		/* 1) new File(String 파일 또는 경로);
				==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의
					구분문자는 '/'를 사용하거나 '\'를 사용할 수 있다.
		*/

		
//		File file1 = new File("d:/D_Other/text.txt");	//구분문자로 '/'사용
		File file1 = new File("d:\\D_Other\\text.txt");	//구분문자로 '\\'사용
		
		System.out.println("파일명 : " + file1.getName());
		System.out.println("디렉터리인가 : " + file1.isDirectory());
		System.out.println("파일인가 : " + file1.isFile());
		System.out.println("==================================");
		File file2 = new File("d:/D_Other");
		System.out.println("파일명 : " + file2.getName());
		System.out.println("디렉터리인가 : " + file2.isDirectory());
		System.out.println("파일인가 : " + file2.isFile());
		System.out.println("==================================");
		
		/*
		   2) new File(File parent, String child)
		   		==> 'parent' 디렉토리 안에 있는 'child'파일을 갖는다.
		 */
		File file3 = new File(file2, "text.txt");
		System.out.println("파일명 : " + file3.getName());
		System.out.println("디렉터리인가 : " + file3.isDirectory());
		System.out.println("파일인가 : " + file3.isFile());
		System.out.println("==================================");

		
		/*
		 	3) new File(String parent, String child)
		 			==> 'parent' 디렉토리 안에 있는 'child'파일을 갖는다.
		 */
		File file4 = new File("d:/d_othe", "text.txt");
		System.out.println("파일명 : " + file2.getName());
		System.out.println("디렉터리인가 : " + file2.isDirectory());
		System.out.println("파일인가 : " + file2.isFile());
		
		System.out.println("==================================");

		
		File file5 = new File("d:/d_other/연습용");
		System.out.println(file5.getName() + " 의 존재 여부 : "+ file5.exists());
		
		/*
		 	디렉토리(폴더) 만들기
		 	- mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		 		==>반환값 : 만들기 성공(true), 실패(false)
		 		==>중간부분의 경로가 모두 만들어져 있어야 마지막 위치의
		 		   디렉토리를 만들수 있다.
		 		   
		 	- mkdirs() ==> 중간부분의 경로가 없으면 중간 부분의 경로도
		 				   같이 만들어준다.
		 */
		if(!file5.exists())
		{
			if(file5.mkdir())
			{
				System.out.println(file5.getName() + " 만들기 성공");
			}else
			{
				System.out.println(file5.getName() + " 만들기 실패");
			}
		}
		System.out.println("==================================");
		
		File file6 = new File("d:/d_Other/test/java/src");
		if(!file6.exists())
		{
			if(file6.mkdirs())
			{
				System.out.println(file6.getName()+"만들기 성공");
			}else
			{
				System.out.println(file6.getName() + " 만들기 실패");
			}

		}
	}

}
