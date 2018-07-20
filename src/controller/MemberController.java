package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Carrier;
import command.Sentry;
import enums.Action;


@WebServlet("/member.do") 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------Controller------------");
		Sentry.init(request, response);
		
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())){
		case MOVE :
			System.out.println("--------------Controller : move ---------------");
			Carrier.forward(request, response);
			break;
		case JOIN:  
			System.out.println("--------------Controller : join ---------------");
			Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
			break;
		case LIST:
			System.out.println("--------------Controller : list ---------------");
			System.out.println("전체 멤버 목록\n"+request.getAttribute("list"));
			Carrier.forward(request, response);
			break;
		case SEARCH:
			System.out.println("--------------Controller : search ---------------");
			System.out.println("팀 별 멤버 목록\n"+request.getAttribute("search"));
			Carrier.redirect(request, response,"");
			break;
		case RETRIEVE:
			System.out.println("--------------Controller : retrieve ---------------");
			System.out.println("해당 ID의 멤버 목록\n"+request.getAttribute("retrive"));
			Carrier.redirect(request, response,"");
			break;
		case COUNT:
			System.out.println("--------------Controller : count ---------------");
			System.out.println("전체 멤버 수\n"+request.getAttribute("count"));
			Carrier.forward(request, response);
			break;
		case UPDATE:
			System.out.println("--------------Controller : update ---------------");
			Carrier.redirect(request, response,"");
			break;
		case DELETE:
			System.out.println("--------------Controller : delete ---------------");
			Carrier.redirect(request, response,"");
			break;
		case LOGIN:
			System.out.println("--------------Controller : login ---------------");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
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
