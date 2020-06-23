package capm.service;

import capm.model.mysql.DateWiseAttendanceEntity;
import capm.model.mysql.TeamEntity;
import capm.repository.DateWiseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author deepak.jayaprakash
 */
@Service
@Slf4j
public class DateWiseAttendanceService {

    @Autowired
    private DateWiseRepository dateWiseRepository;

    public DateWiseAttendanceEntity getDateWiseAttendance(Date date, long teamId) {
        return dateWiseRepository.findByDate(date, teamId);
    }

    public DateWiseAttendanceEntity createNewDateEntity(Date date, TeamEntity teamEntity) {
        DateWiseAttendanceEntity dae = new DateWiseAttendanceEntity();
        dae.setDate(date);
        dae.setTeamEntity(teamEntity);
        return dae;
    }

    public DateWiseAttendanceEntity save(DateWiseAttendanceEntity dateAttendance) {
        dateAttendance = dateWiseRepository.save(dateAttendance);
        return dateAttendance;
    }
}
