package capm.service;

import capm.model.mysql.ManagerEntity;
import capm.model.mysql.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deepak.jayaprakash
 */
@Service
public class TeamService {

    public TeamEntity getTeamWithId(Long id) {
        TeamEntity teamEntity = new TeamEntity();
        return teamEntity;
    }

    public TeamEntity buildNewTeam(String name, String code, ManagerEntity managerEntity) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setTeamName(name);

        return teamEntity;
    }
}
