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
		case MYSQL :
			temp = new Oracle(DBConstant.MYSQL_DRIVER,
					DBConstant.MYSQL_CONNECTION_URL,(String)map.get("username"),(String)map.get("password"));
			break;
		case MARIADB :
			temp = new Oracle(DBConstant.MARIADB_DRIVER,
					DBConstant.MARIADB_CONNECTION_URL,(String)map.get("username"),(String)map.get("password"));
			break;
		case MSSQL :
			temp = new Oracle(DBConstant.MSSQL_DRIVER,
					DBConstant.MSSQL_CONNECTION_URL,(String)map.get("username"),(String)map.get("password"));
			break;
		}
		return temp;
	}
}
