package proGramers;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		String answer = "";
		
		int a=(int)s.charAt(2);
		
		int[] ans = new int[s.length()];
		
		int x=0;
		for(int i=0;i<s.length();i++)
		{
			ans[i] = (int)s.charAt(i);
		}

		Arrays.sort(ans);
		answer= "";
		for(int i =ans.length-1;i>=0;i--)
		{
			answer += (char)ans[i];
		}
		System.out.println(answer);
	}

}
