package kr.or.ddit.basic;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/*
  	Vector, Hashtable등 예전부터 존재하던 Collection 객체들은
  	내부에 동기화 처리가 되어있다.
  	
  	그런데, 새로 구성된 Collection 객체들은 동기화 처리가 되어있지 않다.
  	그래서, 동기화가 필요한 프로그램에서 이런 Collection 객체를 사용하려면
  	동기화 처리를 한 후에 사용 해야한다.
 */

public class ThreadTest19 {
//	private static Vector<Integer> vec = new Vector<>();
	
	//동기화 처리가 되지 않은 List
//	private static ArrayList<Integer> list = new ArrayList<>();
	
	//동기화 처리를 한 경우
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		// 익명 구현체
		Runnable r = new Runnable()
		{
			@Override
			public void run() 
			{
				for(int i = 0; i < 10000; i++)
				{
//					vec.add(i);
//					list.add(i);
					list2.add(i);
				}
			}
		};
		
		//--------------------------------------------
		
		Thread[] ths = new Thread[]
			{
				new Thread(r),new Thread(r),new Thread(r),new Thread(r),new Thread(r)
			};
		
		for(Thread th : ths)
		{
			th.start();
		}
		
		for(Thread th : ths)
		{
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
//		System.out.println("vec의 개수 : " + vec.size());
//		System.out.println("list의 개수 : " + list.size());			//index 값을 초과했다는 에러가뜬다 이유는 배열을 만드는 속도가 느리고 동기화처리가 안되어서이다.
		System.out.println("list2의 개수 : " + list2.size());
	}

}
