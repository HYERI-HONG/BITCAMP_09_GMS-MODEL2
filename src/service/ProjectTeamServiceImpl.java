package service;

import java.util.List;

import domain.*;

public class ProjectTeamServiceImpl implements ProjectTeamService{

	private static ProjectTeamService instance  = new ProjectTeamServiceImpl();
	static ProjectTeamService getInstance() {return instance;}
	private ProjectTeamServiceImpl() {}
	
	@Override
	public void createProjectTeam(ProjectTeamBean team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProjectTeamBean> teamList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectTeamBean> findByTeamName(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectTeamBean findByTeamId(String teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int teamCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateTeam(ProjectTeamBean team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeam(ProjectTeamBean team) {
		// TODO Auto-generated method stub
		
	}

}
