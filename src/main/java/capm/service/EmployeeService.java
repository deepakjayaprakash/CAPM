package capm.service;

import capm.model.mysql.EmployeeEntity;
import capm.model.mysql.TeamEntity;
import capm.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deepak.jayaprakash
 */
@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity buildNewEmployee(String name, String code, TeamEntity teamEntity) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setCode(code);
        employeeEntity.setName(name);
        employeeEntity.setTeamEntity(teamEntity);
        return employeeEntity;
    }

    public void save(EmployeeEntity employeeEntity) {
        employeeEntity = employeeRepository.save(employeeEntity);
        log.info("employee_saved id: {}", employeeEntity.getId());
    }
}
