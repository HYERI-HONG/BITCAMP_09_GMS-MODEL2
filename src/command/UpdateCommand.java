package command;

import java.util.HashMap;
import java.util.Map;
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
			Map<String,Object> param = new HashMap<>();
			param.put("userid", ((MemberBean)request.getSession().getAttribute("user")).getUserId());
			param.put("before_pass", request.getParameter("before_pass"));
			param.put("after_pass", request.getParameter("after_pass"));
			param.put("teamid", request.getParameter("teamId"));
			param.put("roll", request.getParameter("roll"));
			MemberServiceImpl.getInstance().modify(param);
			break;
		default:
			break;
		}
		super.execute();
	}
}
