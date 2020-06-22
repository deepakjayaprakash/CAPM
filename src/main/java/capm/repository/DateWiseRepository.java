package capm.repository;

import capm.model.mysql.DateWiseAttendanceEntity;
import capm.model.mysql.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author deepak.jayaprakash
 */
@Repository
public interface DateWiseRepository extends JpaRepository<DateWiseAttendanceEntity, Long>, JpaSpecificationExecutor<DateWiseAttendanceEntity>,
        CrudRepository<DateWiseAttendanceEntity, Long> {
}
