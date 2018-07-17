package dao;

import java.util.List;
import domain.*;

public interface RecordDAO {
	public void insertRecord(RecordBean record);
	public List<RecordBean> selectAllRecord();
	public List<RecordBean> selectRecordByGrade(String grade);
	public RecordBean selectRecordByRecordSeq(String seq);
	public int recordCount();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
	public String selectFirstRowNum();
}
