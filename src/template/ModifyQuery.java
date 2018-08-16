package template;

import enums.MemberQuery;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(
				MemberQuery.UPDATE.toString()
				,"PASSWORD"
				,"TEAMID"
				,"ROLL"));
	}
	@Override
	void startPlay() {
		 try {
			pstmt.setString(1, (String)map.get("after_pass"));
			pstmt.setString(2, (String)map.get("teamid"));
			pstmt.setString(3, (String)map.get("roll"));
			pstmt.setString(4, (String)map.get("userid"));
			pstmt.setString(5, (String)map.get("before_pass"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
