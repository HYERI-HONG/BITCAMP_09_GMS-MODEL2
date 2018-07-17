package service;

import java.util.List;
import domain.*;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public List<SubjectBean> subjectList();
	public List<SubjectBean> findBySubName(String subject);
	public SubjectBean findBySubSeq(String seq);
	public int subjectCount();
	public void updateSubject(SubjectBean subject);
	public void deleteSubject(SubjectBean subject);
}
