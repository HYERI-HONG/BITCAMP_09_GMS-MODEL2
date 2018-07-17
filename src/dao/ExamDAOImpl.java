package dao;

import java.util.List;

import domain.ExamBean;

public class ExamDAOImpl implements ExamDAO{

	private static ExamDAOImpl instance =new ExamDAOImpl();
	public static ExamDAOImpl getInstance() {return instance;}
	private ExamDAOImpl() {}
	
	@Override
	public void insertExam(ExamBean exam) {
		
	}

	@Override
	public List<ExamBean> selectAllExam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> selectExamByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean selectExamBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int examCount() {
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
