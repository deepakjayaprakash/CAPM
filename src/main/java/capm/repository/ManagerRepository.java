package capm.repository;

import capm.model.mysql.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author deepak.jayaprakash
 */
@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Long>, JpaSpecificationExecutor<ManagerEntity>,
        CrudRepository<ManagerEntity, Long> {
}
