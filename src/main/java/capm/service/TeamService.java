package capm.service;

import capm.model.mysql.ManagerEntity;
import capm.model.mysql.TeamEntity;
import capm.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deepak.jayaprakash
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamEntity getTeamWithId(Long id) {
        TeamEntity teamEntity = new TeamEntity();
        return teamEntity;
    }

    public TeamEntity buildNewTeam(String name, ManagerEntity managerEntity) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setTeamName(name);
        teamEntity.setManagerEntity(managerEntity);
        return teamEntity;
    }

    public void save(TeamEntity teamEntity) {
        teamRepository.save(teamEntity);
    }
}
