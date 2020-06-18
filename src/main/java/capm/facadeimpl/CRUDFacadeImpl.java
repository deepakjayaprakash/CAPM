package capm.facadeimpl;

import capm.dto.request.CreateEmployeeRequest;
import capm.dto.request.CreateTeamRequest;
import capm.enums.ReturnCode;
import capm.exceptions.ApplicationException;
import capm.ifacade.CRUDFacade;
import capm.model.mysql.EmployeeEntity;
import capm.model.mysql.ManagerEntity;
import capm.model.mysql.TeamEntity;
import capm.service.EmployeeService;
import capm.service.ManagerService;
import capm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author deepak.jayaprakash
 */
@Component
public class CRUDFacadeImpl implements CRUDFacade {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ManagerService managerService;

    @Override
    public void createNewEmployee(CreateEmployeeRequest createEmployeeRequest) throws ApplicationException {
        TeamEntity teamEntity = teamService.getTeamWithId(createEmployeeRequest.getTeamId());
        if (teamEntity == null) {
            throw new ApplicationException(ReturnCode.EC_002);
        }
        EmployeeEntity employeeEntity = employeeService.buildNewEmployee(createEmployeeRequest.getName(),
                createEmployeeRequest.getCode(), teamEntity);
        employeeService.save(employeeEntity);
    }

    @Override
    public void createNewTeam(CreateTeamRequest createTeamRequest) throws ApplicationException {
        ManagerEntity managerEntity = managerService.getManagerWithId(createTeamRequest.getManagerId());
        if (managerEntity == null) {
            throw new ApplicationException(ReturnCode.EC_003);
        }
        TeamEntity teamEntity = teamService.buildNewTeam(createTeamRequest.getName(), managerEntity);
        teamService.save(teamEntity);
    }
}
