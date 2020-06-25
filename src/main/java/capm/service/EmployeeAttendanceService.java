package capm.service;

import capm.dto.internal.DateList;
import capm.model.mysql.EmployeeAttendanceEntity;
import capm.repository.EmployeeAttendanceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deepak.jayaprakash
 */
@Service
@Slf4j
public class EmployeeAttendanceService {

    @Autowired
    private EmployeeAttendanceRepository employeeAttendanceRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public EmployeeAttendanceEntity getEmployeeAttendanceEntity(long employeeId) {
        return employeeAttendanceRepository.findByEmployeeId(employeeId);
    }

    public DateList getDateList(String dateList) {
        return objectMapper.convertValue(dateList, DateList.class);
    }

    public String getDateList(DateList dateList) {
        return objectMapper.convertValue(dateList, String.class);
    }

    public EmployeeAttendanceEntity save(EmployeeAttendanceEntity ea) {
        ea = employeeAttendanceRepository.save(ea);
        return ea;
    }
}
