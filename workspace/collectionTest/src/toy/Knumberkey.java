package toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Knumberkey {

	public static void main(String[] args) {
		int[] array ={1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer={};
		answer= new int[commands.length];
		int i=0;
		for(int[] ijk : commands)
		{
			
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j = ijk[0]-1;j <=ijk[1]-1;j++)
			{
				temp.add(array[j]);
			}
			Collections.sort(temp);
			answer[i] = temp.get(i);
			i ++;
		}
		System.out.println(answer);

	}

}
