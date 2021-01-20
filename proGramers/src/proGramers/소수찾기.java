package proGramers;

import java.util.ArrayList;

public class 소수찾기 {

	public static void main(String[] args) {
		int n = 10;
		int answer = 0;
		int temp =0;
		boolean[] a = new boolean[n+1];
		a[0]=true;
		a[1]=true;
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(a[i]==false)
			{
			for(int j=2*i;j<=n;j+=i)
			{
				a[j]=true;
			}
			}
		}
		for(boolean b : a)
		{
			if(b==false) {answer++;}
		}
		System.out.println(temp);
	}

}
