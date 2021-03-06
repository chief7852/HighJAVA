package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
 	문제) Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 		컴퓨터의 숫자는 난수를 이용하여 구한다.
 		(스트라이크는S, 볼은 B로 나타낸다.)
 		
 	예시)
 	 컴퓨터의 난수 ==> 9 5 7
 	 
 	실행예시)
 	숫자입력 => 356
 	3 5 6 == > 1S 0B
 	숫자입력 => 7 8 9
 	7 8 9 ==> 0S 2B
 	숫자입력 => 9 7 5
 	9 7 5 ==> 1S 2B
 	숫자입력 => 9 5 7
 	9 5 7 ==> 3S 0B
 	
 	
 	축하합니다.
 	당신은 4번째 만에 맞췄군요..
 */
public class BaseBallTest {

	public static void main(String[] args) 
	{
		HashSet<Integer> computer = new HashSet<>();
		while(computer.size()<3)
		{
			int rand = (int)(Math.random()*(9-1+1)+1);
			computer.add(rand);
		}
		System.out.println(computer);

		ArrayList<Integer> comrand = new ArrayList<>(computer);
		
		//		System.out.println(comrand);
		Collections.shuffle(comrand);
		System.out.println(comrand);
		Scanner s = new Scanner(System.in);
		
		int try_ =0;
		base:while(true)
		{
			try_++;
			System.out.println("숫자입력 =>");
			int user = Integer.parseInt(s.nextLine());
			int a = user/100;
			int b = (user/10)%10;
			int c = user%10;
			int S = 0;
			int B = 0;
			int act = (a == comrand.get(0))? S++:(comrand.get(0) == b||comrand.get(0) == c)? B++:0 ;
			act = (b == comrand.get(1))? S++:(comrand.get(1) == a||comrand.get(1) == c)? B++:0;
			act = (c == comrand.get(2))? S++:(comrand.get(2) == b||comrand.get(2) == a)? B++:0;
			System.out.print(a+" "+b+" "+c+"==> ");
			System.out.println(S+"S"+B+"B");
			if(S==3){System.out.println("축하합니다.\n당신은 "+try_+"번째 만에 맞췄군요.."); break base;}
		}
	}
}
	


