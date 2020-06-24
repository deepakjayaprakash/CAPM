package capm.repository;

import capm.model.mysql.TeamConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author deepak.jayaprakash
 */
@Repository
public interface TeamConfigRepository extends JpaRepository<TeamConfigEntity, Long>, JpaSpecificationExecutor<TeamConfigEntity>,
        CrudRepository<TeamConfigEntity, Long> {

    @Query(value = "from TeamConfigEntity t where t.teamEntity.id = :teamId")
    TeamConfigEntity getTeamConfigForTeam(@Param(value = "teamId") long teamId);
}
