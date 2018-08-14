package service;

import java.util.Map;

public interface ImageService {
	public void add(Map<String,Object> param);
	public Map<String,Object> retrieve(String word);
	public void modify(Map<String,Object> param);
	public void remove(Map<String,Object> param);
}
