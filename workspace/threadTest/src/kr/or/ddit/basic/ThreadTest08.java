package kr.or.ddit.basic;

public class ThreadTest08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread();
		th1.setPriority(3);
		th1.setPriority(8);
		System.out.println("th1의 우선순위 : " + th1.getPriority());
		System.out.println("th2의 우선순위 : " + th2.getPriority());
		th1.start();
		
		th2.start();
	}

}
// 대문자를 출력하는 쓰레드
class  UpperThread extends Thread{
	@Override
	public void run() {
		for(char c='A'; c<='Z'; c++)
		{
			System.out.println(c);
			for(long i=1;i<=700000000; i++){}
		}

	}
}

// 소문자를 출력하는 쓰레드
class LowerThread extends Thread{
	@Override
	public void run() {
		for(char c='a'; c<='z'; c++)
		{
			System.out.println(c);
			for(long i=1;i<=700000000; i++){}
		}
	}
}