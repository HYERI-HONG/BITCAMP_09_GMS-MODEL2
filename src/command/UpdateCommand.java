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
		setPage("mypage");
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("-----------update command--------------");
			MemberBean member =new MemberBean();
			member.setUserId(((MemberBean)request.getSession().getAttribute("user")).getUserId());
			member.setPassword(String.format("%s/%s"
					,request.getParameter("before_pass")
					,request.getParameter("after_pass")));
			member.setTeamId(request.getParameter("teamId"));
			member.setRoll(request.getParameter("roll"));
			MemberServiceImpl.getInstance().updateMember(member);
			break;
		default:
			break;
		}
		super.execute();
	}
}
