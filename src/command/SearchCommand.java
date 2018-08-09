package command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}
@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())){
		case ADMIN:
			System.out.println("-----------4.search command--------------");
			Map<String,Object> param = new HashMap<>();
			String pageNum=request.getParameter("pageNum");
			PageProxy pxy = new PageProxy();
			int pn =(pageNum==null)? 1 :Integer.parseInt(pageNum);
			pxy.carryOut(pn);
			Pagination page = pxy.getPagination();
			param.put("beginRow", page.getBeginRow());
			param.put("endRow", page.getEndRow());
			request.setAttribute("page",page);
			request.setAttribute("list",
					MemberServiceImpl.getInstance()
					.search(param));	
			
		/*	String word = request.getParameter("searchOption")+"/"+request.getParameter("searchWord");
			request.setAttribute("list",MemberServiceImpl.getInstance().retrieve(word));*/
			break;
		default:
			break;
		}
		super.execute();
	}

}
