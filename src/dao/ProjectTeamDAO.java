package dao;

import java.util.List;
import domain.*;

public interface ProjectTeamDAO {
	public void insertProjectTeam(ProjectTeamBean team);
	public List<ProjectTeamBean> selectAllTeam();
	public List<ProjectTeamBean> selectTeamByTeamName(String teamName);
	public ProjectTeamBean selectTeamByTeamId(String teamId);
	public int teamCount();
	public void updateTeam(ProjectTeamBean team);
	public void deleteTeam(ProjectTeamBean team);
}
