package service;

import java.util.List;

import domain.*;

public class SubjectServiceImpl implements SubjectService {

	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImpl() {
	}
	
	@Override
	public void createSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> subjectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> findBySubName(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean findBySubSeq(String seq) {
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
