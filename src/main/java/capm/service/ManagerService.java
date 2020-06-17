package capm.service;

import capm.model.mysql.ManagerEntity;
import org.springframework.stereotype.Service;

/**
 * @author deepak.jayaprakash
 */
@Service
public class ManagerService {

    public ManagerEntity getManagerWithId(Long id) {
        ManagerEntity managerEntity = new ManagerEntity();
        return managerEntity;
    }
}
