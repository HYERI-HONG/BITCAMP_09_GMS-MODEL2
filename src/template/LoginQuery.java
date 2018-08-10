package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;

public class LoginQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("8.LoginQuery");
		map.put("sql", MemberQuery.LOGIN.toString());
		System.out.println(map.get("sql"));
	}
	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String)map.get("userid"));
			pstmt.setString(2, (String)map.get("pass"));
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
				o = member;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
