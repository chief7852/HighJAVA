package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {

	// iBatis를 이용하여 DB자료를 처리하는 방법
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 1. ibatis의 환경 설정 파일(sqlMapConfig.xml)을 읽어와 실행
		try {
			//1-1 문자 인코딩 케릭터 셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경 설정 파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경 설정을
			//		진행한 후 SQL문을 호출해서 실행할 객체를 생성한다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			
			//------------------------------------------------

			// 2. 실행할 SQL문에 맞는 문장을 찾아서 호출하여 실행한다.
			
//			// 2-1. insert작업
//			System.out.println("insert작업 시작...");
//			System.out.println("lprod_id 입력 : ");
//			int lprodId = scan.nextInt();
//			
//			System.out.print("lprod_gu 입력 : ");
//			String lprodGu = scan.next();
//			
//			System.out.println("lprod_nm 입력 : ");
//			String lprodNm = scan.next();
//			
//			//저장할 데이터를 VO객체에 담는다.
//			LprodVO lvo = new LprodVO();
//			
//			lvo.setLprod_id(lprodId);
//			lvo.setLprod_gu(lprodGu);
//			lvo.setLprod_nm(lprodNm);
//			
//			// 2) sqlMapClient객체 변수를 이용하여
//			//	  처리할 쿼리문을 호출하여 실행한다.
//			//	형식) smc.insert("namespace값.id속성값", 파라미터클래스);
//			//		반환값 : insert성공 : null, insert실패 : 오류객체
//			Object obj = smc.insert("Lprod.insertLprod", lvo);
//			if(obj == null) {
//				System.out.println("insert 작업 성공!!!");
//			}else {
//				System.out.println("insert 작업 실패~~~");
//			}
//			
//			System.out.println("insert 작업 끝...");
//			
			//--------------------------------------------------------------
//			// 2-2. update작업
//			System.out.println("update작업 시작...");
//			System.out.println("수정할lprod_gu 입력 : ");
//			String lprodGu = scan.next();
//			lprodGu = (lprodGu + "   ").substring(0,4);
//			
//			System.out.print("새로운lprod_Id 입력 : ");
//			int lprodId = scan.nextInt();
//			
//			System.out.println("새로운lprod_nm 입력 : ");
//			String lprodNm = scan.next();
//			
//			//1) 수정할 데이터를 VO 객체에 담는다.
//			LprodVO lvo2 = new LprodVO();
//			lvo2.setLprod_gu(lprodGu);
//			lvo2.setLprod_id(lprodId);
//			lvo2.setLprod_nm(lprodNm);
//			
//			//2) 형식) smc.update("namespace값.id속성값",파라미터클래스);
//			//			반환값 : 성공한 레코드 수
//			int cnt = smc.update("Lprod.updateLprod", lvo2);
//			
//			if(cnt>0) {
//				System.out.println("update 작업 성공!!!");
//			}else {
//				System.out.println("update 작업 실패...");
//			}
//			
//			System.out.println("update 끝...");
			//========================================================
			//2-3. delete 작업
//			System.out.println("delete 작업 시작...");
//			System.out.println("삭제할lprod_gu 입력 : ");
//			String lprodGu = scan.next();
//			lprodGu = (lprodGu + "   ").substring(0,4);
//			
//			//형식) smc.delete("namespace값.id속성값", 파라미터클래스);
//			//		반환값 : 작업에 성공한 레코드 수
//			
//			int cnt2 = smc.delete("Lprod.deleteLprod",lprodGu);
//			
//			if(cnt2>0) {
//				System.out.println("삭제 작업 성공!!!");
//			}else {
//				System.out.println("삭제작업 실패~~~");
//			}
//			
//			System.out.println("delete 작업 끝...");
//			
			// 2-4. select 작업
			
			// 1) 응답 결과가 여러개인 경우
			
//			System.out.println("select한 결과가 여러개 일 경우");
//			
//			// 응답 결과가 여러개일 경우에는 queryForList()메서드를  사용하는데
//			// 이 메서드는 여러개의 레코드 각각은 resultClass에 지정한 VO 클래스에
//			// 담은 후에 이 VO클래스를 List에 추가해 주는 작업을 자동으로 수행한다.
//			
//			// 형식) smc.queryForList("namespace값.id속성값", 파라미터클래스);
//			List<LprodVO> lprodList = smc.queryForList("Lprod.getAllLprod");
//			for(LprodVO lvo : lprodList)
//			{
//				System.out.println("ID : " + lvo.getLprod_id());
//				System.out.println("GU : " + lvo.getLprod_gu());
//				System.out.println("NM : " + lvo.getLprod_nm());
//				System.out.println("--------------------------------");
//			}
//			System.out.println("출력끝...");
			
			// 2) select결과가 1개일 경우
			System.out.println("select한 결과가 1개일 경우");
			System.out.println("검색할 lprod_gu 입력 : ");

			String lprodGu = scan.next();
			lprodGu = (lprodGu + "   ").substring(0,4);
			
			//select한 결과가 1개의 레코드일 경우에는
			//queryForObject()메서드를 사용한다.
			//형식 ) smc.queryForObject("namespace값.id속성값",파라미터클래스)
			LprodVO lprodVo = (LprodVO)smc.queryForObject("Lprod.getLprod",lprodGu);
			if(lprodVo==null)
			{
				System.out.println("검색결과 : 원하는 데이터가 없습니다.");
				return;
			}
			System.out.println("....검색결과.....");
			System.out.println("ID : " + lprodVo.getLprod_id());
			System.out.println("GU : " + lprodVo.getLprod_gu());
			System.out.println("NM : " + lprodVo.getLprod_nm());
			System.out.println("--------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
