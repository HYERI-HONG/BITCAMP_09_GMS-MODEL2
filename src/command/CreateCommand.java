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
			MemberServiceImpl.getInstance().createMember(member);
			System.out.println("ID : "+member.getUserId()+"\nPass : "+member.getPassword());
			System.out.println("Name : "+member.getName()+"\nSSN : "+member.getSsn());
			break;
		}
		super.execute();
	}
	
	
	
}