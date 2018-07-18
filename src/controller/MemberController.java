package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import domain.MemberBean;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet("/member.do") 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------Member Controller 집입점----------");
		Sentry.init(request);
		System.out.println("request :"+request);
		System.out.println("액션:"+Sentry.cmd.getAction());
		
	/*	String action = request.getParameter("action");
		String page = request.getParameter("page");*/
		
		
		MemberBean member = null;
		List<MemberBean> list=null;
				
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())){
		case MOVE :
			try {
				System.out.println("--------------Move안으로 진입-----------------");
				Carrier.send(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case JOIN:  
			member = new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			//MemberServiceImpl.getInstance().createMember(member);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=user_login_form");
			//send 보내 re 다시 direct나에게
			break;
		case MEMBER_LIST:
			list = MemberServiceImpl.getInstance().memberList();
			System.out.println(list);
			break;
		case SEARCH_MEMBER_BY_TEAM:
			list = MemberServiceImpl.getInstance().findByName(request.getParameter("teamname"));
			System.out.println(list);
			break;
		case SEARCH_MEMBER_BY_ID:
			member=MemberServiceImpl.getInstance().findById(request.getParameter("userid"));
			System.out.println(member.toString());
			break;
		case MEMBER_COUNT:
			int count = MemberServiceImpl.getInstance().memberCount();
			System.out.println("전체 회원 수 : "+count);
			break;
		case MEMBER_UPDATE:
			member =new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(String.format("%s/%s"
					,request.getParameter("before_pass")
					,request.getParameter("after_pass")));
			MemberServiceImpl.getInstance().updateMember(member);
			break;
		case MEMBER_DELETE:
			member = new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().deleteMember(member);
			break;
		case LOGIN:
			member = new MemberBean();
			member.setUserId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			if(MemberServiceImpl.getInstance().login(member)) {
				System.out.println("로그인 성공");
			}
			else {
				System.out.println("로그인 실패");
			}
			break;
		default :
			System.out.println("오류 발생");
			break;	
		}
		/*request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
