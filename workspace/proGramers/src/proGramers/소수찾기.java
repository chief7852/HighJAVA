package proGramers;

import java.util.ArrayList;

public class 소수찾기 {

	public static void main(String[] args) {
		int answer = 0;
	    int n =10; 
		int temp =0;
		for(int i = 2; i <= n; i++)
		{
			answer = 0;
			for(int j = 2; j <= i;j++)
			{
				if(i >= j&&i%j==0 )
				{
					
						answer++;
					
				}
			}
			if(answer == 1)
			temp++;
		}

		answer = temp;
		
		System.out.println(answer);
	}

}
