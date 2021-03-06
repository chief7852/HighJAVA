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
		
		Runnable[] hOrse = new Horse[10];

		
		Runnable print = new Printinloc(hOrse);
		for(int i = 1; i <=hOrse.length;i++)
		{
			String hname = (i<10)? "0"+i : Integer.toString(i);
			if(i<10)hOrse[i-1] = new Horse(hname);
			else hOrse[i-1] = new Horse(hname);
		}
		Thread pth =new Thread(print);
		Thread[] th = new Thread[hOrse.length];
		for(int i=0;i<hOrse.length;i++)
		{
			th[i] = new Thread(hOrse[i]);
			th[i].start();
			
		}
		pth.start();
		

		
	}
}
//현재위치를 가지고 출력하기
class Printinloc implements Runnable 
{
	private Runnable[] horse;
	
	public Printinloc(Runnable[] hOrse2) {
		this.horse = hOrse2;
	}
	public Runnable[] getHorse() {
		return horse;
	}
	public void setHorse(Horse[] horse) {
		this.horse = horse;
	}
	@Override
	public void run() {
		while(true)
		{
			for(int i=0;i < horse.length;i++)
			{
				String hname = (Horse)horse[i].getClass().getHname();
				System.out.print((Horse)horse[i].getHname());
				StringBuffer print = new StringBuffer("-------------------------------------------------");
				
				System.out.println(print.insert(((Horse) horse[i]).getLocation(),">"));
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
	}
}


//위치값 구하기
class Horse implements Runnable , Comparable<Horse>
{
	public static int currentRank=0;
	private int rank;
	private int location;
	private String hname;
	
	Horse(String hname)
	{
		this.hname=hname;
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

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}
	
	@Override
	public int compareTo(Horse o) {
		return Integer.compare(rank, o.getRank());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "경주마"+hname+"은"+rank+"입니다.";
	}
	@Override
	public void run() {
		
		for(int i= 0; i< 50; i++)
		{
			this.location=i;
			
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		currentRank++;
		this.rank =currentRank;
		
	}
}

		
	
