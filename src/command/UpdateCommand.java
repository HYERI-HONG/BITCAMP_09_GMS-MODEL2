package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(HttpServletRequest request) {
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
			System.out.println("-----------update command--------------");
			MemberBean member =new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(String.format("%s/%s"
					,request.getParameter("before_pass")
					,request.getParameter("after_pass")));
			MemberServiceImpl.getInstance().updateMember(member);
			System.out.println("ID : "+member.getUserId()+"\nPass : "+member.getPassword());
			break;
		}
		super.execute();
	}
}
