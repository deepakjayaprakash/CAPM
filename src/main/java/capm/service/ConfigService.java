package capm.service;

import capm.model.mysql.GlobalConfigEntity;
import capm.model.mysql.TeamConfigEntity;
import capm.repository.GlobalConfigRepository;
import capm.repository.TeamConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deepak.jayaprakash
 */
@Service
public class ConfigService {

    @Autowired
    private GlobalConfigRepository globalConfigRepository;

    @Autowired
    private TeamConfigRepository teamConfigRepository;

    public Integer getLimit(long teamId) {
        TeamConfigEntity teamConfigEntity = teamConfigRepository.getTeamConfigForTeam(teamId);
        if (teamConfigEntity == null) {
            GlobalConfigEntity globalConfigEntity = globalConfigRepository.findAll().get(0);
            return Integer.valueOf(globalConfigEntity.getConfigValue());
        } else {
            return Integer.valueOf(teamConfigEntity.getConfigValue());
        }
    }
}
