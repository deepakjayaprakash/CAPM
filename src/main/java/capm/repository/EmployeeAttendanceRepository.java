package capm.repository;

import capm.model.mysql.EmployeeAttendanceEntity;
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
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendanceEntity, Long>, JpaSpecificationExecutor<EmployeeAttendanceEntity>,
        CrudRepository<EmployeeAttendanceEntity, Long> {

    @Query(value = "from EmployeeAttendanceEntity e where e.employeeEntity.id = :id")
    EmployeeAttendanceEntity findByEmployeeId(@Param(value = "id") long id);
}
