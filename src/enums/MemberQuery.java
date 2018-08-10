package enums;

import template.ColumnFinder;

public enum MemberQuery {
	INSERT,
	LIST, SEARCH,RETRIEVE,COUNT,
	UPDATE,
	DELETE,
	LOGIN;
	
	@Override
	public String toString() {
		
		String query ="";
		switch(this) {
		case LOGIN :
			query = " SELECT " +
					ColumnFinder.find(Domain.MEMBER) 
					+ " FROM MEMBER"
					+ " WHERE USERID LIKE ?"
					+ " AND PASSWORD LIKE ?";
			break;
		case INSERT:
			query = " INSERT INTO MEMBER( "
					+ ColumnFinder.find(Domain.MEMBER) 
					+ " )"
					+ " VALUES(?,?,?,?,?,?,?,?,?) ";
			break;
		case COUNT:
			query = " SELECT COUNT(*) AS COUNT FROM MEMBER";
			break;
		case UPDATE:
			query = " UPDATE MEMBER SET %s = ?" 
					+ " WHERE USERID LIKE ?";
			break;
		case DELETE :
			query = " DELETE FROM MEMBER" 
					+ " WHERE USERID LIKE ?" 
					+ " AND PASSWORD LIKE ?";
			break;
		case LIST :
			query = " SELECT T.* " 
					+ " FROM(SELECT ROWNUM SEQ, M.*" 
					+ " FROM %s M "
					+ " ORDER BY SEQ DESC) T" 
					+ " WHERE T.SEQ BETWEEN ? AND ?";
			break;
		case SEARCH : 
			query = " SELECT T.* " 
					+ " FROM(SELECT ROWNUM SEQ, M.*" 
					+ " FROM %s M "
					+ " WHERE %s LIKE ?" 
					+ " ORDER BY SEQ DESC) T" 
					+ " WHERE T.SEQ BETWEEN ? AND ?";
			break;	
		case RETRIEVE:
			query = " SELECT " + 
					ColumnFinder.find(Domain.MEMBER)
					+ " FROM MEMBER WHERE USERID LIKE ?";
			break;
		default:
			break;
		}
		return query;
	}
	
}
