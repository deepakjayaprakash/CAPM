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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private ManagerEntity managerEntity;

    @Column(name = "team_name")
    private String teamName;

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}