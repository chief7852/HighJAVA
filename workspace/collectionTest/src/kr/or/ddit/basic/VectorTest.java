package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest 
{

	public static void main(String[] args) 
	{
		// 객체 생성
		Vector v1 = new Vector();
		
		System.out.println("처음크기 : " + v1.size());
		
		// 데이터 추가 : add(추가할 데이터)
		// 반환값 : 추가성공(true), 실패(false)
		v1.add("aaa");
		v1.add(new Integer(111));		//숫자형은 형변환후에 사용해야한다.
		v1.add(123);	// ==> 오토박싱(기본자료형 ==> 랩퍼클래스형으로 자동변환)
						// ==> 오토언박싱 ( 랩퍼클래스형 ==> 기본자료형으로 자동변환)
		v1.add('a');
		v1.add(3.14);
		boolean chk = v1.add(true);
		
		System.out.println("현재 크기 : " + v1.size());
		System.out.println("반환값 : " + chk);
		
		//데이터 추가 : addElement(추가할 데이터)
		// ==> 이전 버전의 프로그램에서도 사용가능하도록 하기위해 남아있는 메서드
		v1.addElement("CCC");
		
		System.out.println("v1 ==> " + v1.toString());
		System.out.println("v1 ==> " + v1);				//toString 생략가능
		
		//데이터 추가 : add(index, 추가할 데이터)
		// ==> index번째에 '추가할데이터'를 끼워넣는다. (index는 0부터 시작한다)
		// ==> 반환값은 없다.
		v1.add(1,"kkk");
		System.out.println("v1 ==> " + v1);
		
		//데이터 수정 : set(index, 새로운데이터)
		// ==> index번째의 데이터를 '새로운데이터'로 덮어쓴다.
		// ==> 반환값 : 원래의 데이터
		String temp = (String)v1.set(1,"bbb");
		System.out.println("v1 = " + v1);
		System.out.println("반환값 : " + temp);
		
		//데이터 꺼내오기 : get(index)
		// ==> index번째의 데이터를 반환한다.
		int data = (int)v1.get(2);
		System.out.println("2번째 자료 : " + data);
		
		//데이터 삭제 : remove(index)
		// ==> index번째의 데이터를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("v1 => " + v1);
		
		temp = (String)v1.remove(0);
		System.out.println("v1 = " + v1);
		System.out.println("삭제된 데이터 :" + temp);
		
		//데이터 삭제 : remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다.
		// ==> '삭제할 데이터'가 여러개이면 앞에서부터 삭제된다.
		// ==> 반환값 : 삭제성공(true), 삭제실패(false)
		// ==> 삭제할 데이터가 '정수형' 이거나 'char형'일 경우에는 반드시 객체로 변환해서 지정해 주어야 한다.
		
		v1.remove("CCC");
		System.out.println("삭제 후 v1 = " + v1);
		
//		v1.remove(123);				//인덱스로 인식해서 오류가 뜸++++++++++++++++
		v1.remove(new Integer(123));
		System.out.println("삭제후 v1 = " + v1);
		
//		v1.remove('a');				//''로 저장되어있는 경우에는 컴퓨터에서 코드값으로 저장됨 'a' = 97
		v1.remove(new Character('a'));
		System.out.println("삭제후 v1 = " + v1);
		
		v1.remove(3.14);
		v1.remove(true);
		System.out.println("삭제후 v1 = " + v1);
		
		
		
		//==================================================================
		/*
		 * 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터 타입을 외부에 지정하는 기법
		 * 	==> 객체를 선언할 때 괄호(< >)안에 그 클래스 내부에서 사용할 데이터의 타입을 정해주는 것을 말한다.
		 *  ==> 이런식으로 선언하게 되면 그 데이터 타입 이외의 다른 데이터를 저장할 수 없게 된다.
		 *  ==> 이 때 제네릭으로 선언될 수 있는 데이터 타입은 '클래스형'이어야 한다.
		 *  	즉, int는 Integer, boolean은 Boolean, char는 Character등으로 대처해서 사용해야한다.
		 *  ==> 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 형변환이 필요없다.
		 */
		
		Vector<String> v2 = new Vector<String>();
		Vector<String> v22 = new Vector<>();
		
		Vector<Integer> v3 = new Vector<>();
//		Vector<int> v33 = new Vector<>();		//int타입 사용할수없어 컴파일에러
		
		v22.add("안녕하세요");
//		v22.add(123);  							//컴파일에러 : 다른 종류의 데이터를 저장할 수 없다.
		
		String temp2 = v22.get(0);				//형변환 불필요
		System.out.println("temp2 = " + temp2);
		
		Vector<Vector> vv = new Vector<>();		//2차원 배열같은 느낌
		Vector<Vector<Vector>> vvv = new Vector<>();//3차원배열같은 느낌
		
		
		System.out.println("------------------------------------------------");
		System.out.println();
		
		
		// 전체 데이터 삭제하기 : clear();
		v1.clear();
		System.out.println("v1의 개수 : " + v1.size());
		System.out.println("clear 후 v1 = " + v1);
		System.out.println();
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("v2 => " + v2);
		System.out.println("v4 => " + v4);
		
		//데이터 삭제 : removeAll(Collection객체)
		// ==> 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		// ==> 반환값 : 삭제 성공(true), 삭제 실패(false)
		v2.removeAll(v4);
		System.out.println("v2 = " + v2);
		
		System.out.println("-----------------------------------------");
		System.out.println();
		
		v2.clear();
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		// Vector에 저장된 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다.
		
		for(int i =0; i < v2.size(); i++)
		{
			System.out.println(i + "번째 자료 : " + v2.get(i));
		}
		
		System.out.println("----------------------------------------");
		
		//향상된 for문
		/*
		 - 형식) for(자료형명 변수명 : 배열이나 List 또는 Set형 객체 변수)
				{
					처리할 내용들;
					...
				}
		*/
		for(String str : v2)
		{
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
	}

}
