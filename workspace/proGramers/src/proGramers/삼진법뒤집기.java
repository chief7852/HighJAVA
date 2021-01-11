package proGramers;

import java.util.ArrayList;

public class 삼진법뒤집기 {

	public static void main(String[] args) {
		int n = 2_147_483_647;
		ArrayList<Integer> list = new ArrayList<>();	
		int m =0;
		for(int x = 0; x < n/3;x++)
		{
			
			for(int i= 1;i <=n;i++)
			{
				list.set(m,i);
			}
		}
//		for(int i = 1; i <= n;i++)
//		{
//			if(i%3==0)
//			{
//				
//			}
//		}
	}

}
