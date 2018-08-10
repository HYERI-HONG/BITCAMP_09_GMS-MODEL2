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
		System.out.println("1.Member Controller");
		Receiver.init(request, response);
		System.out.println("9.Member Controller");
		
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())){
		
		case ADD:  
			System.out.println("10.Controller : add");
			Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
			break;
		case SEARCH:case RETRIEVE:
			System.out.println("10.Controller : search/retrieve");
			Carrier.forward(request, response);
			break;
		case MODIFY:
			System.out.println("10.Controller : modify");
			Carrier.forward(request, response);
			break;
		case REMOVE:
			System.out.println("10.Controller : remove");
			Carrier.redirect(request, response,"");
			break;
		case MOVE :
			System.out.println("10.Controller : move");
			Carrier.forward(request, response);
			break;
		case LOGIN:
			System.out.println("10.Controller : login");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
			}
			break;
		default :
			System.out.println("오류 발생");
			break;	
		}

	}
}
