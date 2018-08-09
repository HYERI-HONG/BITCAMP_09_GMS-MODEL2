package dao;

import java.util.List;
import java.util.Map;

import domain.*;

public interface MemberDAO {
	public void insert(MemberBean member);
	public List<MemberBean> search(Map<?,?> param);
	public MemberBean retrieve(String id);
	public int count();
	public void update(Map<?,?> param);
	public void delete(MemberBean member);
	public MemberBean login(MemberBean bean);
	
}
