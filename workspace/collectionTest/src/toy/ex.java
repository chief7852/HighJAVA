package toy;

import java.util.HashMap;
import java.util.Scanner;

public class ex {
	


		static Scanner sc = new Scanner(System.in);
		static HashMap<Integer, Room> rooms = new HashMap<>();

		public static void main(String[] args) {
			for(int i=200,j=1; i+j<410; j++) {
				rooms.put(i+j, new Room(i+j));
				if(j==9) {
					j=0;
					i+=100;
				}
			}
			
			ex hotel = new ex();
			hotel.welcome();
			
			while(true) {
				System.out.print("-----------------------------------------------------------\r\n"
						+ "어떤 업무를 하시겠습니까?\r\n"
						+ "1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료\r\n"
						+ "-----------------------------------------------------------\n>");
				switch(sc.nextLine()){
				case "1": hotel.checkIn(); 	break;
				case "2": hotel.checkOut();	break;
				case "3": hotel.overView(); break;
				case "4": System.exit(1);;
				}  
			}

		}
		
		void overView() {
			System.out.println("----------------------------------------------\r\n"
					+ "		현재 객실 상태\r\n"
					+ "----------------------------------------------\r\n"
					+ "방 번호\t방 종류\t투숙객이름\r\n"
					+ "----------------------------------------------");
			
			for(int i=200,j=1; i+j<410; j++) {
				System.out.println(rooms.get(i+j).toString());
				if(j==9) {
					j=0;
					i+=100;
				}
			}
		}
		
		void checkOut() {
			System.out.print("----------------------------------------------\r\n"
					+ "   체크아웃 작업\r\n"
					+ "----------------------------------------------\r\n"
					+ "체크아웃 할 방 번호를 입력하세요.\r\n"
					+ "방번호 입력 >> ");
			String input = sc.nextLine();
			try {
				int roomNum = Integer.parseInt(input);
				if(rooms.get(roomNum).getName().equals(null)) {	//
					System.out.println(roomNum+"호 객실에는 체크인 한 사람이 없습니다.");
				}else {
					String name = rooms.get(roomNum).getName();
					System.out.println(name+"님의 "+roomNum+" 호 체크아웃이 완료되었습니다.");
					rooms.get(roomNum).setName(null);
				}
			}catch (Exception e) {
				System.out.println(input + "객실은 존재하지 않습니다.");
				checkOut();
			}finally {
			}
		}

		void checkIn() {
			System.out.print("----------------------------------------------\r\n"
					+ "   체크인 작업\r\n"
					+ "----------------------------------------------\r\n"
					+ " * 201~209 : 싱글룸\r\n"
					+ " * 301~309 : 더블룸\r\n"
					+ " * 401~409 : 스위트룸\r\n"
					+ "----------------------------------------------\r\n"
					+ "방 번호 입력 >>");
			String input = sc.nextLine();
			try {
				int roomNum = Integer.parseInt(input);
				if(rooms.get(roomNum).getName() != null) {
					System.out.println(roomNum+"호 객실은 이미 손님이 있습니다.");
				}else {
					System.out.print("누구를 체크인 하시겠습니까? \n이름 입력 >>");
					String name = sc.nextLine();
					rooms.get(roomNum).setName(name);
					System.out.println(name+"님의 "+roomNum+" 호 체크인이 완료되었습니다.");
				}
			}catch (Exception e) {
				System.out.println(input + "객실은 존재하지 않습니다.");
				checkIn();
			}finally {
			}


		}

		void welcome(){
			System.out.println("*********************************************\r\n"
					+ "       호텔문을 열었습니다. 어서오십시요.\r\n"
					+ "*********************************************");

		}

	}

	class Room{
		private String name;
		private int roomNumber;
		private String roomType;

		public Room(int roomNumber){
			this.roomNumber = roomNumber;
			switch(roomNumber/100) {
			case 2:	roomType = "싱글룸"; 	break;
			case 3:	roomType = "더블룸";	break;
			case 4:	roomType = "스위트룸";	break;
			}
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getRoomNumber() {
			return roomNumber;
		}
		@Override
		public String toString() {
			String tempName;
			if(this.name == null)
				tempName = "-";
			else tempName = this.name;
			return roomNumber + " \t" + roomType + "\t" + tempName;
		}
		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}
		public String getRoomType() {
			return roomType;
		}
		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}
	}