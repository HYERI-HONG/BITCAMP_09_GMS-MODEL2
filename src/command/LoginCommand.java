package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}
	
	public void execute() {
			System.out.println("4.login command");
			MemberBean member =new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			MemberBean mem = MemberServiceImpl.getInstance().login(member);
			
			if(mem!=null) {
				System.out.println("login 성공");
				request.setAttribute("match","TRUE");
				request.getSession().setAttribute("user",mem);
				Map<String, Object> map = ImageServiceImpl.getInstance().retrieve(mem.getUserId());
				String imgPath = "/upload/"+(String)map.get("filename")+"."+(String)map.get("extension");
				System.out.println("통합된 파일명 : "+ imgPath);
				request.setAttribute("imgpath",imgPath);
			}
			else {
				request.setAttribute("match", "FALSE");
				System.out.println("login 실패");
			}
			request.setAttribute("pagename", "retrieve");
		super.execute();
	}
}
