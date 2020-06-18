package capm.repository;

import capm.model.mysql.TeamEntity;
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
public interface TeamRepository extends JpaRepository<TeamEntity, Long>, JpaSpecificationExecutor<TeamEntity>,
        CrudRepository<TeamEntity, Long> {
    @Query("from TeamEntity t left join fetch t.managerEntity m where t.id = :id")
    TeamEntity getById(@Param(value = "id") Long id);
}
