package proGramers;

public class 내맘정렬 {

	public static void main(String[] args) {
		
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		String[] answer = new String[strings.length];
//		System.out.println(strings[0].charAt(n));
		int te = 0;
		for(int i =0; i<strings.length;i++)
		{
			
			if(strings[i].length()>n+1) 
			{answer[i] = strings[i].charAt(n+1) + strings[i].charAt(n)+strings[i];}
			else {answer[i] = strings[i].charAt(n)+strings[i];}
		}
		for(String a : answer)
		{
			System.out.println(a);
		}
		
	}

}
