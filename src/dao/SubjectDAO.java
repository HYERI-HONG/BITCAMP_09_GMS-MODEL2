package dao;

import java.util.List;
import domain.*;

public interface SubjectDAO {
	public void insertSubject(SubjectBean subject);
	public List<SubjectBean> selectAllSubject();
	public List<SubjectBean> selectSubjectBySubName(String subject);
	public SubjectBean selectSubjectBySubSeq(String seq);
	public int subjectCount();
	public void updateSubject(SubjectBean subject);
	public void deleteSubject(SubjectBean subject);
}
