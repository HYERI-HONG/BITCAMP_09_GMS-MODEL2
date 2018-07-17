package dao;

import java.util.List;

import domain.RecordBean;

public class RecordDAOImpl implements RecordDAO{

	private static RecordDAO  instance = new RecordDAOImpl();
	public static RecordDAO getInstance() {return instance;}
	private RecordDAOImpl() {}	
	
	@Override
	public void insertRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecordBean> selectAllRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> selectRecordByGrade(String grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordBean selectRecordByRecordSeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int recordCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String selectFirstRowNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
