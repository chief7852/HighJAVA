package proGramers;

import java.util.ArrayList;
import java.util.Collections;

public class k번째수 {

	public static void main(String[] args) {
		
	        int[] array ={1, 5, 2, 6, 3, 7, 4};
			int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
			int[] answer={};

			
			
			answer= new int[commands.length];
			for(int i = 0; i <commands.length;i++)
			{
				ArrayList<Integer> temp = new ArrayList<>();
				int a = commands[i][0];
				int b = commands[i][1];
				int c = commands[i][2];
				for(int j = a-1; j<=b-1;j++)
				{
					temp.add(array[j]);

				}
				Collections.sort(temp);
				answer[i] =temp.get(c-1);
			}
			System.out.println(answer[2]);
//			for(int[] abc : commands){
//				
//				int a = abc[0];
//				ArrayList<Integer> temp = new ArrayList<>();
//				for(int i = ;)
//			}
				
				
			
	}

}
