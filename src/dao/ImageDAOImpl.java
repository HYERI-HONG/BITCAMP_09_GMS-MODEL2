package dao;

import java.util.HashMap;
import java.util.Map;

import enums.Domain;
import template.*;


public class ImageDAOImpl implements ImageDAO{

	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	public ImageDAOImpl() {}
	private QueryTemplate q;
	@Override
	public void insert(Map<String,Object> param) {
		q=new AddQuery();
		param.put("domain", "IMAGE");
		q.play(param);
	}

	@Override
	public void update(Map<String,Object> param) {
		
	}

	@Override
	public void delete(Map<String,Object> param) {
		
	}
	@Override
	public Map<String, Object> retrieve(String word) {
		q=new RetrieveQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("value", word);
		map.put("domain", "IMAGE");
		q.play(map);
		return q.getMap();
	}

}
