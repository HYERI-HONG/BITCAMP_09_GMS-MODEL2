package template;

import java.sql.ResultSet;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.COUNT.toString());
	}
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase(map).getConnection().prepareStatement((String)map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				number = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
