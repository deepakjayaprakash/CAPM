package capm.ifacade;

import capm.dto.request.CreateEmployeeRequest;
import capm.dto.request.CreateTeamRequest;
import capm.exceptions.ApplicationException;

/**
 * @author deepak.jayaprakash
 */
public interface CRUDFacade {
    void createNewEmployee(CreateEmployeeRequest createEmployeeRequest) throws ApplicationException;

    void createNewTeam(CreateTeamRequest teamRequest) throws ApplicationException;
}
