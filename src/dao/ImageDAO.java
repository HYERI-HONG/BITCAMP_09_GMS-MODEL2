package dao;

import java.util.Map;

public interface ImageDAO {
	public void insert(Map<String,Object> param);
	public void update(Map<String,Object> param);
	public void delete(Map<String,Object> param);
	public Map<String,Object> retrieve(String word);
	
	
}
