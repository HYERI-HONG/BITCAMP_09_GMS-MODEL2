package dao;

import java.util.List;
import java.util.Map;

import domain.*;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public List<MemberBean> selectAllMember();
	public List<MemberBean> selectList(Map<?,?>param);
	public List<MemberBean> selectMemberByWord(String word);
	public MemberBean selectMemberById(String id);
	public int memberCount();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean bean);
	
}
