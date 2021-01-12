package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		// 사용자로부터 데이터 입력받기
		String str = JOptionPane.showInputDialog("아무노래나 일단 불러~");
		System.out.println("입력값 : "+ str);
		for(int i = 10; i> 0; i--)
		{
			System.out.println(i);
			
			try {
				Thread.sleep(1000);  		//1초도안 잠시멈춘다.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
