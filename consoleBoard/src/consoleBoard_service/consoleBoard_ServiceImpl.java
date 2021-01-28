package consoleBoard_service;

import java.util.List;

import consoleBoard_DAO.Board_Dao;
import consoleBoard_DAO.consoleBoard_Daoimpl;
import consoleBoard_VO.MemberVO;

public class consoleBoard_ServiceImpl implements consoleBoard_Service {

	private Board_Dao board_dao;
	
	
	public consoleBoard_ServiceImpl() {
		board_dao = new consoleBoard_Daoimpl();
	}

	@Override
	public boolean board_write(MemberVO newboard) {
		// TODO Auto-generated method stub
		return board_dao.board_write(newboard);
	}

	@Override
	public List<MemberVO> board_call() {
		// TODO Auto-generated method stub
		return board_dao.board_call();
	}

	@Override
	public MemberVO board_detail(int board_no) {
		// TODO Auto-generated method stub
		return board_dao.board_detail(board_no);
	}

	@Override
	public boolean board_alter(int board_no, String board_title, String board_contents) {
		// TODO Auto-generated method stub
		return board_dao.board_alter(board_no, board_title, board_contents);
	}

	@Override
	public boolean board_delete(int board_no) {
		// TODO Auto-generated method stub
		return board_dao.board_delete(board_no);
	}

}
