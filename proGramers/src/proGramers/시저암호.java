package proGramers;

public class 시저암호 {
    public static void main(String[] args) {
        String a = "AaZz";
        int n = 25;
        String answer ="";
        for(int i = 0; i <a.length();i++)
        {
        	char temp =a.charAt(i);
        	int te =(int)temp;
        	
        	for(int j = 0; j<n;j++)
        	{
        		if(te==32) {break;}
        		te++;
        		if(te==91) {te=65;}
        		if(te==123) {te=97;}
        		
        	}
        	answer += (char)te;
        }
        System.out.println(answer);
    }
}
