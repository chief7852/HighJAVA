package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 쓰레드가 수행되는 시간을 체크해 보자.
		Thread th = new Thread(new MyRunner());
		// System.currentTimeMillis()는 1970년 1월1일 0시0분0초(표준시간)로 부터 경과한 시간을
		// 밀리세컨드 단위로 반환한다.
		Long startTime =System.currentTimeMillis();
		th.start();
		
		try {
			th.join();   // 현재 실행중인 쓰레드에서	
						 // 대상이 되는 쓰레드(여기에서는 th)가
						 // 종료될때까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : "+(endTime-startTime));
		
	}

}

// 1 ~ 10억 까지의 합계를 구하는 쓰레드
class MyRunner implements Runnable
{
	@Override
	public void run() {
		long sum = 0L;
		for(long i =0 ; i < 100_000_000_000L;i++)
		{
			sum+=i;
		}
		System.out.println("합계 : " + sum);
		
	}
}