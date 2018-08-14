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
		System.out.println("5.Memberservibe  :  add");
		MemberDAOImpl.getInstance().insert(member);
	}
	@Override
	public List<MemberBean> search(Map<String, Object> param) {
		System.out.println("5.Memeservice  :  search");
		return MemberDAOImpl.getInstance().search(param);
	}
	@Override
	public MemberBean retrieve(String word) {
		System.out.println("5.Memberservice  :  retrieve");
		return MemberDAOImpl.getInstance().retrieve(word);
	}
	@Override
	public int count() {
		System.out.println("5.Memberservice  :  count");
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?,?> param) {
		System.out.println("5.Memberservice  :  modify");
		MemberDAOImpl.getInstance().update(param);
	}
	@Override
	public void remove(MemberBean member) {
		System.out.println("5.Memberservice  :  remove");
		MemberDAOImpl.getInstance().delete(member);
	}
	@Override
	public MemberBean login(MemberBean member) {
		System.out.println("5.Memberservice  :  login");
		return MemberDAOImpl.getInstance().login(member);
	}

}
