package service;

import java.util.Map;

import dao.ImageDAOImpl;

public class ImageServiceImpl implements ImageService {
	
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	public ImageServiceImpl() {}

	@Override
	public void add(Map<String,Object> param) {
		ImageDAOImpl.getInstance().insert(param);
	}

	@Override
	public void modify(Map<String,Object> param) {
	}

	@Override
	public void remove(Map<String,Object> param) {
		
	}
	@Override
	public Map<String,Object> retrieve(String word) {
		return ImageDAOImpl.getInstance().retrieve(word);
	}

}
