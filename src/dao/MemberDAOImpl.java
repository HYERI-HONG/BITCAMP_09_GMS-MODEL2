package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.*;
import factory.*;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;


public class MemberDAOImpl implements MemberDAO {

	private static MemberDAO  instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	Statement state;
	Connection conn;
	private MemberDAOImpl() {}
	
	
	@Override
	public void insert(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.INSERT.toString(),
					member.getUserId(),
					member.getName(),
					member.getPassword(),
					member.getSsn(),
					member.getAge(),
					member.getGender(),
					member.getTeamId(),
					member.getRoll()
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {	
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("beginRow",param.get("beginRow"));
		map.put("endRow",param.get("endRow"));
		map.put("column", null);
		map.put("value", null);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s:q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}
	@Override
	public MemberBean retrieve(String id) {
		MemberBean member = new MemberBean();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,DBConstant.USERNAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SEARCH.toString(),id));
			while(rs.next()) {
				member.setUserId(rs.getString("USERID"));
				member.setTeamId(rs.getString("TEAMID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setSsn(rs.getString("SSN"));
				member.setGender(rs.getString("GENDER"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
/*	@Override
	public List<MemberBean> selectSome(String word) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s:q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}*/

	@Override
	public int count() {
		int count=0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.COUNT.toString());
			while(rs.next()) {
				count = rs.getInt("COUNT");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void update(Map<?,?> param) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.UPDATE.toString(),param.get("after_pass"),param.get("teamid"),param.get("roll"),param.get("userid"),param.get("before_pass")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.DELETE.toString(), member.getUserId(),member.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean mem = null;
		try {
			System.out.println("MemberDAOImpl --- login");
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME,
					DBConstant.PASSWORD)
				.getConnection()
				.createStatement()
				.executeQuery(String.format(MemberQuery.LOGIN.toString(),
						bean.getUserId(),bean.getPassword()));
		
			while(rs.next()){
				 mem = new MemberBean();
				 mem.setUserId(rs.getString("USERID"));
				 mem.setPassword(rs.getString("PASSWORD"));
				 mem.setName(rs.getString("NAME"));
				 mem.setRoll(rs.getString("ROLL"));
				 mem.setTeamId(rs.getString("TEAMID"));
				 mem.setSsn(rs.getString("SSN"));
			 }
		//Exception이 여러개일 경우는 Exception으로 처리, 상위 예외처리, 모든 예외를 한번에 처리
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}


	



	

}
