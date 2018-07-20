package command;

import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}
@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())){
		case MEMBER:
			System.out.println("-----------memberlist command--------------");
			request.setAttribute("list", MemberServiceImpl.getInstance().memberList());
			break;
		}
		super.execute();
	}

}
