package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql"
				, !map.containsKey("column")? 
				String.format(MemberQuery.LIST.toString()
				, map.get("domain")):
				String.format(
				MemberQuery.SEARCH.toString()
				, map.get("domain"),map.get("column")));
	}
	@Override
	void startPlay() {
		try {
			int n=0;
			if(map.containsKey("column")) {
				n++;
				pstmt.setString(n, "%"+map.get("value").toString()+"%");
			}
			n++;
			pstmt.setString(n, (String) map.get("beginRow"));
			n++;
			pstmt.setString(n, (String) map.get("endRow"));

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
