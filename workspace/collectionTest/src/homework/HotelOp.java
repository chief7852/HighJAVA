package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
문제) 호텔 객실을 관리하는 프로그램을 작성하시오.

조건1)  호텔 객식을 나타내는 Room클래스는 
방번호(int), 방종류, 투숙객이름 필드로 구성되어 있고			     
  방번호와 방종류는 다음과 같다.
  - 201~209 : 싱글룸
  - 301~309 : 더블룸
  - 401~409 : 스위트룸

조건2) 전체 객실 관리는 Map을 이용한다.
 (Map의 key값은 방번호로 하고 value값은 Room의 인스턴스로 한다.)
 생성자에서는 방번호와 방종류를 초기화한다.




실행예시)

*********************************************
호텔문을 열었습니다. 어서오십시요.
*********************************************


-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	1     <--- 입력

----------------------------------------------
체크인 작업
----------------------------------------------
* 201~209 : 싱글룸
* 301~309 : 더블룸
* 401~409 : 스위트룸
----------------------------------------------
방 번호 입력 >> 101     <--- 입력
101호 객실은 존재하지 않습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	1     <--- 입력

----------------------------------------------
체크인 작업
----------------------------------------------
* 201~209 : 싱글룸
* 301~309 : 더블룸
* 401~409 : 스위트룸
----------------------------------------------
방 번호 입력 >> 201     <--- 입력
누구를 체크인 하시겠습니까?
이름 입력 >> 홍길동
체크인이 완료되었습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	1     <--- 입력

----------------------------------------------
체크인 작업
----------------------------------------------
* 201~209 : 싱글룸
* 301~309 : 더블룸
* 401~409 : 스위트룸
----------------------------------------------
방 번호 입력 >> 201     <--- 입력
201호 객실은 이미 손님이 있습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	3     <--- 입력

----------------------------------------------
현재 객실 상태
----------------------------------------------
방 번호	 방 종류	 투숙객 이름
----------------------------------------------
201	 싱글룸 	홍길동	
202	 싱글룸 	  -	
203	 싱글룸 	  -	
204	 싱글룸 	  -	
205	 싱글룸 	  -	
206	 싱글룸 	  -	
207	 싱글룸 	  -	
208	 싱글룸 	  -	
209	 싱글룸 	  -	
301	 더블룸 	  -	
302	 더블룸 	  -	
303	 더블룸 	  -	
304	 더블룸 	  -	
305	 더블룸 	  -	
306	 더블룸 	  -	
307	 더블룸 	  -	
308	 더블룸 	  -	
309	 더블룸 	  -	
401	스위트룸	  -	
402	스위트룸	  -	
403	스위트룸	  -	
404	스위트룸	  -	
405	스위트룸	  -	
406	스위트룸	  -	
407	스위트룸	  -	
408	스위트룸	  -	
409	스위트룸	  -	
----------------------------------------------

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	2    <--- 입력

----------------------------------------------
체크아웃 작업
----------------------------------------------
체크아웃 할 방 번호를 입력하세요.
방번호 입력 >> 101    <--- 입력
101호 객실은 존재하지 않습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	2    <--- 입력

----------------------------------------------
체크아웃 작업
----------------------------------------------
체크아웃 할 방 번호를 입력하세요.
방번호 입력 >> 303    <--- 입력
303호 객실에는 체크인 한 사람이 없습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	2    <--- 입력

----------------------------------------------
체크아웃 작업
----------------------------------------------
체크아웃 할 방 번호를 입력하세요.
방번호 입력 >> 201    <--- 입력
201호 객실의 홍길동님 체크아웃을 완료하였습니다.

-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	3    <--- 입력


----------------------------------------------
현재 객실 상태
----------------------------------------------
방 번호	 방 종류	 투숙객 이름
----------------------------------------------
201	 싱글룸 	  -	
202	 싱글룸 	  -	
203	 싱글룸 	  -	
204	 싱글룸 	  -	
205	 싱글룸 	  -	
206	 싱글룸 	  -	
207	 싱글룸 	  -	
208	 싱글룸 	  -	
209	 싱글룸 	  -	
301	 더블룸 	  -	
302	 더블룸 	  -	
303	 더블룸 	  -	
304	 더블룸 	  -	
305	 더블룸 	  -	
306	 더블룸 	  -	
307	 더블룸 	  -	
308	 더블룸 	  -	
309	 더블룸 	  -	
401	스위트룸	  -	
402	스위트룸	  -	
403	스위트룸	  -	
404	스위트룸	  -	
405	스위트룸	  -	
406	스위트룸	  -	
407	스위트룸	  -	
408	스위트룸	  -	
409	스위트룸	  -	
----------------------------------------------


-----------------------------------------------------------
어떤 업무를 하시겠습니까?
1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
-----------------------------------------------------------
선택>>	4    <--- 입력

