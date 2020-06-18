package capm.service;

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
        TeamEntity teamEntity = teamRepository.getById(id);
        return teamEntity;
    }

    public TeamEntity buildNewTeam(String name) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setTeamName(name);
        return teamEntity;
    }

    public TeamEntity save(TeamEntity teamEntity) {
        teamEntity = teamRepository.save(teamEntity);
        return teamEntity;
    }
}
