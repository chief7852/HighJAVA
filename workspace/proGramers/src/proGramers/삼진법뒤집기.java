package proGramers;

import java.util.ArrayList;

public class 삼진법뒤집기 {

	public static void main(String[] args) {
		int n = 27;
		ArrayList<Integer> list = new ArrayList<>();	
		
		while(n>0)
		{
			list.add(n%3);
			n /=3;
//			if(n>3){list.add(n%3);n=n/3;}
//			if(n<3){list.add(n%3);break;}

		}
		for(int i : list)
		{
			System.out.println(i);
		}
		
		System.out.println(" 원하는답"+(int)Math.pow(3,0));
		int answer =0;
		int j =list.size()-1;
		for(int i = 0; i< list.size();i++)
		{
			answer += list.get(i)*((int)Math.pow(3,j));
			j--;
			System.out.println(answer);
		}
		
	}

}
