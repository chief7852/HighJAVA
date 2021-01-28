package consoleBoard_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import consoleBoard_VO.MemberVO;
import kr.or.ddit.mvc.util.DBUtil3;

public class consoleBoard_Daoimpl implements Board_Dao {

	@Override
	public boolean board_write(MemberVO newboard) {
		Connection conn = DBUtil3.getConnection();
		PreparedStatement pre = null;
		boolean tf = false;
		try {
			String sql = "insert into jdbc_board (board_no,board_title,board_writer,"
					+ " board_date,board_cnt,board_content)"
					+ " values(board_seq.nextVal,?,?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, newboard.getTitle());
			pre.setString(2, newboard.getWriter());
			pre.setString(3, newboard.getDate());
			pre.setInt(4, newboard.getCnt());
			pre.setString(5, newboard.getContent());
			
			tf = (pre.executeUpdate()==0)? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pre != null)try {pre.close();}catch(Exception e) {}
			if(conn != null)try {pre.close();}catch(Exception e) {}
		}
		return tf;
	}

	@Override
	public List<MemberVO> board_call() {
		Connection conn = DBUtil3.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			String sql = "select board_no, board_title,board_writer"
					+ ",board_cnt from jdbc_board";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next())
			{
				MemberVO vo = new MemberVO(rs.getInt("board_no"),
											rs.getString("board_title"),
											rs.getString("board_writer"),
											rs.getInt("board_cnt"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)try {conn.close();}catch(Exception e) {}
			if(pre != null)try {pre.close();}catch(Exception e) {}
			if(rs != null)try {rs.close();}catch(Exception e) {}
		}
		return list;
	}

	@Override
	public MemberVO board_detail(int board_no) {
		Connection conn = DBUtil3.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		MemberVO vo = new MemberVO();
		boolean tf = false;
		try {
			String sql = "select * from jdbc_board where board_no = ?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, board_no);
			rs = pre.executeQuery();
			
			while(rs.next())
			{
				
				vo.setTitle(rs.getString("board_title"));
				vo.setWriter(rs.getString("board_writer"));
				vo.setContent(rs.getString("board_content"));
				vo.setDate(rs.getString("board_date"));
				vo.setCnt(rs.getInt("board_cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null){try {rs.close();   } catch (Exception e2) { }};
	         if(pre != null){try {pre.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
		}
		
		return vo;
	}

	

	@Override
	public boolean board_alter(int board_no,String board_title,String board_contents) {
		Connection conn = DBUtil3.getConnection();
		PreparedStatement pre = null;
		boolean tf = false;
		try {
			String sql = "update jdbc_board set board_title = ? "
					+ ",board_content =? where board_no =?";
			pre = conn.prepareStatement(sql);
			pre.setInt(3, board_no);
			pre.setString(1, board_title);
			pre.setString(2, board_contents);
			
			tf = (pre.executeUpdate()==0)? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 if(pre != null){try {pre.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
		}
		return tf;
	}

	@Override
	public boolean board_delete(int board_no) {
		Connection conn = DBUtil3.getConnection();
		PreparedStatement pre = null;
		boolean tf = false;
		try {
			String sql = "delete from jdbc_board where BOARD_NO = ?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, board_no);
			
			
			tf = (pre.executeUpdate()==0)? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 if(pre != null){try {pre.close();   } catch (Exception e2) { }};
	         if(conn != null){try {conn.close();   } catch (Exception e2) { }};
		}
		return tf;
	}



}
