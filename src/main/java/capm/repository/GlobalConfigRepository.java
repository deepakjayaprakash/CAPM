package capm.repository;

import capm.model.mysql.DateWiseAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author deepak.jayaprakash
 */
@Repository
public interface GlobalConfigRepository extends JpaRepository<DateWiseAttendanceEntity, Long>, JpaSpecificationExecutor<DateWiseAttendanceEntity>,
        CrudRepository<DateWiseAttendanceEntity, Long> {

    @Query(value = "from DateWiseAttendanceEntity d where d.date = :date and d.teamEntity.id = :teamId")
    DateWiseAttendanceEntity findByDate(@Param(value = "date") Date date, @Param(value = "teamId") long teamId);
}
