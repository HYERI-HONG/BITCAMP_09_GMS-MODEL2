package template;

import java.sql.PreparedStatement;
import java.util.HashMap;
import enums.Vendor;
import lombok.Data;
import pool.DBConstant;
import java.util.*;
 
@Data
public abstract class QueryTemplate {
	
		HashMap<String, Object>map;
		List<Object> list;
		PreparedStatement pstmt;
		
		public final void play(HashMap<String,Object> map) {
			this.pstmt = null;
			this.list = new ArrayList<>();
			this.map = map;
			this.map.put("vendor", Vendor.ORACLE);
			this.map.put("username", DBConstant.USERNAME);
			this.map.put("password", DBConstant.PASSWORD);
			initialize();
			startPlay();
			endPlay();
		}
		abstract void 	initialize();
		abstract void 	startPlay();
		abstract void 	endPlay();
		
}

