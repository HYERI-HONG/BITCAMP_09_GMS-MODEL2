package dao;

import java.util.List;
import domain.*;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public List<MemberBean> selectAllMember();
	public List<MemberBean> selectMemberByName(String name);
	public MemberBean selectMemberById(String id);
	public int memberCount();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean bean);
	
}
