package homework;

import java.util.Scanner;

public class subject2 {

	public static void main(String[] args) {
		//문제1
		int[] arr = {10,20,30,40,50};
		int answer1= 0;
		for(int i : arr)
		{
			answer1+=i;
		}
		System.out.println(answer1);
		
		//문제2
//		String[] name = new String[5];
//		Scanner s = new Scanner(System.in);
//		for(int i = 0; i< name.length;i++)
//		{
//			String nm = s.nextLine();
//			name[i] = nm;
//		}
		
		//문제3
		int[] score = { 79, 88,91,33,100,55,95};
		int max= 0;
		int min= score[0];
		for(int i = 0; i<score.length;i++)
		{
			if(score[i]>max)
			{
				max=score[i];
			}
			if(score[i]<min)
			{
				min = score[i];
			}
		}
		System.out.println(max+","+min);
		//문제4
		int[][] arr2 = {
			    {5,5,5,5,5},
			    {10,10,10,10,10},
			    {20,20,20,20,20},
			    {30,30,30,30,30}
			 };
		answer1 = 0;
		int sum = 0;
		for(int i = 0 ; i <arr2.length;i++)
		{
			for(int j = 0; j<arr2[i].length;j++)
			{
				answer1 +=arr2[i][j];
				sum++;
			}
		}
		System.out.println(answer1+","+(double)answer1/sum );
		
		
		//문제5번
		int[] answer= {4,3,2,1};
		int[] counter = new int[4];
		//문제6번
		String menu[] ={ "아메리카노 3000원", "카푸치노 4000원", "카페라떼 3500원"};
		int answer2 = menu[1].indexOf(" "); 
		System.out.println(answer2);
		for(int i = 0; i <menu.length;i++)
		{
			answer2 = menu[i].indexOf(" ");
			System.out.println(menu[i].substring(0,answer2));
		}
		//문제7번
		String str="i Love Java";
		System.out.println(str.indexOf("Java")+"부터"+str.length()+"까지");
		//문제8번
		String  s="java.lang.Object";
		System.out.println(s.substring(s.indexOf("l"),s.indexOf(".O")));
		//문제9번
		String animals = "dog,cat,bear";
		String[] aa =animals.split(",");
		for(String ans2 : aa)
		{
			System.out.println(ans2);
		}
		//문제10번
	    str="java,lang,Object";
	     aa = str.split("");
	    for(int i =0; i <aa.length;i++)
	    {
	    	if(aa[i].equals(","))
	    	{
	    		aa[i] = ".";
	    	}
	    	System.out.print(aa[i]);
	    }
	    
	}

}
