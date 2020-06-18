package capm.service;

import capm.enums.AccessLevel;
import capm.model.mysql.ManagerEntity;
import capm.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deepak.jayaprakash
 */
@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public ManagerEntity getManagerWithId(Long id) {
        ManagerEntity managerEntity = new ManagerEntity();
        return managerEntity;
    }

    public ManagerEntity createManager() {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setAccessLevel(AccessLevel.MANAGER);
        return managerEntity;
    }

    public ManagerEntity save(ManagerEntity managerEntity) {
        managerEntity = managerRepository.save(managerEntity);
        return managerEntity;
    }
}
