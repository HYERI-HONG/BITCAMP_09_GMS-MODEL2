package dao;
import java.util.List;
import domain.*;

public interface ExamDAO {
	public void insertExam(ExamBean exam);
	public List<ExamBean> selectAllExam();
	public List<ExamBean> selectExamByWord(String word);
	public ExamBean selectExamBySeq(String seq);
	public int examCount();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);
}
