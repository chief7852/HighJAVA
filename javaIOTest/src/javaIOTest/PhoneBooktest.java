package javaIOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
	 문제) 이름, 주소, 전화번호를 멤버로 갖는 phone클래스를 작성하고,
	 	Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	 	
	 	-삭제, 검색 기능은 '이름'을 입력받아서 처리한다.
	 	
	 	(Map의 구조는 key값으로 '이름'을 사용하고 , 
	 	 value값으로는 'Phone클래스의 인스턴스'로 한다.
	 	 
	 	 아래 메뉴의 내용을 프로그램하시오
	-- 추가 조건)
		1) '6. 전화번호 정보 저장' 메뉴를 추가하고 구현한다.
			(저장파일명은 'phoneData.dat'로 한다.)
		2) 프로그램이 시작할 때 저장된 파일이 있으면
		   그 데이터를 읽어와 Map에 셋팅하여 사용한다.
		3) 프로그램을 종료할 때 Map의 데이터가 변경되거나
		   추가 또는 삭제되면 저장한 후 종료되도록 한다.
	 	 실행예시)
	 	 ------------------------
	 	 다음메뉴를 선택하세요.
	 	 1. 전화번호 등록
	 	 2. 전화번호 수정
	 	 3. 전화버호 삭제
	 	 4. 전화번호 검색
	 	 5.전화번호 전체 출력
	 	 0.프로그램 종료
	 	 -----------------------
	 	 번호입력 >> 1
	 	 
	 	 새롭게 등록할 전화번호 정보를 입력하세요.
	 	 이름 >>
	 	전화번호 >> 
	 	주소 >>
	 	
	 	
	 	 ------------------------
	 	 다음메뉴를 선택하세요.
	 	 1. 전화번호 등록
	 	 2. 전화번호 수정
	 	 3. 전화버호 삭제
	 	 4. 전화번호 검색
	 	 5.전화번호 전체 출력
	 	 0.프로그램 종료
	 	 -----------------------
	 	 번호입력 >> 1
	 	 
	 	 새롭게 등록할 전화번호 정보를 입력하세요.
	 	 이름 >>
	 	전화번호 >> 
	 	주소 >>
	 	
	 	<홍길동)홍길동은 이미 등록된 사람입니다.
	 
	 	------------------------
	 	 다음메뉴를 선택하세요.
	 	 1. 전화번호 등록
	 	 2. 전화번호 수정
	 	 3. 전화버호 삭제
	 	 4. 전화번호 검색
	 	 5.전화번호 전체 출력
	 	 0.프로그램 종료
	 	 -----------------------
	 	 번호입력 >> 5
	 	 
	 	 ------------------------------
	 	  번호     이름    전화번호 		주소
	 	 ------------------------------	 	 
	 	 1      홍길동   010-1111-1111   대전시 중구 대흥동
	 	 ~~~~
	 	 ~~~~ 
	 	 ------------------------------	 
	 	 출력완료..
	 	 ------------------------------
	 	 
	 	 ------------------------
	 	 다음메뉴를 선택하세요.
	 	 1. 전화번호 등록
	 	 2. 전화번호 수정
	 	 3. 전화버호 삭제
	 	 4. 전화번호 검색
	 	 5.전화번호 전체 출력
	 	 0.프로그램 종료
	 	 -----------------------
	 	 번호입력 >> 0
	 	 
	 	 프로그램종료....
	 */
