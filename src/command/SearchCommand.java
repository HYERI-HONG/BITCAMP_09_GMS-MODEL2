package command;

import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
			request.setAttribute("member", MemberServiceImpl.getInstance().findByWord(request.getParameter("teamname")));
			break;
		case ADMIN :
			String word = request.getParameter("searchOption")+"/"+request.getParameter("searchWord");
			request.setAttribute("list",MemberServiceImpl.getInstance().findByWord(word));
			break;
		
		default:
			break;
		}
		super.execute();
	}
}
