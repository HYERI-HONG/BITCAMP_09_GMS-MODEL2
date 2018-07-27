package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command{
	//생성자
	public CreateCommand(HttpServletRequest request) {
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
			System.out.println("-----------create command--------------");
			MemberBean member = new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			
			member.setAge(request.getParameter("age"));
			member.setGender(request.getParameter("gerder"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			//member.setSubject(ParamMap.getValues(request, "subject"));
			System.out.println("CreateCommand subject : "+ ParamMap.getValues(request, "subject"));
			
			MemberServiceImpl.getInstance().createMember(member);
			
			System.out.println("ID : "+member.getUserId()+"\nPass : "+member.getPassword());
			System.out.println("Name : "+member.getName()+"\nSSN : "+member.getSsn());
			System.out.println("Age : "+member.getAge()+"\nGenter : "+member.getGender());
			System.out.println("Team : "+member.getTeamId()+"\nRoll : "+member.getRoll());
			System.out.println("Subject : "+ParamMap.getValues(request, "subject"));
			break;
		}
		super.execute();
	}
	
	
	
}
