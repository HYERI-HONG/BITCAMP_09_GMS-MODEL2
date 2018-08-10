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

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.admin controller");
		Receiver.init(request, response);
		System.out.println("5.admin controller");
		
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case SEARCH:
			System.out.println("6.carrier : search");
			Carrier.forward(request, response);
			break;	
		case RETRIEVE:
			System.out.println("6.carrier : retrieve");
			Carrier.forward(request, response);
			break;	
		case MOVE :
			System.out.println("6.carrier : move");
			Carrier.forward(request, response);
			break;
		default : 
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
