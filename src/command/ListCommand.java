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
			
			//총 페이지 수가 block크기보다 작으면? 
			//true ->작은 경우 에서 한 페이지에 들어갈 row수가 딱 떨어지지 않는 경우 페이지 하나 추가
			//false-> 화면에 보여줄 최대 page수는 곧 block size가 된다.
					
			int pageNum=1; //default값으로 첫번째 페이지 '1'로 설정
			int beginRow=0;
			int endRow=0;
			
		/*	int prevBlock = beginPage - blockSize;
			int nextBlock = beginPage + blockSize;
			
			boolean existPrev =false;
			boolean existNext =false;
			if(prevBlock>0) {
				existPrev=true;
			}*/
			Map<String,Object> param = new HashMap<>();
			
			request.setAttribute("count",count);
			request.setAttribute("beginPage",beginPage);
			request.setAttribute("endPage",endPage);
			request.setAttribute("existNext", lastPage>blockSize?true:false);
			
			//Admin page에 처음 들어오면 넘어오는 pageNum가 없고, 사용자가 pageNum을 눌러서 들어온 경우에는 해당 값이 있다.
			if(request.getParameter("pageNum")!=null) {
				pageNum =Integer.parseInt((request.getParameter("pageNum")));
			}
			
			
			//beginRow=1+(5*(pageNum-1));
			beginRow=(pageRow*pageNum)-(pageRow-1);
			
			//해당 페이지가 마지막 page인 경우
			if(pageNum ==lastPage) {
				/*endRow = rowMaxPerPage*(pageNum-1)+(count%rowMaxPerPage);*/
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
