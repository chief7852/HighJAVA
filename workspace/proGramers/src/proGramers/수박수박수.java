package proGramers;

public class 수박수박수 {

	public static void main(String[] args) {
		int n = 3;
		String q = "수박";
		String answer = "";
		for(int i = 0; i <n;i++)
		{
			answer +=(i%2==0)? "수":"박";
		}
		System.out.println(answer);

	}

}
