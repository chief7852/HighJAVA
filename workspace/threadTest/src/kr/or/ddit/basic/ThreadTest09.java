package kr.or.ddit.basic;

// 데몬 쓰레드 연습 ==> 자동 저장하는 쓰레드

public class ThreadTest09 {

	public static void main(String[] args) {
		AutoSaveThread th1 = new AutoSaveThread();
		
		//데몬 쓰레드로 설정하기
		th1.setDaemon(true);
		th1.start();
		
		try {
			for(int i =1; i <=20; i++)
			{
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}

//자동 저장하는 쓰레드(3초에 한번씩 자동저장하는 쓰레드)
class AutoSaveThread extends Thread
{
	//작업을 저장하는 메서드
	public void save()
	{
		System.out.println("작업내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			save();
		}
	}
	
}