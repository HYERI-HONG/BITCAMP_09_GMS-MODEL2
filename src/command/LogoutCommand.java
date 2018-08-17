package command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand extends Command {
	public LogoutCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		execute();
	}
	@Override
	public void execute() {
		request.getSession().invalidate();
		super.execute();
	}
}
