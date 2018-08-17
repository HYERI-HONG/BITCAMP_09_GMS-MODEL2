package dao;

import java.util.*;
import domain.MemberBean;
import template.*;


public class MemberDAOImpl implements MemberDAO {

	private static MemberDAO  instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private QueryTemplate q;
	private MemberDAOImpl(){}
	@Override
	public void insert(MemberBean member) {
		System.out.println("6.MemberDAO  :  insert");
		Map<String, Object> map = new HashMap<>();
		map.put("userid", member.getUserId());
		map.put("pass", member.getPassword());
		map.put("name", member.getName());
		map.put("ssn", member.getSsn());
		map.put("age", member.getAge());
		map.put("gender", member.getGender());
		map.put("teamid", member.getTeamId());
		map.put("roll", member.getRoll());
		map.put("domain", "MEMBER");
		q=new AddQuery();
		q.play(map);
	}
	@Override
	public List<MemberBean> search(Map<String, Object> param) {	
		System.out.println("6.MemberDAO  :  search");
		q = new SearchQuery();
		List<MemberBean> list = new ArrayList<>();
		q.play(param);
		for(Object s:q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}
	@Override
	public MemberBean retrieve(String word) {
		System.out.println("6.MemberDAO  :  retrieve");
		q = new RetrieveQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("value", word);
		map.put("domain", "MEMBER");
		q.play(map);
		return (MemberBean) q.getO();
	}
	@Override
	public int count() {
		System.out.println("6.MemberDAO  :  count");
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}
	@Override
	public void update(Map<String, Object> param) {
		System.out.println("6.MemberDAO  :  update");
		q=new ModifyQuery();
		q.play(param);
		
	}

	@Override
	public void delete(MemberBean member) {
		System.out.println("6.MemberDAO  :  delete");
		q= new RemoveQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("userid", member.getUserId());
		map.put("pass", member.getPassword());
		q.play(map);
	}
	@Override
	public MemberBean login(MemberBean bean) {
		System.out.println("6.MemberDAO  :  login");
		q = new LoginQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("userid", bean.getUserId());
		map.put("pass", bean.getPassword());
		q.play(map);
		return (MemberBean) q.getO();
	}


	



	

}
