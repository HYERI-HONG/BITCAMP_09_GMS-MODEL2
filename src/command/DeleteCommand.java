package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("-----------delete command--------------");
			MemberBean member = new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().deleteMember(member);
			System.out.println("ID : "+member.getUserId()+"\nPass : "+member.getPassword());
			break;
		}
		super.execute();
	}
}
