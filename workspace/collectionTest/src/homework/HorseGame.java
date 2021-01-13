package homework;


/*
 		문제) 10마리의 말들이 경주하는 경마 프로그램을 작성하시오
 		말은 Horse라는 이름의 쓰레드 클래스로 작성하는데,
 		이 클래스는 말이름(String), 등수(int), 현재 위치값(int)을
 		멤버변수로 갖는다. 그리고, 이 클래스에는 등수를 오름차순으로
 		처리할 수 있는 내부 정렬 기준이 있다.(Comparable 인터페이스 구현)
 		
 		경기 구간은 1~50구간으로 되어 있다.
 		
 		경기가 진행되는 중간 중간에 각각의 말들의 위치를 아래와 같이 나타내시오.
 		예시)
 		01번말 :--->------------------------------
 		02번말 :---->-----------------------------
 		03번말 :->--------------------------------
 		  :
 		  
 		  경기가 끝나면 등수 순으로 출력한다.
 */
public class HorseGame {

	public static void main(String[] args) {
		
		Runnable[] hOrse = new Horse[]{ new Horse("01"),new Horse("02"),new Horse("03")
									,new Horse("04"),new Horse("05"),new Horse("06")
									,new Horse("07"),new Horse("08"),new Horse("09"),new Horse("10")};
		
		Thread[] th = new Thread[hOrse.length];
		for(int i=0;i<hOrse.length;i++)
		{
			th[i] = new Thread(hOrse[i]);
			th[i].start();
			
		}
		
//		Thread th = new Thread(hOrse[0]);
//		th.start();
		
		
		
	}
}
class Delay implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

class Horse implements Runnable{
	public static int currank = 0;
	private int rank;
	private int location;
	private String hname;
	public Horse(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

//	public String getHname() {
//		return hname;
//	}

	public void setHname(String hname) {
		this.hname = hname;
	}
	
	@Override
	public String toString()
	{
		return hname+"번말은"+rank+"등입니다.";
	}
	
	@Override
	public void run() {
		
		ab:while(true){
		for(int i = 0; i < 20;i++)
		{
			StringBuffer load = new StringBuffer("-------------------");
			System.out.println(hname+load.insert(i, ">"));
			Runnable del = new Delay();
			Thread th2 = new Thread(del);
			th2.start();
			if(i == 19){break ab;}
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

		}
	}
}