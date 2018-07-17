package factory;
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
}
