package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 	문제) 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 		컴퓨터의 가위 바위 보는 난수를 이용해서 정하고,
 		사용자는 showInputDialog()메서드를 이용해서 입력받는다.
 		
 		입력시간은 5초로 제한하고 카운트다운을 진행한다.
 		5초안에 입력이 없으면 게임에 진것으로 처리한다.
 		
 		5초 안에 입력이 완료되면 승패를 구해서 출력한다.
 		
 		1) 5초안에 입력을 못했을 경우 실행 예시
 		  -- 결과 --
 		  시간초과로 당신이 졌습니다.
 		  
 		2) 5초 안에 입력을 했을경우 실행 예시
 		-- 결과 --
 		컴퓨 : 가위
 		사용자: 바위 
 		결과 : 당신이 이겼습니다.
 */
public class ThreadTest07 {

	public static void main(String[] args) {
		
		Thread th = new InputRP();
		Thread th2 = new Countfive();
		
		th.start();
		th2.start();
		
	}

}

class InputRP extends Thread{
	public static boolean inputCheck = false;

	@Override
	public void run() {
		int rand = (int)(Math.random()*3)+1;
		String com = "";
		switch(rand)
		{
		case 1 : com = "가위"; break;
		case 2 : com = "바위"; break;
		case 3 : com = "보"; break;
		}
		String str = JOptionPane.showInputDialog("(가위,바위,보) 중 하나를 입력해주세요");
		
		inputCheck = true;
		String result ="";
		if(str==null){System.out.println("답을 선택하지 않아 게임을 종료하겠습니다.");System.exit(1);}
		if(com.equals("가위")){ result = (str.equals("바위"))? "당신이 이겼습니다." : (str.equals("가위"))? "비겼습니다.":"당신이 패배하였습니다.";}
		if(com.equals("바위")){ result = (str.equals("보"))? "당신이 이겼습니다." : (str.equals("바위"))? "비겼습니다.": "당신이 패배하였습니다.";}
		if(com.equals("보")){ result = (str.equals("가위"))? "당신이 이겼습니다." : (str.equals("보"))? "비겼습니다.": "당신이 패배하였습니다.";}
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + str);
		System.out.println("결과 : "+result);
	}
}
class Countfive extends Thread{
	@Override
	public void run() {
		
			for(int i = 5; i> 0; i--)
			{
				if(DataInput.inputCheck==true)
				{
					return;	// run()메서드가 종료되면 쓰레드도 종료된다.
				}
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
			System.out.println("5초가 지났습니다. 당신이 패배하였습니다..");
			System.exit(1);	
		
	}
}
