package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.memberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	// Service객체는 Dao객체를 사용하기 때문에
	// Dao객체가 저장될 변수가 필요하다.
	
	private IMemberDao memDao;
	private static MemberServiceImpl service;
	
	//생성자
	private MemberServiceImpl() {
//		memDao = new memberDaoImpl();		//오류 이유 : 싱글톤 패턴적용했기때문
		memDao = memberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null){
			service = new MemberServiceImpl();
		}
		return service;
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

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return memDao.updateMember2(paramMap);
	}

}
