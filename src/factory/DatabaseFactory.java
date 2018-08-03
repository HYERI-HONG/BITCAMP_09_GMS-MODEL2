package factory;
import java.util.Map;

import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	public static Database createDatabase(Vendor v,String id,String pass) {
		Database temp=null;
		switch(v) {
		case ORACLE:
			temp = new Oracle(DBConstant.ORACLE_DRIVER,
					DBConstant.ORACLE_CONNECTION_URL,id,pass);
			break;
		case MYSQL :
			temp = new Oracle(DBConstant.MYSQL_DRIVER,
					DBConstant.MYSQL_CONNECTION_URL,id,pass);
			break;
		case MARIADB :
			temp = new Oracle(DBConstant.MARIADB_DRIVER,
					DBConstant.MARIADB_CONNECTION_URL,id,pass);
			break;
		case MSSQL :
			temp = new Oracle(DBConstant.MSSQL_DRIVER,
					DBConstant.MSSQL_CONNECTION_URL,id,pass);
			break;
		}
		return temp;
	}
	public static Database createDatabase2(Map<String,Object> map) {
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
