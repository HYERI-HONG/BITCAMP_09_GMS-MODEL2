package service;
import domain.*;
import java.util.List;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> memberList();
	public List<MemberBean> findByName(String name);
	public MemberBean findById(String id);
	public int memberCount();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public boolean login(MemberBean member);
	public String calculateAge(MemberBean member);
}
