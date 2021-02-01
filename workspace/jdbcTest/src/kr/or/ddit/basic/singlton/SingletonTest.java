package kr.or.ddit.basic.singlton;

public class SingletonTest {

	public static void main(String[] args) {
		//컴파일러 에러 이유: 외부에서 객체생성(new)못하게 private로 막았기때문
//		MySingleton test1 = new MySingleton();	--오류
		
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test2 : "+test2);
		System.out.println("test3 : "+test3);
		
		System.out.println();
		System.out.println(test2.equals(test3));	//true	참조값이같음
		System.out.println(test2 == test3);			//true
		
		test2.displayTest();  						//싱글톤 클래스의 메서드 호출입니다.
	}

}
