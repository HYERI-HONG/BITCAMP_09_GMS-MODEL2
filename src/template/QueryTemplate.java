package template;

import java.sql.PreparedStatement;
import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;
import java.util.*;
 
@Data
public abstract class QueryTemplate {
	
		int number;
		Object o;
		Map<String, Object> map;
		List<Object> list;
		PreparedStatement pstmt;
		
		public final void play(Map<String,Object> param) {
			System.out.println("7.QueryTemplate");
			this.o = null;
			this.list = new ArrayList<>();
			
			this.pstmt = null;
			this.map = new HashMap<>();
			
			this.map.put("vendor", Vendor.ORACLE);
			this.map.put("username", DBConstant.USERNAME);
			this.map.put("password", DBConstant.PASSWORD);
			
			Iterator<?> keys = param.keySet().iterator();
			while(keys.hasNext()) {
				String key = (String) keys.next();
				this.map.put(key, param.get(key));
			}
			initialize();
			pstmtInit();
			startPlay();
			endPlay();
		}
		
		public final void play() {
			this.number = 0;
			this.pstmt = null;
			this.map = new HashMap<>();
			this.map.put("vendor",Vendor.ORACLE);
			this.map.put("username", DBConstant.USERNAME);
			this.map.put("password", DBConstant.PASSWORD);
			initialize();
			pstmtInit();
			startPlay();
			endPlay();
		}
		public final void pstmtInit() {
			System.out.println("pstmtInit");
			try {
				this.pstmt = DatabaseFactory
						.createDatabase(map)
						.getConnection()
						.prepareStatement((String)map.get("sql"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		abstract void 	initialize();
		abstract void 	startPlay();
		abstract void 	endPlay();
		
}

