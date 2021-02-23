package kr.or.ddit.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.web.IAction;

public class MemberUpdateAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");
		String mem_addr = request.getParameter("mem_addr");

		MemberVO memVO = new MemberVO();

		memVO.setMem_id(mem_id);
		memVO.setMem_name(mem_name);
		memVO.setMem_tel(mem_tel);
		memVO.setMem_addr(mem_addr);

		IMemberService service = MemberServiceImpl.getInstance();
		service.updateMember(memVO); // DB에

		return "/member/memberList.ddit";
	}

}
