package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do") 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		
		switch(action){
		case "move" :
			switch(page) {
			case "join_form":
				request.getRequestDispatcher("/WEB-INF/view/member/join_form.jsp").forward(request, response);
				break;
			case "join_result":
				request.getRequestDispatcher("/WEB-INF/view/member/join_result.jsp").forward(request, response);
				break;
			case "user_login_form":
				request.getRequestDispatcher("/WEB-INF/view/member/user_login_form.jsp").forward(request, response);
				break;
			case "user_login_result":
				request.getRequestDispatcher("/WEB-INF/view/member/user_login_result.jsp").forward(request, response);
				break;
			case "update_form":
				request.getRequestDispatcher("/WEB-INF/view/member/update_form.jsp").forward(request, response);
				break;
			case "update_result":
				request.getRequestDispatcher("/WEB-INF/view/member/update_result.jsp").forward(request, response);
				break;
			case "delete_form":
				request.getRequestDispatcher("/WEB-INF/view/member/delete_form.jsp").forward(request, response);
				break;
			case "delete_result":
				request.getRequestDispatcher("/WEB-INF/view/member/delete_result.jsp").forward(request, response);
				break;
			case "memberlist":
				request.getRequestDispatcher("/WEB-INF/view/member/memberlist.jsp").forward(request, response);
				break;
			case "one_member_list_form":
				request.getRequestDispatcher("/WEB-INF/view/member/one_member_list_form.jsp").forward(request, response);
				break;
			case "one_member_list_result":
				request.getRequestDispatcher("/WEB-INF/view/member/one_member_list_result.jsp").forward(request, response);
				break;
			case "some_member_list_form":
				request.getRequestDispatcher("/WEB-INF/view/member/some_member_list_form.jsp").forward(request, response);
				break;
			case "some_member_list_result":
				request.getRequestDispatcher("/WEB-INF/view/member/some_member_list_result.jsp").forward(request, response);
				break;
			}
			break;
		default :
			System.out.println("오류 발생");
			break;
				
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
