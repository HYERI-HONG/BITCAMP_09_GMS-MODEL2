package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander{
	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case ADD:
			System.out.println("3.commander : add");
			cmd = new AddCommand(request);
			break;
		case SEARCH:
			System.out.println("3.commander : search");
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE:
			System.out.println("3.commander : retrieve");
			cmd = new RetrieveCommand(request);
			break;
		case MODIFY :
			System.out.println("3.commander : modify");
			cmd = new ModifyCommand(request);
			break;
		case REMOVE :
			System.out.println("3.commander : delete");
			cmd = new RemoveCommand(request);
			break;
		case LOGIN :
			System.out.println("3.commander : login");
			cmd = new LoginCommand(request);
			break;
		case MOVE:
			System.out.println("3.commander : Move");
			cmd = new MoveCommand(request);
			break;
		case FILEUPLOAD:
			System.out.println("3.commander : Fileupload");
			cmd = new FileCommand(request);
			break;
			
		default:
			break;
		}
		return cmd;
		
	}

}
