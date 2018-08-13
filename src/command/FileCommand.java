package command;

import javax.servlet.http.HttpServletRequest;
import enums.Domain;


public class FileCommand extends Command {
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())){
		case MEMBER:
			System.out.println("4.File upload command");
			break;
		default:
			break;
		}
		super.execute();
	}
}
