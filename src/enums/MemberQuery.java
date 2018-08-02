package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,COUNT_MEMBER,UPDATE,DELETE, SELECT_ALL, SELECT_ONE;
	
	@Override
	public String toString() {
		
		String query ="";
		switch(this) {
		case LOGIN :
			query="SELECT MEM_ID USERID,TEAM_ID TEAMID,NAME,"
					+ "SSN,ROLL,PASSWORD,GENDER FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'"
					+ "AND PASSWORD LIKE '%s'";
			break;
		case INSERT_MEMBER:
			query="INSERT INTO MEMBER(MEM_ID,NAME,PASSWORD,SSN,AGE,GENDER,TEAM_ID,ROLL)"
					+ "VALUES('%s','%s','%s','%s','%s','%s','%s','%s')";
			break;
		case COUNT_MEMBER:
			query="SELECT COUNT(*) AS COUNT FROM MEMBER";
			break;
		case UPDATE:
			query="UPDATE MEMBER SET PASSWORD = '%s',TEAM_ID = '%s',ROLL='%s'" + 
					" WHERE MEM_ID LIKE '%s'" +
					" AND PASSWORD LIKE '%s'";
			break;
		case DELETE :
			query ="DELETE FROM MEMBER" + 
					" WHERE MEM_ID LIKE '%s'" + 
					"AND PASSWORD LIKE '%s'";
			break;
		case SELECT_ALL : 
			query="SELECT" + 
					" MEM_ID USERID," + 
					" TEAM_ID TEAMID," + 
					" NAME," + 
					" AGE," + 
					" GENDER," + 
					" ROLL" + 
					" FROM MEMBER"+
					" ORDER BY MEM_ID";
			break;	
		case SELECT_ONE:
			query ="SELECT" + 
					"    MEM_ID USERID," + 
					"    TEAM_ID TEAMID," + 
					"    NAME," + 
					"    AGE," + 
					"    ROLL," + 
					"    PASSWORD," + 
					"    SSN," +
					"    GENDER" +
					" FROM MEMBER" + 
					" WHERE MEM_ID LIKE '%s'";
			break;
		}
	
		return query;
	}
	
}
