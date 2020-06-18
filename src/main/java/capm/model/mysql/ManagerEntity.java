package capm.model.mysql;

import capm.enums.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author deepak.jayaprakash
 */
@Entity
@Table(name = "manager")
@Getter
@Setter
@ToString
public class ManagerEntity extends BasicAudit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_level")
    private AccessLevel accessLevel;
}
