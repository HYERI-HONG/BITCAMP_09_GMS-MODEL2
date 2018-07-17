package service;
import java.util.List;

import dao.*;
import domain.*;

public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;
	}
	private ExamServiceImpl() {}
	
	@Override
	public void createExam(ExamBean exam) {
		
		System.out.println(exam);
		// 과목SEQ=null,
        // 성적표SEQ=null
		
		String[] sub = {"JAVA","SQL","R","HTML5","PYTHON"};
		ExamBean subExam = null;
		
		for(int i=0; i<5; i++) {
			subExam = new ExamBean();
			subExam.setScore(exam.getScore().split("/")[i]);
			subExam.setMonth(exam.getMonth());
			subExam.setSubSeq(SubjectDAOImpl.getInstance().selectSubjectBySubName(sub[i]).get(i).getSubSeq());
		}
		
		//record table insert
		RecordBean rec = new RecordBean();
		rec.setAvg("");
		rec.setGrade("");
		RecordDAOImpl.getInstance().insertRecord(rec);
		exam.setRecordSeq(RecordDAOImpl.getInstance().selectFirstRowNum());
		ExamDAOImpl.getInstance().insertExam(exam);
	}

	@Override
	public List<ExamBean> ExamList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> findByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean findBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
}
