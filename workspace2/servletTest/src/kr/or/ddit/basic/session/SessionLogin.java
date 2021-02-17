package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		// 파라미터로 넘어오는 id와 password를 구한다.
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		if(userid!=null && pass!=null) {
			if(userid.equals("admin") && pass.equals("1234")) {
				// 로그인 성공 했을 때 ==> 로그인한 정보를 세션에 저장한다.
				session.setAttribute("userId", userid);
				
			}
		}
		
		// sessionLogin.jsp 문서로 이동하기
		// 방법1) sendRedirect()이용하기
//		response.sendRedirect(request.getContextPath() + "/basic/03/sessionLogin.jsp");
		
		// 방법2) forward방식 이용하기
		RequestDispatcher rd = request.getRequestDispatcher("/basic/03/sessionLogin.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
