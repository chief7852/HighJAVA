package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest04 {

	public static void main(String[] args) {
		//문제2) 문제 1에서 별명의 길이가 같은것을 입력할 수 있는 경우를 처리하시오.(class ArrayListTest04번만들어서)
		ArrayList<String> nick = new ArrayList<>();
		nick.add("집게사장님딸");
		nick.add("뚱이");
		nick.add("징징이");
		nick.add("다람이");
		nick.add("플랑크톤사장");
		nick.add("스폰지밥");
		nick.add("집게사장님");
		nick.add("집게사장님딸");
		nick.add("집게사장님딸");
		nick.add("집게사장님딸");
		nick.add("집게사장님딸");
		
		String nickname = "";
		ArrayList<String> nickmax = new ArrayList<>();
		for(String str : nick)
		{
			if(str.length() > nickname.length())
			{
				nickname = str;
				nickmax.clear();
			}
			if(str.length() == nickname.length())
			{
				nickmax.add(str);
			}
			
		}
		System.out.println(nickmax);

	}

}
