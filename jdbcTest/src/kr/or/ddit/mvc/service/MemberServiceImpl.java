package kr.or.ddit.mvc.service;

import java.util.List;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.memberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	// Service객체는 Dao객체를 사용하기 때문에
	// Dao객체가 저장될 변수가 필요하다.
	
	private IMemberDao memDao;
	
	//생성자
	public MemberServiceImpl() {
		memDao = new memberDaoImpl();
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVO) {
	
		return memDao.updateMember(memVO);
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		return memDao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		
		return memDao.getMemberCount(memId);
	}

}
