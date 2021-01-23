package proGramers;

public class p와y의개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PyY";
		boolean answer = true;
		int p =0;
		int y =0;
		for(int i = 0; i <s.length();i++)
		{
			
			if(s.charAt(i)=='p'||s.charAt(i)=='P') {p++;}
			if(s.charAt(i)=='y'||s.charAt(i)=='Y') {y++;}
			
				
			
		}
		answer =(p==y)? true:false;
		
		System.out.println(answer);
	}

}
