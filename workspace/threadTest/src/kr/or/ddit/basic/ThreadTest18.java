package kr.or.ddit.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 은행의 입출금을 쓰레드로 처리하는 예제
// (Lock 객체를 이용한 동기화 처리 에제)


public class ThreadTest18 {
private int balance;	//잔액

	//동기화 처리를 해주는 Lock객체 생성하기
	private Lock lock = new ReentrantLock();
	
	public  int getBalance()
	{
		return balance;
	}
	
	public  void setBalance(int balance)
	{
		this.balance = balance;
	}
	
	//입금하는 메서드
	public  void deposit(int money)
	{
		// lock() 메서드를 try ~ catch블럭에서 사용하게 되면
		// unlock()메서드는 finally 영역에서 호출하도록 한다.
		
		try {
			lock.lock();
			balance += money;
//			lock.unlock();				// 이부분에 예외처리중에 사용하는것은 위험하다.(unlock하지 않고 나갈수도있다.)
		} catch (Exception e) {
			e.printStackTrace();
		}finally {						// finally는 예외처리를 하던 안하던 무조건 한번 실행하는것이 기에 여기에 언락을 넣어야한다.
			lock.unlock();
		}
		
	}
	
	
	//출금하는 메서드
	public  boolean withdraw(int money)
	{
		//Lock객체는 lock()메서드로 락을 설정하고
		// 반드시 unlock()메서드로 락을 해제해 주어야 한다.
		
		lock.lock();		//락 설정 시작==========================================
		boolean chk = false;
		if(balance >= money)
		{
			for(int i = 1; i <=100000000;i++){}//시간지연
			
			balance -= money;
			System.out.println("메서드안에서 balance = " + getBalance());
			chk = true;
		}else { chk= false;}
			lock.unlock();	//락을 해제한다==========================================
			return chk;
		}
	
	public static void main(String[] args) {
		final ThreadTest18 acount = new ThreadTest18();
		acount.setBalance(10000);		//잔액 10000원
		
		Runnable test = new  Runnable()
		{
			public void run() {
				//6000원 출금하기
				boolean result = acount.withdraw(8000);
				System.out.println("쓰레드 안에서 result = " + 
				result + ", balance = " + acount.getBalance());
			}
		};
		
		//---------------------------
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
//		Thread th1 = new Thread(test);
		th1.start();
		th2.start();
	}
}
