package homework;

import java.util.Scanner;

public class subject1 {

	public static void main(String[] args) {
		//연산자 1번
		int num = 10;
		String answer1 = (0<num)?"양수":(num==0)?"0":"음수";
		System.out.println(answer1);
		//연산자 2번
		char ch='1';
		boolean b  =((int)ch <= 122&&(int)ch>=97||(int)ch<=90&&(int)ch>=65||(int)ch<=57&&(int)ch>=48)? true:false;
		System.out.println(b);
		//연산자 3번 32
		char ch2 ='A';
		int ans = (int)ch2 + 32;
		System.out.println((char)ans);
		//조건문반복문 4번
		int value = (int)(Math.random()*6)+1;
		System.out.println(value);
		//5번
		int answer4 = 0;
		for(int i=0; i <100; i++)
		{
			answer4 +=i;
		}
		System.out.println(answer4);
		//6
		value = (int)(Math.random()*100)+1;
		System.out.println(value);
		Scanner s = new Scanner(System.in);
		while(true)
		{
			int a = Integer.parseInt(s.nextLine());
			if(a == value)break;
		}
		//
	}

}
