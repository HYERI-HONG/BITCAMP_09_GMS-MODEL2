package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage("mypage");
		execute();
	}
	
	public void execute() {
			System.out.println("-----------login command--------------");
			MemberBean member = new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().login(member)) {
				request.setAttribute("match","TRUE");
				request.getSession().setAttribute("user", MemberServiceImpl.getInstance().findById(request.getParameter("userid")));
			}
			else {
				request.setAttribute("match", "FALSE");
			}
		super.execute();
	}
}
