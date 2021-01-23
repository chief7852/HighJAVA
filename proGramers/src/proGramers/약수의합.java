package proGramers;

import java.util.ArrayList;

public class 약수의합 {

	public static void main(String[] args) {
		int n = 12;
		int answer=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i =1;i<=n;i++)
		{
			if(n%i==0) {list.add(i);}
		}
		for(int x : list)
		{
			answer+=x;
		}
		System.out.println(answer);
	}

}
