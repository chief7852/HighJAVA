package kr.or.ddit.basic.req_resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Choose;

/**
 * Servlet implementation class requestTest02
 */
@WebServlet("/RequestTest02.do")
public class requestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String strNum1 = request.getParameter("num1");
		String op = request.getParameter("cal");
		String strNum2 = request.getParameter("num2");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		double result = 0;	// 계산된 결과가 저장될 변수
		boolean calOk = true;	// 계산 성공 여부를 저장하는 변수
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		switch(op) {
			case "+" : result = num1 + num2; break;
			case "-" : result = num1 - num2; break;
			case "*" : result = num1 * num2; break;
			case "/" : if(num2!=0) {
		         result = (double)num1/num2;
		      }else {
		         calOk = false;} break;
			case "%" : if(num2!=0) {
		         result = (double)num1 % num2;
		      }else {
		         calOk = false;
		      
		      } break;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body>");
		
		out.println("<hr><h2> 계산결과 </h2>");
		out.println("<hr>");
		// out.printf("%d %s %d = %f", num1, op, num2, result);
		out.printf("%d %s %d = ", num1, op, num2);
		
		// 계산 성공 여부를 확인해서 결과를 출력한다.
		if(calOk==true) {	// 정상적인 계산이 완료되었으면 결과 출력
			out.println(result);
		} else { // 분모가 0일때 나눗셈이나 나머지 연산을 했을 때 
			out.println("계산 불능 (0으로 나누기)");
		}
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
