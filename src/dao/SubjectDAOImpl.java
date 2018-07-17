package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDAOImpl implements SubjectDAO{

	private static SubjectDAO  instance = new SubjectDAOImpl();
	public static SubjectDAO getInstance() {return instance;}
	private SubjectDAOImpl() {}	
	
	@Override
	public void insertSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> selectAllSubject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> selectSubjectBySubName(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean selectSubjectBySubSeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int subjectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

}
