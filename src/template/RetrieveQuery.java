package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch((String)map.get("domain")) {
		case "MEMBER":
			map.put("sql", MemberQuery.RETRIEVE.toString());
			System.out.println("여기는 retrieve query(member) :"+map.get("sql"));
			break;
		case "IMAGE":
			map.put("sql", ImageQuery.RETRIEVE.toString());
			System.out.println("여기는 retrieve query(image) :"+map.get("sql"));
			break;
		}	
	}
	@Override
	void startPlay() {
		try {
			pstmt.setString(1, "%"+map.get("value").toString()+"%");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			switch((String)map.get("domain")) {
			case "MEMBER":
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
				break;
			case "IMAGE":
				while(rs.next()) {
					map.put("filename", rs.getString("IMAGENAME"));
					map.put("extension", rs.getString("EXTENSION"));
				}
				break;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
