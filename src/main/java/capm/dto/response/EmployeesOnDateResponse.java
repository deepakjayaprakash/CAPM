package capm.dto.response;

import capm.model.mysql.EmployeeEntity;
import lombok.Data;

import java.util.List;

/**
 * @author deepak.jayaprakash
 */
@Data
public class EmployeesOnDateResponse {
    private String date;
    private List<EmployeeEntity> employees;
}
