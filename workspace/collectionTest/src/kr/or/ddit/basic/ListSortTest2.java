package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest2 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(10, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		System.out.println("정렬 전...");
		for(Member mem : memList)
		{
			System.out.println(mem);
		}
		System.out.println("----------------------------------------");
		// 회원 이름의 오름차순 정렬하기 (내부정렬 기준 이용)
		Collections.sort(memList , new SortNumDesc());
		for(Member mem : memList)
		{
			System.out.println(mem);
		}
		System.out.println("----------------------------------------");
		System.out.println();
		
		// 회원 번호의 내림차순으로 정렬하기(외부 정렬 기준으로..)
	}

}


// Member 클래스의 회원이름의 오름차순 정렬이 되도록 하는 내부정렬 기준 구현하기
// ==> Comparable인터페이스를 구현한
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
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


	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	@Override
	public int compareTo(Member mem) {
		// 회원 이름의 오름차순 정렬 기준 만들기
		return this.name.compareTo(mem.getName());
		//내림차순일 경우
//		return this.name.compareTo(mem.getName())*-1;
	}
	
}

// 회원 번호의 내림차순 정렬이 되도록하는 외부정렬 기준 클래스 작성하기

class SortNumDesc implements Comparator<Member>
{
	@Override
	public int compare(Member x, Member y) {
//		if(x.getNum()>y.getNum())
//		{
//			return -1;
//		}else if(x.getNum() < y.getNum())
//		{
//			return 1;
//		}else
//		{
//			return 0;
//		}
		// Wrapper 클래스를 이용하는 방법1
//		return new Integer(x.getNum()).compareTo(y.getNum())*-1;
		
		// Wrapper 클래스를 이용하는 방법2
		return Integer.compare(x.getNum(), y.getNum()) * -1;
	}
}