public class PhoneBooktest {
	public static HashMap<String, Phone> phoneBookMap=new HashMap<>();
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) 
	{
		PhoneBooktest p = new PhoneBooktest();
		
		p.fileCall();
		System.out.println("");
		nojam:while(true)
		{
			p.printer();
			String choi = s.nextLine();
			switch(choi)
			{
			case "1" :p.numAdd();break;
			case "2" :if(phoneBookMap.size()==0)
						{System.out.println("아무 정보가 없습니다");break;}
						p.numAlter();break;
			case "3" :if(phoneBookMap.size()==0)
						{System.out.println("아무 정보가 없습니다");break;}
						p.numDel();break;

			case "4" :if(phoneBookMap.size()==0)
						{System.out.println("아무 정보가 없습니다");break;}
						p.numSer();break;
			case "5" :if(phoneBookMap.size()==0)
						{System.out.println("아무 정보가 없습니다");break;}
						p.numAll();break;
			case "6" :
			case "0" :p.fileSet();break nojam;

			}
		}
	}
	void fileSet() {
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/phoneData.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
				
				oos.writeObject(phoneBookMap);
				
			
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	void fileCall()
	{
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("d:/d_other/phoneData.dat")));
			Object obj;// 읽어온 객체를 저장할 변수
			try {
					phoneBookMap = (HashMap<String, Phone>)ois.readObject();


			} catch (EOFException e) {
				// TODO: handle exception
			}catch (ClassNotFoundException e) {
				// TODO: handle exception
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//전화번호 등록
	private void numAdd()
	{
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = s.nextLine();
		if(phoneBookMap.containsKey(name)==true){System.out.println("이미 있는번호입니다.");}
		else{
		System.out.print("전화번호 >> ");
		String tel = s.nextLine();
		System.out.print("주소>> ");
		String addr = s.nextLine();
		Phone phone = new Phone(addr,name,tel);
		phoneBookMap.put(name,phone);
		}
		
			
	}
	
	private void numAlter()
	{
		System.out.println("고칠 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name =s.nextLine();
		if(phoneBookMap.containsKey(name)==true)
		{
			System.out.print("전화번호 >> ");
			String tel = s.nextLine();
			System.out.print("주소>> ");
			String addr = s.nextLine();
			phoneBookMap.get(name).setTel(tel);
			phoneBookMap.get(name).setAddr(addr);
		}
		else {System.out.println("존재 하지 않는 번호입니다.");}
	}
	
	private void numDel()
	{
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name =s.nextLine();
		if(phoneBookMap.containsKey(name)==true)
		{
			System.out.println("삭제되었습니다.");
			phoneBookMap.remove(name);
		}else{System.out.println("존재 하지 않는 번호입니다.");}
	}
	
	private void numSer()
	{
		System.out.println("찾고싶은 전화번호의 이름을 입력하세요.");
		System.out.print("이름 >> ");
		String name =s.nextLine();
		if(phoneBookMap.containsKey(name)==true)
		{
			String addr =phoneBookMap.get(name).getAddr();
			String tel = phoneBookMap.get(name).getTel();
			
			System.out.println("이름 : "+name+"번호 : "+tel+"주소 : "+addr);
			
		}else{System.out.println("존재 하지 않는 번호입니다.");}
	}
	
	private void numAll()
	{
		ArrayList<String> List = new ArrayList<>();
		int i=phoneBookMap.size();
		System.out.println("------------------------------"
				+"\n번호\t이름\t전화번호\t주소"
				+"\n------------------------------");
		for(String key : phoneBookMap.keySet())
		{
			
			String addr =phoneBookMap.get(key).getAddr();
			String name =phoneBookMap.get(key).getName();
			String tel =phoneBookMap.get(key).getTel();
			System.out.println(i+"\t"+name+"\t"+tel+"\t"+addr);
			i--;
		}
		
	}
	
	private void printer()
	{
		System.out.print("------------------------"
				+ "\n1. 전화번호 등록"
				+ "\n2. 전화번호 수정"
				+ "\n3. 전화번호 삭제"
				+ "\n4. 전화번호 검색"
				+ "\n5. 전체 전화번호 출력"
				+ "\n0. 프로그램종료"
				+ "\n------------------------"
				+ "\n번호입력>>");
	}
}




class Phone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6785147595104569567L;
	private String name;
	private String tel;
	private String addr;
	
	
	public Phone(String name, String tel,String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public String getName() {
		return name;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
