package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapUtil;
import kr.or.ddit.vo.MemberVO;
public class memberDaoImpl implements IMemberDao{
	private SqlMapClient smc;
	private static memberDaoImpl dao;	// 1번
	
	private memberDaoImpl() {	// 2번
		smc = SqlMapUtil.getSqlMapClient();
	}
	
	public static memberDaoImpl getInstance() { //3번
		if(dao == null)
		{
			dao = new memberDaoImpl();
		}
		return dao;
	}
	
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		int cnt =0;
		try {
			Object obj = smc.insert("mymember.insertMember", memVo);
			
			if(obj == null) cnt =1;
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt =0;
		try {
			Object obj = smc.delete("mymember.deleteMember", memId);
			
			if(obj == null) cnt =1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
		int cnt =0;
		try {
			Object obj = smc.delete("mymember.updateMember", memVo);
			
			if(obj == null) cnt =1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			list = smc.queryForList("mymember.selectAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		
		int count = 0;
		try {
			Object obj =  smc.queryForObject("mymember.selectone",memId);
			 if(obj ==null) count = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt =0;
				try {
					
					
					Object obj = smc.update("mymember.updateMember2",paramMap);
					if(obj == null) cnt =1;
				} catch (Exception e) {
					cnt=0;
				}finally{
			         if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
			         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
			      }
		return cnt;
	}
	
	
//	@Override
//		public int updateMember2(String memId, String choice String a) {
//			String sql = "";
//			switch(choice)
//			{
//			case "1":
//				sql= "update mymember set mem_name = ? where mem_id = ?";
//				break;
//			case "2":
//				sql ="update mymember set mem_tel = ? where mem_id = ?";
//				break;
//			case "3":sql ="update mymember set mem_name = ? where mem_id = ?";
//				break;
//			default:
//				return 3;
//			}
//			return 0;
//		}	
	
}
