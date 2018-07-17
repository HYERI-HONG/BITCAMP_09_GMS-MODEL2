package service;
import domain.*;
import java.util.List;

public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean team);
	public List<ProjectTeamBean> teamList();
	public List<ProjectTeamBean> findByTeamName(String teamName);
	public ProjectTeamBean findByTeamId(String teamId);
	public int teamCount();
	public void updateTeam(ProjectTeamBean team);
	public void deleteTeam(ProjectTeamBean team);
	
}
