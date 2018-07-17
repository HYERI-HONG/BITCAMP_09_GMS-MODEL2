package service;
import domain.*;
import java.util.*;

public interface ExamService {
	public void createExam(ExamBean exam);
	public List<ExamBean> ExamList();
	public List<ExamBean> findByWord(String word);
	public ExamBean findBySeq(String seq);
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);	
}
