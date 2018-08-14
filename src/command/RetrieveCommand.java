package command;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;


public class RetrieveCommand extends Command {
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			request.setAttribute("user", MemberServiceImpl.getInstance().retrieve(((MemberBean)request.getSession().getAttribute("user")).getUserId()));
			Map<String, Object> map = ImageServiceImpl.getInstance().retrieve(((MemberBean)request.getSession().getAttribute("user")).getUserId());
			String imgPath = "/upload/"+(String)map.get("filename")+"."+(String)map.get("extension");
			request.setAttribute("imgpath",imgPath);
			request.setAttribute("pagename", "retrieve");
			break;
		case ADMIN:
			System.out.println("4.retrieve command");
			List <MemberBean> list = new ArrayList<>();
			list.add(MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
			request.setAttribute("list",list);
			request.setAttribute("pagename", "search");
			
			break;
		default:
			break;
		}
		super.execute();
	}
	
}
