package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander{
	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			System.out.println("---------commander : Move ---------");
			cmd = new MoveCommand(request);
			break;
		case JOIN:
			System.out.println("---------commander : join ---------");
			cmd = new CreateCommand(request);
			break;
		case LOGIN :
			System.out.println("---------commander : login ---------");
			cmd = new LoginCommand(request);
			break;
		case UPDATE :
			System.out.println("---------commander : update ---------");
			cmd = new UpdateCommand(request);
			break;
		case DELETE :
			System.out.println("---------commander : delete ---------");
			cmd = new DeleteCommand(request);
			break;
		case LIST:
			System.out.println("---------commander : member_list ---------");
			cmd = new ListCommand(request);
			break;
		case SEARCH :
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE:
			System.out.println("---------commander : retrieve ---------");
			cmd = new RetrieveCommand(request);
			break;
		case COUNT :
			cmd = new CountCommand(request);
			break;
		default:
			break;
		}
		return cmd;
		
	}

}
