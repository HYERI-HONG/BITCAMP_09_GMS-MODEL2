package enums;

public enum Path {
	WEBPATH,MAIN,UPLOAD_PATH;
	
	@Override
	public String toString() {
		String res = "";
		switch(this) {
		case WEBPATH : res = "/WEB-INF/view/";
			break;
		case MAIN : res="/main.jsp";
			break;
		case UPLOAD_PATH :
			res="C:\\Users\\1027\\eclipse\\jee-oxygen\\eclipse\\workspace2\\GMS-Model2\\WebContent\\resources\\img\\upload\\";
			break;
		default :
			break;
		}
		return res;
	}
}
