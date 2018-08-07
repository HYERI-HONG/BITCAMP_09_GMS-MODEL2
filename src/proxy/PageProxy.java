package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class PageProxy implements Proxy{
	HttpServletRequest request;
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String,Object> map = new HashMap<>();
		request=(HttpServletRequest) param.get("request");
	/*	request.setAttribute("count",count);
		request.setAttribute("beginPage",beginPage);
		request.setAttribute("endPage",endPage);
		request.setAttribute("existNext", lastPage>blockSize?true:false);
		request.setAttribute("", page);*/
		map.put("request", request);
		return map;
	}

}
