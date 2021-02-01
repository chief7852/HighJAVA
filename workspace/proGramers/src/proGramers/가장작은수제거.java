package proGramers;

import java.util.ArrayList;

public class 가장작은수제거 {

	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		ArrayList<Integer> list = new ArrayList<Integer>();
		int temp = arr[0];
		for(int i : arr)
		{
			if(i<temp) {temp=i;}
		}
		
		
		for(int i : arr)
		{
			if(i!=temp) {list.add(i);}
		}
		
		
		
	}

}
