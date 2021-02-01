package proGramers;

public class 핸폰가리기 {

	public static void main(String[] args) {
		String phone_number = "01033334444";
		String answer="";
		for(int i = 0;i<phone_number.length();i++)
		{
			if(phone_number.length()-5<i) {
			answer += phone_number.charAt(i);
			}else answer += "*";
		}
		
		System.out.println(answer);
	}

}
