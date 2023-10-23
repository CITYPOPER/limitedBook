package limitedBook.controller.sign;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import limitedBook.model.sign.SignDAO;
import limitedBook.model.sign.SignDTO;

public class SignController extends HttpServlet implements Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		request.setCharacterEncoding("utf-8");
		String actionType = request.getParameter("actionType");
		
		HttpSession session = request.getSession();
		
		SignDTO sign;
		SignDAO signDAO;
		ArrayList<SignDTO> signList;
		
		signDAO = new SignDAO();
		boolean result;
		switch( actionType ){
		case "signC": 
			sign = new SignDTO();
			sign.setSignup_name(request.getParameter("signup_name"));
			sign.setSignup_email(request.getParameter("signup_email"));
			sign.setSignup_password(request.getParameter("signup_password"));
			
			result = signDAO.insertSign(sign);
			
			if(result == true){
				JOptionPane.showMessageDialog(null, "회원정보 완료");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/view/etc/error.jsp").forward(request, response);
			}
			break;
			
		case "LOGIN":
			sign = new SignDTO();
			sign.setSignup_email(request.getParameter("signup_email"));
			sign.setSignup_password(request.getParameter("signup_password"));
			result = signDAO.loginSign(sign);
			
			if(result == true){
				String ID = request.getParameter("signup_email");
				String PW = request.getParameter("signup_password");
				
				session.setAttribute("loginState", "login");
	    		session.setAttribute("id", ID);
	    		session.setAttribute("pw", PW);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else{
				JOptionPane.showMessageDialog(null, "회원정보가 일치하지 않습니다.");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			break;
		
		case "LOGOUT":
			session.setAttribute("id", null);
			session.setAttribute("pw", null);
			session.setAttribute("loginState", "logout");
			
			JOptionPane.showMessageDialog(null, "로그아웃되었습니다.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
			
		default:
			break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doProcess(request, response);
	}
}
