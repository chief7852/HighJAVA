package kr.or.ddit.basic;

class NonGenericClass
{
	private Object value;
	public int kor;
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setValue(Object value)
	{
		this.value = value;
	}
	
	public Object getValue()
	{
		return value;
	}
}

/*
  - 제네릭 클래스를 만드는 방법
  형식)
  	class 클래스명 <제네릭타입글자>
  	{
  	제네릭 타입글자 변수명; // 변수 선언에 제네릭을 사용할 경우
  	...
  	
  		제네릭 타입 글자 메서드명()	//반환값이 있는 메서드에서 사용할 경우
  		{
  			...
  			return값;
  		}
  		
  		void 메서드명 (제네릭타입 글자 변수명) {//메서드의 매개변수에 제네릭을 사용할 경우
  		
  		}

  	}
  	--제네릭 타입 글자로 많이사용되는 것
  	T ==> Type
  	K ==> Key
  	V ==> Value
  	E ==> Element(자료구조에 들어가는 것들을 주로 나타낸다.)
 */
class MyGeneric<T>
{
	private T value;
	
	public void setValue(T value)
	{
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}

	

	
}

public class GenericTest {


	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setValue("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setValue(100);
		
		
		String rtnNg1 = (String)ng1.getValue();
		System.out.println("문자열 반환값 :" + rtnNg1);
		int rtnNg2 = (int)ng2.getValue();
		System.out.println("정수 반환값 : " + rtnNg2);
		System.out.println();
		
//		String rtnNg3 = ng2.getValue().toString();
//		System.out.println("rtnNg3 = " + rtnNg3);
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setValue("가나다라");
		mg2.setValue(500);

		
		String rtnMg1 = mg1.getValue();
		int rtnMg2 = mg2.getValue();
		
		System.out.println(rtnMg1);
		System.out.println(rtnMg2);
	}

}
