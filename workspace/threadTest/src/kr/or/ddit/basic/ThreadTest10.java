package kr.or.ddit.basic;
//쓰레드의 상태값을 출력하는 예제
public class ThreadTest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StatePrintThread th = 
				new StatePrintThread(new TargetThread());
		th.start();
	}

}

//쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread{
	@Override
	public void run() {
		for(long i = 1L; i <=20_000_000_000L;i++){}//시간지연용
		try {
			Thread.sleep(1501);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		for(long i = 1L; i <=20_000_000_000L;i++){}//시간지연용
	}
}

// 검사 대상 쓰레드의 상태값을 출력하는 쓰레드
class StatePrintThread extends Thread{
	//검사 대상 쓰레드가 저장될 변수 선언
	private TargetThread target;
	
	public StatePrintThread(TargetThread target)
	{
		this.target = target;
	}
	@Override
	public void run() {
		while(true)
		{
			//쓰레드의 상태값 구하기
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값 : " + state);

			if(state==Thread.State.NEW)
			{//쓰레드가 NEW상태이면
				target.start();
			}

			//검사 대상 쓰레드가 종료 상태이면...
			if(state==Thread.State.TERMINATED)
			{
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}