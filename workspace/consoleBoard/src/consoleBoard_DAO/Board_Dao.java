package consoleBoard_DAO;

import java.util.List;

import consoleBoard_VO.MemberVO;

public interface Board_Dao {
	/**
	 * MemberVO값을 입력받아서 회원정보와 글을 게시판DB에 저장하는 메서드
	 * @param MemberVO의 모든 변수값
	 * @return 실패 : false, 성공 : true
	 */
	public boolean board_write(MemberVO newboard);
	/**
	 * 데이터베이스에서 JDBC_BOARD에 있는 모든 정보를 불러오는 메소드
	 * @return MemberVO를 가진 List객체
	 */
	public List<MemberVO> board_call();
	/**
	 * board_no값으로 데이터베이스에서 특정 조건에 맞는
	 * 값들을 받아오는 메소드
	 * @param board_no
	 * @return MemberVO
	 */
	
	public MemberVO board_detail(int board_no);
	/**
	 * 파라미터로 선택한 게시판의 MemberVO값의 특정부분을 수정
	 * 할수 있게 해주는 메소드
	 * @param board_no
	 * @return 실패 : false, 성공 : true
	 */
	public boolean board_alter(int board_no,String board_title,String board_contents);
	/**
	 * 파라미터로 선택한 게시판의 MemberVO값을 삭제하는 메서드
	 * @param board_no
	 * @return 실패 : false, 성공 : true
	 */
	public boolean board_delete(int board_no);
	
	
}
