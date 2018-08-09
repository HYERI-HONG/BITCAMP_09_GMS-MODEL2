package service;
import java.util.*;
import dao.MemberDAOImpl;
import domain.*;

public class MemberServiceImpl implements MemberService {

	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	@Override
	public void add(MemberBean member) {
		MemberDAOImpl.getInstance().insert(member);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().search(param);
	}
	@Override
	public MemberBean retrieve(String id) {
		return MemberDAOImpl.getInstance().retrieve(id);
	}
	@Override
	public int count() {
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?,?> param) {
		MemberDAOImpl.getInstance().update(param);
	}
	@Override
	public void remove(MemberBean member) {
		MemberDAOImpl.getInstance().delete(member);
	}
	@Override
	public boolean login(MemberBean member) {
		return (MemberDAOImpl.getInstance().login(member)!=null);
	}
}
