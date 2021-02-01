package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

// jdbcTest 프로젝트에 있는 jdbcTest 06.java 의 처리방법을
// ibatis를 이용하여 처리하는 것으로 변경하시오.


//쿼리문이 저장될 xml문서 이름은 'jdbc06.xml'로 한다.

public class JdbcTest06Toibatis {

public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			try {
				
				Charset charset = Charset.forName("UTF-8");
				Resources.setCharset(charset);
				
				Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
				
				SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
				rd.close();
				
				System.out.println("상품 번호를 입력하시오");
				String lprod_Gu = sc.nextLine();

				LprodVO lprodVo = (LprodVO)smc.queryForObject("lprod.checklprod",lprod_Gu);
				if(lprodVo!=null)
				{
					System.out.println("이미 있는 상품번호입니다.");
					return;
				}
				
				int gumax = (Integer)smc.queryForObject("lprod.maxgu");
				
				
				System.out.println("상품 이름을 입력하시오");
				String lprod_Name = sc.nextLine();
				lprodVo = new LprodVO();
				
				lprodVo.setLprod_gu(lprod_Gu);
				lprodVo.setLprod_nm(lprod_Name);
				lprodVo.setLprod_id(gumax);
				
				
				Object obj = smc.insert("lprod.insertlprod",lprodVo);
				if(obj == null) {
					System.out.println("insert 작업 성공!!!");
				}else {
					System.out.println("insert 작업 실패~~~");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		

	}


}
