package service;

import java.util.List;
import domain.*;

public interface RecordService {
	public void createRecord(RecordBean record);
	public List<RecordBean> recordList();
	public List<RecordBean> findByGrade(String grade);
	public RecordBean findByRecordSeq(String seq);
	public int recordCount();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
}
