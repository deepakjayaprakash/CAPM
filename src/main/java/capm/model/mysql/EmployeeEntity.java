package capm.model.mysql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author deepak.jayaprakash
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity extends BasicAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private ManagerEntity managerEntity;
}