*********************************************
호텔문을 닫았습니다.
********************************************* 
*/
public class HotelOp {
	public static HashMap<Integer, Room> roomAll = new HashMap<>();
	static HotelOp hotel = new HotelOp();
	static Prints_all pr = new Prints_all();
	static Scanner s = new Scanner(System.in);
	static Room r = new Room();
	public static void main(String[] args)
	{
		
		pr.printOpen();
		hotel:while(true)
		{
			pr.printMenu();
			String menu = s.nextLine();
			switch(menu)
			{
			case "1" :hotel.checkIn();		break;						 //체크인
						
			case "2" :hotel.checkOut(); break;						//체크아웃
			case "3" : hotel.lookRoom(); break; 									//객실상태
			case "4" : pr.printClose();	System.exit(1);			//업무종료
			
			}
			
		}

	}
	//체크아웃
	private void checkOut()
	{
		pr.outCheck();
		int rnum = Integer.parseInt(s.nextLine());
		if(hotel.romChek(rnum)==true){System.out.println(rnum+"호 객실은 존재하지 않습니다.");}
		else if(roomAll.containsKey(rnum)==true)
		{
			String name = roomAll.get(rnum).getCname();
			roomAll.remove(rnum);
			System.out.println(rnum+"호 객실의"+name+"님이 체크아웃을 완료 하였습니다.");
		}else{System.out.println(rnum+"호 객실에는 체크인 한 사람이 없습니다.");}
	}
	
	//객실상태확인
	private void lookRoom()
	{
		pr.lookrom();
		for(int i =2; i <= 4;i++)
		{
			for(int j =1;j < 10;j++)
			{
				String cName= "  -";
				int rNum =Integer.parseInt(i+"0"+j);
				String rName = hotel.roomName(rNum);
				if(roomAll.containsKey(rNum)==true)
				{
					cName =roomAll.get(rNum).getCname();	
				} 
				System.out.printf("%s\t%s\t\t%s\n",rNum,rName,cName);
			}
		}
	}
	
	
	
	//객실상태
	
//	
//	private void lookRoom()
//	{
//		ArrayList<Integer> List = new ArrayList<>(roomAll.keySet());
//		pr.lookrom();
//		for(int key : List)
//		{
//			String Cname =roomAll.get(key).getCname();
//			int Rnum =roomAll.get(key).getRnum();
//			String Rname =roomAll.get(key).getRname();
//			System.out.printf("%s	 %s 	%s\n",Rnum,Rname,Cname);
//		}
//		
//	}
	
	//체크인
	private void checkIn()
	{
		pr.printCheck();
		int rnum = Integer.parseInt(s.nextLine());
		if(hotel.cromChek(rnum)==true){System.out.println(rnum+"호 객실은 이미 손님이 있습니다.");}
		else if(hotel.romChek(rnum)==true){System.out.println(rnum+"호 객실은 존재하지 않습니다.");}
		else{
			
			System.out.println("이름입력>> ");
			String Rname =hotel.roomName(rnum);
			String Cname = s.nextLine();
			r.setCname(Cname);
			r.setRname(Rname);
			r.setRnum(rnum);
			
			roomAll.put(rnum,r);
			System.out.println("체크인 완료되었습니다.");
		}
	}
	
	//방상태확인
	private boolean cromChek(int rnum)
	{
		boolean a = roomAll.containsKey(rnum);
		return a;
	}
	
	
	//방존재확인
	private boolean romChek(int rnum)
	{
		boolean a =rnum/10 != 20&&rnum/10 != 30&&rnum/10 !=40;
		return a;
	}
	//방종류 확인
	private String roomName(int rnum)
	{
		String Rname = (rnum/10 == 20)? "싱글룸":(rnum/10 == 30)? "더블룸":(rnum/10 !=40)?"스위트룸":"스위트룸";
		return Rname;
	}


}

class Room
{
	private int Rnum;
	private String Rname;
	private String Cname;
	public int getRnum() {
		return Rnum;
	}
	public void setRnum(int rnum) {
		Rnum = rnum;
	}
	public String getRname() {
		return Rname;
	}
	public void setRname(String rname) {
		Rname = rname;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	
}

class Prints_all
{
	public void printClose()
	{
		System.out.println("*********************************************");
		System.out.println("       호텔문을 닫았습니다.");
		System.out.println("*********************************************");
	}
	
	public void printOpen()
	{
		System.out.println("*********************************************");
		System.out.println("            호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
	}
	
	public void printMenu()
	{
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.println("선택>> ");
	}
	
	public void printCheck() 
	{
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("* 201~209 : 싱글룸");
		System.out.println("* 301~309 : 더블룸");
		System.out.println("* 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >> ");
		
	}
	
	public void lookrom()
	{
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t방 종류	\t투숙객 이름");
		System.out.println("----------------------------------------------");
		
	}
	
	public void outCheck()
	{
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방번호 입력 >> ");
	}
}