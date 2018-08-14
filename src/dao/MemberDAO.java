package dao;

import java.util.List;
import java.util.Map;

import domain.*;

public interface MemberDAO {
	public void insert(MemberBean member);
	public List<MemberBean> search(Map<String,Object> param);
	public MemberBean retrieve(String word);
	public int count();
	public void update(Map<?,?> param);
	public void delete(MemberBean member);
	public MemberBean login(MemberBean bean);
}
