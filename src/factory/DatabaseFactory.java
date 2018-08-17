package factory;
import java.util.Map;

import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	public static Database createDatabase(Map<String,Object> map) {
		Database temp=null;
		String driver ="", url="";
		switch((Vendor)map.get("vendor")) {
		case ORACLE:
			driver = DBConstant.ORACLE_DRIVER;
			url=DBConstant.ORACLE_CONNECTION_URL;
			temp = new Oracle(driver,
					url,(String)map.get("username"),(String)map.get("password"));
			break;
		default:
			break;
		}
		return temp;
	}
}
