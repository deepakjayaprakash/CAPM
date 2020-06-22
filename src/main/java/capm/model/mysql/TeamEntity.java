package capm.model.mysql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author deepak.jayaprakash
 */
@Entity
@Table(name = "team")
@Getter
@Setter
public class TeamEntity extends BasicAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private ManagerEntity managerEntity;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "size")
    private Integer size;

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
