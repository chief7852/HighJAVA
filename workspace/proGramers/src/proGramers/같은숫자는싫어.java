package proGramers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class 같은숫자는싫어 {

	public static void main(String[] args) {
		int [] arr = new int[10];
		for(int i = 0; i < 10; i++)
		{
			arr[i] = (int)(Math.random()*10);
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int[] answer ={};
		ArrayList<Integer> list = new ArrayList<>();
		int temp = -1;
		for(int i : arr)
		{
			if(temp != i){temp= i;list.add(temp);}
		}
		answer = new int[list.size()];
		for(int i =0;i <answer.length;i++)
		{
			answer[i]=list.get(i);
		}
		
		for(int i: answer)
		{
			System.out.print(i+" ");
		}
	}

}
