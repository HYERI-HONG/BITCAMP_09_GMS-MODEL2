package template;
import enums.MemberQuery;

public class RemoveQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("remove query들어옴");
		map.put("sql", MemberQuery.DELETE.toString());
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
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
