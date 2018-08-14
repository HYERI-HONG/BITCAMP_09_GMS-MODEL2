package service;
import domain.*;
import java.util.List;
import java.util.Map;

public interface MemberService {
	public void add(MemberBean member);
	public List<MemberBean> search(Map<String,Object> param);
	public MemberBean retrieve(String word);
	public int count();
	public void modify(Map<?,?> param);
	public void remove(MemberBean member);
	public MemberBean login(MemberBean member);
	
}
