package proGramers;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		int[] score1 = {1,2,3,4,5};
		int[] score2 = {2,1,2,3,2,4,2,5};
		int[] score3 = {3,3,1,1,2,2,4,4,5,5};
		int[] answer = {};
		int[] stu = new int[3];
		int i =0;
		for(int ans : answers)
		{
			if(ans==score1[i%5]){stu[0]++;}
			if(ans==score2[i%8]){stu[1]++;}
			if(ans==score3[i%10]){stu[2]++;}
			i++;

		}
		int king = 0;
		int num =0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int max : stu)
		{
			if(max > king){king=max;}	
		}
		for(int max : stu)
		{
			num++;
			if(max==king){list.add(num);}
			
		}
		answer= new int[list.size()];
		
		for(int j=0;j<list.size();j++)
		{
			answer[j] = list.get(j);
			System.out.println(answer[j]);
		}
		
		
	
}
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        return answer;
    }
}
}