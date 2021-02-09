package kr.or.ddit.basic.req_resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int front = Integer.parseInt(request.getParameter("front"));
		int back = Integer.parseInt(request.getParameter("back"));
		String oper = request.getParameter("OP");
		boolean calor= true;
		double sum = (oper.equals("+"))? front+back: 
			(oper.equals("-"))? front-back: 
			(oper.equals("*"))? front*back: 
			(oper.equals("%"))? (double)front%(double)back:
			(oper.equals("/")&&back !=0)? (double)front/(double)back:
			 null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>Request객체</title></head>");
		out.println("<body>");
		out.println("<h2>계산결과</h2>");
		out.println("<hr>");
		
		if(calor == true){
			out.printf("<div>%d%s%d = %s</div>",front,oper,back,sum);
		}
		else {
			out.printf("<div>계산할수없습니다</div>");
		}
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
