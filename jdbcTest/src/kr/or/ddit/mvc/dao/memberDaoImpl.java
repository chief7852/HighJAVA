package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

public class memberDaoImpl implements IMemberDao{

	private static memberDaoImpl dao;	// 1번
	
	private memberDaoImpl() {	// 2번
		
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
		Connection conn = null;
		int cnt =0;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "insert into mymember "
		               + " (mem_id, mem_name, mem_tel, mem_addr) "
		               + " values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			 if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt =0;
		try {
			
			conn = DBUtil3.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt =0;
		try {
			String sql ="update mymember set mem_name = ? , mem_tel ,mem_addr where mem_id = ?";;
			conn = DBUtil3.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, memVo.getMem_id());
			pstmt.setString(1, memVo.getMem_name());
			pstmt.setString(2, memVo.getMem_tel());
			pstmt.setString(3, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			 if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			String sql = "select * from mymember";
			conn = DBUtil3.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MemberVO vo = new MemberVO(rs.getString("mem_id"),
										   rs.getString("mem_name"),
										   rs.getString("mem_tel"),
										   rs.getString("mem_addr"));			
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
	         if(rs != null){try {rs.close();   } catch (Exception e2) { }};
	         if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
	      }
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			 conn = DBUtil.getConnection();
	         String sql = "select count(*) cnt from mymember WHERE mem_id = ?";
	            pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memId);
	         rs = pstmt.executeQuery();
	         if(rs.next()){
	            count = rs.getInt("cnt");
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
	         if(rs != null){try {rs.close();   } catch (Exception e2) { }};
	         if(pstmt != null){try {pstmt.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
	      }
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt =0;
				try {
					conn = DBUtil3.getConnection();
					
					String sql = "update mymember set "
							+ paramMap.get("field") +" = ?"
							+ " where mem_id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, paramMap.get("data"));
					pstmt.setString(2, paramMap.get("memid"));
					cnt = pstmt.executeUpdate();
					
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
