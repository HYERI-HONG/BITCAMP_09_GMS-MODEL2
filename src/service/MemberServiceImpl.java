package service;
import java.text.SimpleDateFormat;
import java.util.*;
import dao.MemberDAOImpl;
import domain.*;

public class MemberServiceImpl implements MemberService {

	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	@Override
	public void createMember(MemberBean member) {
		member.setAge(calculateAge(member));
		MemberDAOImpl.getInstance().insertMember(member);
	}
	@Override
	public List<MemberBean> memberList() {
		return MemberDAOImpl.getInstance().selectAllMember();
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectMemberByName(name);
	}

	@Override
	public MemberBean findById(String id) {
		
		return MemberDAOImpl.getInstance().selectMemberById(id);
	}

	@Override
	public int memberCount() {
		return MemberDAOImpl.getInstance().memberCount();
	}

	@Override
	public void updateMember(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
		
	}
	@Override
	public boolean login(MemberBean member) {
		return (MemberDAOImpl.getInstance().login(member)!=null);
	}
	@Override
	public String calculateAge(MemberBean member) {	
		String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String todayYear = today.split("/")[0];
		String todayMonth = today.split("/")[1];
		String todayDay = today.split("/")[2];
		
		String birthYear = member.getSsn().substring(0,2);
		String birthMonth = member.getSsn().substring(2,4);
		String birthDay = member.getSsn().substring(4,6);
		
		if(Integer.parseInt(birthYear)>18&&Integer.parseInt(birthYear)<=99) {
			birthYear = "19"+birthYear;
		}else {
			birthYear = "20"+birthYear;
		}
		
		int age = Integer.parseInt(todayYear)-Integer.parseInt(birthYear);
		
		System.out.println(age);
		if((Integer.parseInt(birthMonth)*100+Integer.parseInt(birthDay))>(Integer.parseInt(todayMonth)*100+Integer.parseInt(todayDay))){
			age--;
		}
		return String.valueOf(age);
	}

}
