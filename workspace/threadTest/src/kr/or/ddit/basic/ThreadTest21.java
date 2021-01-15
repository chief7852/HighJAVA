package kr.or.ddit.basic;

public class ThreadTest21 {

	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		ProducerThread pt = new ProducerThread(databox);
		ConsumerThread ct = new ConsumerThread(databox);
		
		pt.start();
		ct.start();
		

	}

}


//데이터를 공통으로 사용하는 클래스

class DataBox
{
	private String data;
	
	//출력
	// data변수의 값이 null이면 문자열이 채워질 때 까지 기다리고
	// data 변수에 값이 있으면 해당 문자열을 반환하는 메서드
	// 데이터를 반환후에는 data변수값을 null로 만든다.
	public synchronized String getData()
	{
		if(data == null)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		String returnData = data;
		System.out.println("쓰레드가 읽은 데이터 : " + data);
		data = null;
		
		notify();
		return returnData;
	}
	
	//입력
	// data변수의 값이 있으면 data변수값이 null이 될때까지 기다린다.
	// data변수의 값이 null이되면 새로운 data값을 저장한다.
	public synchronized void setData(String newData)
	{
		if(data != null)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		data = newData;
		System.out.println("Thread에서 새로 저장한 데이터 : " + data);
		
		notify();
	}
	
}


// 데이터를 넣어주는 쓰레드
class ProducerThread extends Thread
{
	private DataBox dataBox;

	public ProducerThread(DataBox dataBox) 
	{
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 3; i++)
		{
			dataBox.setData(i+ " 번째 공급데이터");
		}
	}
	
	
}

//데이터를 꺼내서 사용하는 쓰레드
class ConsumerThread extends Thread
{
	private DataBox databox;
	
	public ConsumerThread(DataBox databox) {
		this.databox = databox;
	}
	
	
	@Override
	public void run() {
		for(int i=1; i <=3; i++)
		{
			String data = databox.getData();
			//꺼내온데이터를 용도에 맞게 사용한는 데이터
		}
	}
}






