package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest04 {

	public static void main(String[] args) {
		//문제2) 문제 1에서 별명의 길이가 같은것을 입력할 수 있는 경우를 처리하시오.(class ArrayListTest04번만들어서)
		ArrayList<String> nick = new ArrayList<>();
		
		String[] nicks = {"뚱뚱","다람이","뚱이네부모님과함께","집게사장님딸","3122341","몊글자를해야하나","스폰지밥","집게리아","그래픽카드망가짐","플랑크톤사장","징징이","뚱이","전화번호부","더이상은생각하기힘듦","뭘더넣을까싶다"};
		for(int i = 0;i < 5; i++)
		{
			nick.add(nicks[(int) (Math.random()*nicks.length)]);
			
		}
		System.out.println(nick);
		
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
		
		
		
		//선생님 방법
		//제일긴 별명의길이가 저장될 변수를 선언하고
		//이 변수는 List의 첫번째 데이터의 길이로 초기화한다
		
		
		
		

	}

}
