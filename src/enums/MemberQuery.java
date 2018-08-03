package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,COUNT_MEMBER,UPDATE,DELETE, SELECT_ALL, SELECT_ONE;
	
	@Override
	public String toString() {
		
		String query ="";
		switch(this) {
		case LOGIN :
			query="SELECT USERID,TEAMID,NAME,"
					+ "SSN,ROLL,PASSWORD,GENDER FROM MEMBER "
					+ "WHERE USERID LIKE '%s'"
					+ "AND PASSWORD LIKE '%s'";
			break;
		case INSERT_MEMBER:
			query="INSERT INTO MEMBER(USERID,NAME,PASSWORD,SSN,AGE,GENDER,TEAMID,ROLL)"
					+ "VALUES('%s','%s','%s','%s','%s','%s','%s','%s')";
			break;
		case COUNT_MEMBER:
			query="SELECT COUNT(*) AS COUNT FROM MEMBER";
			break;
		case UPDATE:
			query="UPDATE MEMBER SET PASSWORD = '%s',TEAMID = '%s',ROLL='%s'" + 
					" WHERE USERID LIKE '%s'" +
					" AND PASSWORD LIKE '%s'";
			break;
		case DELETE :
			query ="DELETE FROM MEMBER" + 
					" WHERE USERID LIKE '%s'" + 
					"AND PASSWORD LIKE '%s'";
			break;
		case SELECT_ALL : 
			query="SELECT" + 
					" USERID," + 
					" TEAMID," + 
					" NAME," + 
					" AGE," + 
					" GENDER," + 
					" ROLL" + 
					" FROM MEMBER"+
					" ORDER BY USERID";
			break;	
		case SELECT_ONE:
			query ="SELECT" + 
					"    USERID," + 
					"    TEAMID," + 
					"    NAME," + 
					"    AGE," + 
					"    ROLL," + 
					"    PASSWORD," + 
					"    SSN," +
					"    GENDER" +
					" FROM MEMBER" + 
					" WHERE USERID LIKE '%s'";
			break;
		}
	
		return query;
	}
	
}
