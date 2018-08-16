package template;


import enums.ImageQuery;
import enums.MemberQuery;

public class AddQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch((String)map.get("domain")) {
		case "MEMBER":
			map.put("sql", MemberQuery.INSERT.toString());
			break;
		case "IMAGE" :
			map.put("sql",ImageQuery.INSERT.toString());
			break;
		}
		
	}
	@Override
	void startPlay() {
		try {
			switch((String)map.get("domain")) {
			case "MEMBER":
				pstmt.setString(1, (String)map.get("userid"));
				pstmt.setString(2, (String)map.get("ssn"));
				pstmt.setString(3, (String)map.get("name"));
				pstmt.setString(4, (String)map.get("roll"));
				pstmt.setString(5, (String)map.get("teamid"));
				pstmt.setString(6, (String)map.get("pass"));
				pstmt.setString(7, (String)map.get("age"));
				pstmt.setString(8, (String)map.get("gender"));
				break;
			case "IMAGE" :
				String path=(String)map.get("img");
				String ext = path.substring(path.indexOf(".")+1, path.length());
				String filename = path.substring(0,path.indexOf("."));
				pstmt.setString(1,filename);
				pstmt.setString(2,ext);
				pstmt.setString(3,(String)map.get("userid"));
				break;
			}
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
