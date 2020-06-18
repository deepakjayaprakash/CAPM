package capm.model.mysql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author deepak.jayaprakash
 */
@Entity
@Table(name = "team_config")
@Getter
@Setter
public class TeamConfigEntity extends BasicAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "config_name")
    private String configName;

    @Column(name = "config_value")
    private String configValue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    @Override
    public String toString() {
        return "GlobalConfigEntity{" +
                "id=" + id +
                ", configName='" + configName + '\'' +
                ", configValue='" + configValue + '\'' +
                '}';
    }
}
