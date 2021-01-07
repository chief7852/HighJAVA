package homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
	static Lotto sc = new Lotto();
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		buy:while(true)
		{
			System.out.print("==========================\n"
					+ "Lotto 프로그램\n"
					+ "--------------------------\n"
					+ "1. Lotto 구입\n"
					+ "2. 프로그램 종료\n"
					+ "==========================\n"
					+ "메뉴선택 : ");
			int menu = Integer.parseInt(s.nextLine());
			switch(menu)
			{
			case 1 : System.out.println("\nLotto 구입시작\n(1000원에 로또번호 하나입니다.)"
					+ "\n금액입력 : ");
					int money =Integer.parseInt(s.nextLine());
					int qty = money/1000;
					int change = money%1000;
					sc.Read(money,qty,change);
					break;
			case 2 :System.out.println("감사합니다"); 
				break buy;
			}
		}
	}
	
	private void Read(int money ,int qty,int change)
	{
		if(qty>10){System.out.println("입금금액이 너무많습니다.");}
		else if(qty < 1){System.out.println("입금금액이 너무작습니다.");}
		else {sc.lottOnum(qty); System.out.println("받은 금액은"
		+money+"이고 거스름돈은"+change+"원입니다.");}
	}
	
	private void lottOnum(int qty)
	{
		
		
		for(int i=0;i<qty;i++)
		{
			HashSet<Integer> lottonum = new HashSet<Integer>();
			
			while(lottonum.size()<5)
			{
				lottonum.add((int)(Math.random()*(45-1+1)+1));
				
			}
			ArrayList<Integer> Lottonum =new ArrayList<>(lottonum);
			System.out.print("로또번호"+(i+1)+" : ");
			for(int rl : Lottonum)
			{
				
				System.out.print(rl);
				if(Lottonum.get(Lottonum.size()-1) != rl)
				{System.out.print(", ");}
			}
			System.out.println();
		}

		
		
	}
	

}
