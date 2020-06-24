package capm.repository;

import capm.model.mysql.GlobalConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author deepak.jayaprakash
 */
@Repository
public interface GlobalConfigRepository extends JpaRepository<GlobalConfigEntity, Long>, JpaSpecificationExecutor<GlobalConfigEntity>,
        CrudRepository<GlobalConfigEntity, Long> {

}
