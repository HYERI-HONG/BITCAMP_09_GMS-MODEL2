package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
	//inner class는 public을 갖지 않는다.
	//이유는 이 클래스 내부에서만 사용하기 때문이다.
	//만약 다른곳에서 계속 사용한다면 독립시켜야한다.
	//1회용 클래스
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final String PATH ="C:\\Users\\1027\\Documents\\sample.txt";
		
		try {
			File file = new File(PATH);
			FileWriter fw= new FileWriter(file, true);
			//append(두번째 파라메터)가 true이면 이어쓰기, false이면 덮어쓰기가 된다.
			FileReader fr = new FileReader(file);
			
			BufferedWriter writer = new BufferedWriter(fw); 
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("[메뉴] 1.전송 2.읽기 3.종료");
				switch(scan.next()) {
				case "1": 
					System.out.println("메세지 입력 : ");
					writer.write(scan.next());
					writer.newLine(); //enter를 개행 역할로만 사용
					writer.flush(); //일반적으로 enter를 누르면 전송됐지만, 여기서는 enter가 다른 기능으로 사용되기 때문에
					//전송기능을 별도로 구현함
					break;
				case "2": 
					System.out.println("메세지 보기");
					String msg="";
					while((msg =reader.readLine()) !=null) {
						System.out.println(msg);
					}
					reader.close(); 
					break;
				case "3": 
					break;
				default :
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileName fn = new FileName(PATH);
		System.out.println("파일 확장자 : "+fn.getExt());
		System.out.println("파일 이름 : "+fn.getFilename());
	}
	
}
class FileName{
	private String path,sep,ext,filename;
	
	// 파일 경로 사이에 붙는 '/'
	// 확장자 앞에 붙는'.'
	//서버의 종류에 따라 사용하는 기호가 다르기 때문에 변수로 처리
	public FileName(String path) {
		this.path= path;
		this.sep=File.separator;
		this.ext =path.substring(path.indexOf(".")+1, path.length());
		this.filename=path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf(".")); //방어 코딩
	}

	public String getPath() {
		return path;
	}
	public String getSep() {
		return sep;
	}
	public String getExt() {
		return ext;
	}
	public String getFilename() {
		return filename;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setSep(String sep) {
		this.sep = sep;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
