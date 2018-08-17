package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class AddCommand extends Command{
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("4.add command");
			MemberBean member = new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setAge(request.getParameter("age"));
			member.setGender(request.getParameter("gender"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			
			//member.setSubject(ParamMap.getValues(request, "subject"));
			//System.out.println("CreateCommand subject : "+ ParamMap.getValues(request, "subject"));
			MemberServiceImpl.getInstance().add(member);
			request.setAttribute("pagename", "login");
			
			break;
		default:
			break;
		}
		super.execute();
	}
}
