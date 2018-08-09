package template;

import java.sql.*;
import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", map.get("column")==null? String.format("SELECT B.*" + 
					" FROM (SELECT ROWNUM N, A.* FROM %s A ORDER BY N DESC) B" + 
					" WHERE B.N BETWEEN ? AND ?", map.get("table"))
				:
					String.format(
                "SELECT "+ ColumnFinder.find(Domain.MEMBER)
                +" FROM %s WHERE %s LIKE ?", map.get("table"),map.get("column")));
	}
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			if(map.get("value")==null) {
				pstmt.setString(1, map.get("beginRow").toString());
				pstmt.setString(2, map.get("endRow").toString());
			}else {
				pstmt.setString(1, "%"+map.get("value").toString()+"%");
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setUserId(rs.getString("USERID"));
				member.setGender(rs.getString("GENDER"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setSsn(rs.getString("SSN"));
				member.setTeamId(rs.getString("TEAMID"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		
	}
}
