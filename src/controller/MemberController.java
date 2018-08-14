package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.Carrier;
import command.Receiver;
import domain.MemberBean;
import enums.Action;
import enums.Path;
import service.ImageServiceImpl;
import service.MemberServiceImpl;


@WebServlet("/member.do") 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("1.Member Controller");
		Receiver.init(request, response);
		System.out.println("9.Member Controller");
		
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())){
		
		case ADD:  
			System.out.println("10.Controller : add");
			Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
			break;
		case SEARCH:case RETRIEVE:
			System.out.println("10.Controller : search/retrieve");
			Carrier.forward(request, response);
			break;
		case MODIFY:
			System.out.println("10.Controller : modify");
			Carrier.forward(request, response);
			break;
		case REMOVE:
			System.out.println("10.Controller : remove");
			Carrier.redirect(request, response,"");
			break;
		case MOVE :
			System.out.println("10.Controller : move");
			Carrier.forward(request, response);
			break;
		case LOGIN:
			System.out.println("10.Controller : login");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
			}
			break;
		case FILEUPLOAD:
			System.out.println("10.Controller : File upload");
			System.out.println("1.파일 업로드로 진입");
			if(!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("업로드 파일이 없습니다.");
				return;
			}
			System.out.println("2.업로드 파일 존재 확인");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*40); //40MB
			upload.setSizeMax(1024*1024*50); //50MB
			List<FileItem> items = null;
			
			try {
				System.out.println("3.내부 진입 성공");
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request));
				System.out.println("4.아이템 생성");
				Iterator<FileItem> iter = items.iterator();
	
				while(iter.hasNext()) {
					System.out.println("5.while loop진입 성공");
					FileItem item = (FileItem)iter.next();
					if(!item.isFormField()) {
						System.out.println("6.if문 진입 성공");
						String fileName = item.getName();
						file = new File(Path.UPLOAD_PATH+fileName);
						item.write(file);
						System.out.println("7.파일 업로드 성공");
						
						Map<String,Object> map = new HashMap<>();
						map.put("img", fileName);
						map.put("userid",((MemberBean)request.getSession().getAttribute("user")).getUserId());
						ImageServiceImpl.getInstance().add(map);
					}else {
						System.out.println("8.파일 업로드 실패");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("File upload finish");
			Carrier.redirect(request, response, "/member.do?action=retrieve&page=retrieve");
			break;
		default :
			System.out.println("오류 발생");
			break;	
		}

	}
}
