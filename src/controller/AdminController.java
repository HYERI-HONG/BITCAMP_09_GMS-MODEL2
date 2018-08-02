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
		Sentry.init(request, response);
		
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE :
				Carrier.forward(request, response);
			break;
		case LIST:
			System.out.println("--LIST--");
			Carrier.forward(request, response);
			break;
		case RETRIEVE:
			System.out.println("--RETRIEVE--");
			Carrier.forward(request, response);
			break;	
		case SEARCH:
			System.out.println("--SEARCH--");
			Carrier.forward(request, response);
			break;	
		case COUNT:
			MemberServiceImpl.getInstance().memberCount();
		default : 
				Carrier.redirect(request, response, "");
			break;
		}
	}
}
