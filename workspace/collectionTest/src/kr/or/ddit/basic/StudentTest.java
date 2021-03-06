package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    문제 ) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를
    	멤버로 갖는 Student클래스를 작성한다.
    	이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 
    	매개변수로 받아서 초기화 처리한다.
    	
    	이 Student객체는 List에 저장하여 관리한다.
    	
    	List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 
    	내부정렬 기준을 구현하고 ,
    	
    	총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는
    	외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
    	
    	(등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */
public class StudentTest {
	
	//등수를 구하는 메서드
	public void setRanking(List<Student> stdList)
	{
		for(int i=0; i <stdList.size(); i++)
		{
			int rank=1;
			for(int j =0; j<stdList.size();j++)
			{
				if(stdList.get(i).getSum() < stdList.get(j).getSum()){
				rank++;	
				}
				stdList.get(i).setRank(rank);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Student> stuDent = new ArrayList<>();
		stuDent.add(new Student(19,"홍준표",38,59,82));
		stuDent.add(new Student(15,"송재욱",48,52,92));
		stuDent.add(new Student(23,"정이삭",53,92,8));
		stuDent.add(new Student(23,"진호현",53,92,8));
		stuDent.add(new Student(34,"이준혁",89,79,88));
		System.out.println("정렬 전...");
		for(Student stu : stuDent)
		{
			System.out.println(stu);
		}
		Collections.sort(stuDent , new SortSNum());
		System.out.println(stuDent);
		
		
		for(int i =0; i <stuDent.size();i++)
		{
			stuDent.get(i).setRank(i+1);
		}
		
		
		
		for(Student stu : stuDent)
		{
			System.out.println(stu);
		}
	}

}
class Student implements Comparable<Student>
{
	private int snum ;
	private String name;
	private int kor ;
	private int eng ;
	private int math ;
	private int sum ;
	private int rank ;
	
	
	public Student(int snum, String name, int kor, int eng, int math) {
		super();
		this.snum = snum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = this.kor+this.eng+this.math;
		this.rank = rank;
	}
	


	public int getSnum() {
		return snum;
	}



	public void setSnum(int snum) {
		this.snum = snum;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getKor() {
		return kor;
	}



	public void setKor(int kor) {
		this.kor = kor;
	}



	public int getEng() {
		return eng;
	}



	public void setEng(int eng) {
		this.eng = eng;
	}



	public int getMath() {
		return math;
	}



	public void setMath(int math) {
		this.math = math;
	}



	public int getSum() {
		return sum;
	}



	public void setSum(int sum) {
		this.sum = sum;
	}



	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString(){
		return "Student [snum=" + snum + ", name="+ name + ", kor=" + kor + ", eng=" + eng + ", math=" + math +
				", sum="+ sum +", rank="+rank+"]";
	}

	@Override
	public int compareTo(Student stu) {
		return new Integer(this.snum).compareTo(stu.getSnum());
	}
}

class SortSNum implements Comparator<Student>
{
	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getSum() == stu2.getSum())
		{
			return new Integer (stu1.getSnum()).compareTo(stu2.getSnum());
		}else{
		return new Integer(stu1.getSum()).compareTo(stu2.getSum())* -1;
		}	
		}
}