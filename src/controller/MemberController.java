package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Carrier;
import command.Receiver;
import enums.Action;


@WebServlet("/member.do") 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("--------------Controller------------");
		Receiver.init(request, response);
		
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())){
		
		case ADD:  
			System.out.println("--------------Controller : join ---------------");
			Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
			break;
		case SEARCH:case RETRIEVE:
			System.out.println("--------------Controller : search ---------------");
			System.out.println("--------------Controller : retrieve ---------------");
			System.out.println("팀 별 멤버 목록\n"+request.getAttribute("search"));
			Carrier.forward(request, response);
			break;
		case MODIFY:
			System.out.println("--------------Controller : update ---------------");
			Carrier.forward(request, response);
			break;
		case REMOVE:
			System.out.println("--------------Controller : delete ---------------");
			Carrier.redirect(request, response,"");
			break;
		case MOVE :
			System.out.println("--------------Controller : move ---------------");
			Carrier.forward(request, response);
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
}
