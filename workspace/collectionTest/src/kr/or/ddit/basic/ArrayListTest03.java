package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * 문제 1) 5명의 별명을 입력받아 ArrayList에 저장하고 이들중 별명의 길이가 제일
 * 		긴 별명을 출력하시오 (단, 각 별명의 길이는 모드 다르게 입력한다.)
 * 문제2) 문제 1에서 별명의 길이가 같은것을 입력할 수 있는 경우를 처리하시오.(class ArrayListTest04번만들어서) 
 */
public class ArrayListTest03 
{

	public static void main(String[] args) 
	{
		ArrayList<String> nick = new ArrayList<>();
		
		nick.add("뚱이");
		nick.add("징징이징징징징징");
		nick.add("다람이");
		nick.add("플랑크톤사장");
		nick.add("스폰지밥밥밥밥");
		nick.add("집게사장님");
		nick.add("집게사장님딸과아들");
		
		
		String longnick = "";
		for(int i = 0; i < nick.size();i++)
		{
			if(longnick.length()<nick.get(i).length())
			{
				longnick = nick.get(i);
			}
		}
		System.out.println(longnick);
	}

}
