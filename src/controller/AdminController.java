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
import service.MemberServiceImpl;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		System.out.println("--AdminController()--");
		Sentry.init(request, response);
		System.out.println("액션 : " + Sentry.cmd.getAction());
		
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE :
				System.out.println("MOVE");
				Carrier.forward(request, response);
		
			//request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
			// DB접근하지 않아도 될 case와
			break;
		
	/*	case LOGIN:
			System.out.println("--LOGIN--");
			if(request.getAttribute("match").equals("TRUE")){
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response, "/admin.do?action=move&page=main");
			}
			break;*/
		case LIST:
			System.out.println("--LIST--");
			Carrier.redirect(request, response, "");
			break;
		case RETRIEVE:
			System.out.println("--USERID--");
			Carrier.redirect(request, response, "");
			break;	
		case COUNT:
			MemberServiceImpl.getInstance().memberCount();
			System.out.println("회원수 : " + MemberServiceImpl.getInstance().memberCount());
		default : 
				Carrier.redirect(request, response, "");
			break;
		}
		
	}

}
