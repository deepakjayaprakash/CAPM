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

import java.util.Optional;

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
        ManagerEntity managerEntity;
        if (createEmployeeRequest.getAccessLevel() != null) {
            managerEntity = managerService.createManager();
            managerService.save(managerEntity);
            teamEntity.setManagerEntity(managerEntity);
        } else {
            managerEntity = teamEntity.getManagerEntity();
        }
        int size = Optional.ofNullable(teamEntity.getSize()).orElse(0);
        teamEntity.setSize(size + 1);
        teamService.save(teamEntity);

        EmployeeEntity employeeEntity = employeeService.buildNewEmployee(createEmployeeRequest.getName(),
                createEmployeeRequest.getCode(), teamEntity, managerEntity);
        employeeService.save(employeeEntity);
    }

    @Override
    public void createNewTeam(CreateTeamRequest createTeamRequest) throws ApplicationException {
        TeamEntity teamEntity = teamService.buildNewTeam(createTeamRequest.getName());
        teamService.save(teamEntity);
    }
}
