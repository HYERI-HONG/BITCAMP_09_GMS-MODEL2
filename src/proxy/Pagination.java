package proxy;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Pagination implements Proxy{
	int count = 0,pageRow=5, blockSize=5,lastPage =0,
			beginPage = 1, endPage =0 ,pageNum=1,beginRow=0,endRow=0;
	
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String,Object> map= new HashMap<>();
		map.put("beginRow", String.valueOf(beginRow));
		map.put("endRow", String.valueOf(endRow));
		return null;
	}
}
