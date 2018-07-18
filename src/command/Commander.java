package command;

import enums.Action;

public class Commander{
	public static Command order(String domain, String action, String page) {
		Command cmd = null;
		switch(Action.valueOf(action.toUpperCase())) {
		case MOVE:
			System.out.println("---------command : Move ---------");
			cmd = new MoveCommand(domain,action,page);
			break;
		case JOIN:
			System.out.println("---------command : JOIN ---------");
			cmd = new CreateCommand(domain,action,page);
			break;
		default:
			break;
		}
		return cmd;
		
	}

}
