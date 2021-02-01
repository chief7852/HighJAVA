package proGramers;

public class 이상한문자 {

	public static void main(String[] args) {
		String s = "try hello world";
		String answer ="";
		String[] temp = new String[s.split("").length];
		temp = s.split("");
		for(String ttt : temp)
		{
			System.out.println(ttt);
		}

		for(int i = 0; i < temp.length;i++)
		{
			int te =(int)temp[i].charAt();
			if(i%2==1) {temp[i] =(te >=65&&te<=90)? Integer.toString(te+32): temp[i];}
			else if(i%2==0) {temp[i] =(te >=97&&te<=122)? Integer.toString(te+32) : temp[i];}
			
			answer+=temp[i];
		}
				
		
		
		System.out.println(answer);
	}

}
