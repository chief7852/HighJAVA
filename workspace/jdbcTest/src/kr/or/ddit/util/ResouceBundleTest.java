package kr.or.ddit.util;

import java.util.ResourceBundle;

/*
  	ResourceBundle객체 ==> 파일의 확장자가 properties인 파일의 내용을 읽어
  						와 key값과 value값을 분리하여 분리된 정보를 갖고있는 객체
  	
  	==> 읽어올 파일의 확장자는 반드시 properties이여야 하고
  		파일 내용은 'key값 = value값' 형태로 되어 있어야 한다.
 */
public class ResouceBundleTest {

	public static void main(String[] args) {
		// ResourceBundle객체를 이용하여 파일내용 읽어오기
		
		// ResourceBundle객체 생성하기
		//			==> 읽어올 파일을 지정할 때 '파일명' 만 지정하고
		//				확장자는 지정하지 않는다.
		//				(이유 : 확장자는 항상 properties이기 때문에...)
		//			==> 파일의 경로는 'Source folder'가 현재 폴더로 보고 설정한다.
		ResourceBundle bundle=ResourceBundle.getBundle("dbinfo");
		
		
		//읽어온 파일 내용 출력하기
		System.out.println("driver : " + bundle.getString("driver"));
		System.out.println("url : " + bundle.getString("url"));
		System.out.println("user : " + bundle.getString("user"));
		System.out.println("pass : " + bundle.getString("pass"));

	}

}
