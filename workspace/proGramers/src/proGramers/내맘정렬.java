package proGramers;

import java.util.Arrays;

public class 내맘정렬 {

	public static void main(String[] args) {
		
		String[] strings = {"abceasf", "abcdasf", "cdxdds"};
		int n = 2;
		String[] answer = new String[strings.length];
//		System.out.println(strings[0].charAt(n));
		int te = 0;
		for(int i =0; i<strings.length;i++)
		{
			answer[i] = strings[i].charAt(n)+strings[i];
		}
		Arrays.sort(answer);
		
		for(int i =0; i<strings.length;i++)
		{
			answer[i] = answer[i].substring(1);
		}
	}

}
