package kr.or.ddit.basic;

import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  문제 ) 5명의 사람 이름을 입력 받아서 ArrayList에 저장한 후에 이들 중 '김'씨 성을 가진 사람을 모두 출력하시오.
 */
public class ArrayListTest02 
{

	public static void main(String[] args) 
	{
		ArrayList<String> name = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		for(int i = 0; i < 5; i++)
		{
			System.out.print(i+1 +"번 사람 이름을 입력하시오 : ");
			String Uname = s.nextLine();
			name.add(Uname);
		}
		System.out.println(name);
		
		for(int i = 0; i < name.size(); i++)
		{
//			if(name.get(i).charAt(0) == '김')
//			{
//				System.out.println(name.get(i));
//			}
			System.out.println(name.get(i).substring(0));
//			if(name.get(i).substring(0).contains("김"))
//			{
//				 System.out.println(name.get(i));
//			}
			if(name.get(i).startsWith("김"))
			{
				System.out.println(name.get(i));
			}
		}
	}

}
