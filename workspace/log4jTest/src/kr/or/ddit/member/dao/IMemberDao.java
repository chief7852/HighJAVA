package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQl문을 수행하여 결과를 작성해서 Service에 전달하는 interface
 *  
 * 각각의 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * @author PC-03
 *
 */
 	
 

public interface IMemberDao {
	
	
	
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo insert할 데이터가 저장된 MemberVO객체
	 * @return insert 성공 : 1 , 실패시 : 0
	 */
	public int insertMember(MemberVO memVo);
	
	
	/**
	 * 회원ID를 인수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원 ID
	 * @return 삭제 성공 : 1, 삭제 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO자료를 이용하여 회원정보를 Update하는 메서드
	 * @param memVO Update할 회원 정보가 저장된 MemberVO객체
	 * @return 작업성공 : 1, 작업 실패 : 0
	 */
	public int updateMember(MemberVO memVO);
	
	/**
	 * DB전체의 회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @return MemberVO객체를 담고있는 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원 ID를 인수로 받아서 해당 회원의 개수를 반환하는 메서드
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원ID 개수
	 */
	public int getMemberCount(String memId);
	/**
	 * Map의 정보를 이용하여 회원 정보 중 원하는 컬럼을 수정하는 메서드
	 *  Key값 정보 => 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
	 * @param paramMap 수정할 컬럼, 수정할 데이터, 회원 id가 저장된 Map객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateMember2(Map<String,String> paramMap);
}
