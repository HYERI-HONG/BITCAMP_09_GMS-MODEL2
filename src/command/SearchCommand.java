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
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}
@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())){
		case ADMIN:
			System.out.println("4.search command");
			Map<String,Object> param = new HashMap<>();
			
			String pageNum=request.getParameter("pageNum");
			PageProxy pxy = new PageProxy();
			int pn =(pageNum==null)? 1 :Integer.parseInt(pageNum);
			pxy.carryOut(pn);
			Pagination page = pxy.getPagination();
			String[] arr1 = {"domain","beginRow","endRow","column","value"};
			String[] arr2 = {"member"
					,String.valueOf(page.getBeginRow())
					,String.valueOf(page.getEndRow())
					,request.getParameter("searchOption")
					,request.getParameter("searchWord")};
			
			for(int i=0; i<((arr2[3]==null)?3:arr1.length);i++) {
				param.put(arr1[i], arr2[i]);
			}
			request.setAttribute("page",page);
			request.setAttribute("list",
					MemberServiceImpl.getInstance()
					.search(param));	
			request.setAttribute("pagename", "search");
			break;
		default:
			break;
		}
		super.execute();
	}

}
