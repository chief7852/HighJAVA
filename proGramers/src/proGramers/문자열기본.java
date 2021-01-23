package proGramers;

public class 문자열기본 {

	public static void main(String[] args) {
		String s ="0123456789";
		boolean answer = true;
		for(int i =0;i<s.length();i++)
		{
			if(s.length()<4||s.length()>6) {answer=false;break;}
			if((int)s.charAt(i)<48||(int)s.charAt(i)>57) {answer=false;break;}
			
			
		}
		System.out.println(answer);
		s.matches("[0-9]");
	}

}
