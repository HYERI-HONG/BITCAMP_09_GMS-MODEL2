package command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	public ListCommand(HttpServletRequest request) {
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
			System.out.println("-----------memberlist command--------------");

			int count = MemberServiceImpl.getInstance().memberCount();
			int pageRow=5;
			int blockSize=5;
			
			int lastPage = count%pageRow>0? count/pageRow+1:count/pageRow;
			int beginPage = 1;
			int endPage =count/pageRow<blockSize? lastPage:blockSize; 
			
			int pageNum=1;
			int beginRow=0;
			int endRow=0;

			Map<String,Object> param = new HashMap<>();
			
			request.setAttribute("count",count);
			request.setAttribute("beginPage",beginPage);
			request.setAttribute("endPage",endPage);
			request.setAttribute("existNext", lastPage>blockSize?true:false);
			
			if(request.getParameter("pageNum")!=null) {
				pageNum =Integer.parseInt((request.getParameter("pageNum")));
			}
			
			beginRow=(pageRow*pageNum)-(pageRow-1);
			
			if(pageNum ==lastPage) {
				endRow = pageRow*pageNum-pageRow+(count%pageRow);
			}
			else {
				endRow = pageRow*pageNum;
			}
			param.put("beginRow", String.valueOf(beginRow));
			param.put("endRow", String.valueOf(endRow));
			
			request.setAttribute("list", MemberServiceImpl.getInstance().getList(param));
			break;
		default:
			break;
		}
		super.execute();
	}

}
