package kr.or.ddit.basic;
//3개의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데
//출력을 끝낸 순서대로 결과를 나타내는 프로그렘 작성하기

public class ThreadTest11 {

	public static void main(String[] args) {
		DisplayCharacter[] disChars = new DisplayCharacter[]{ new DisplayCharacter("정이삭"),
															  new DisplayCharacter("송재욱"),
															  new DisplayCharacter("홍준표")};
		//배열에 저장된 쓰레드를 실행한다.
		for(DisplayCharacter char1 : disChars)
		{
			char1.start();
		}
		// 모든 쓰레드의 출력이 끝날때 까지 기다린다.
		for(int i =0; i <disChars.length;i++)
		{
			try {
				disChars[i].join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println();
		System.out.println("  == 경기결과 ==");
		System.out.println("순위 : " + DisplayCharacter.setRank);
	}

}
// A~Z까지 출력하는 쓰레드
class DisplayCharacter extends Thread{
	public static String setRank = "";
	private String name;
	
	//생성자
	public DisplayCharacter (String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char c='A';c <= 'Z'; c++)
		{
			System.out.println(name + "의 출력 문자 : " + c);
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(name + " 출력 끝......");
		
		// 출력을 끈낸 순서대로 이름을 배치한다.
		DisplayCharacter.setRank += name + " ";
	}
	
}