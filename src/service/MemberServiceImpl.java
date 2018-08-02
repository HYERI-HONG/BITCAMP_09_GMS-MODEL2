package service;
import java.util.*;
import dao.MemberDAOImpl;
import domain.*;

public class MemberServiceImpl implements MemberService {

	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMember(member);
	}
	@Override
	public List<MemberBean> memberList() {
		return MemberDAOImpl.getInstance().selectAllMember();
	}

	@Override
	public List<MemberBean> findByWord(String word) {
		return MemberDAOImpl.getInstance().selectMemberByWord(word);
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

}
