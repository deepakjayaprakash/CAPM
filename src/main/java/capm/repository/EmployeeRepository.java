package capm.repository;

import capm.model.mysql.EmployeeEntity;
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
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>, JpaSpecificationExecutor<EmployeeEntity>,
        CrudRepository<EmployeeEntity, Long> {
    @Query(value = "select * from EmployeeEntity e join fetch e.TeamEntity t where e.id = :id")
    EmployeeEntity getEmployeeById(@Param(value = "id") long id);
}
