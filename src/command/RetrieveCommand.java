package command;

import javax.servlet.http.HttpServletRequest;


import enums.Domain;
import service.MemberServiceImpl;


public class RetrieveCommand extends Command {
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			request.setAttribute("retrive", MemberServiceImpl.getInstance().findById(request.getParameter("userid")));
			break;
		case ADMIN:
			request.setAttribute("retrive", MemberServiceImpl.getInstance().findById(request.getParameter("userid")));
			break;
		default:
			break;
		}
		super.execute();
	}
	
}
