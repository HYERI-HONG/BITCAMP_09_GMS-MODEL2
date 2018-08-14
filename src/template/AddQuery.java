package template;


import enums.ImageQuery;

public class AddQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch((String)map.get("domain")) {
		case "MEMBER":
			break;
		case "IMAGE" :
			map.put("sql",ImageQuery.INSERT.toString());
			System.out.println("add query의 initialize안에 들어옴"+map.get("sql"));
			break;
		}
		
	}

	@Override
	void startPlay() {
		try {
			
			String path=(String)map.get("img");
			String ext = path.substring(path.indexOf(".")+1, path.length());
			String filename = path.substring(0,path.indexOf("."));
			
			pstmt.setString(1,filename);
			pstmt.setString(2, ext);
			pstmt.setString(3, (String)map.get("userid"));
			
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
