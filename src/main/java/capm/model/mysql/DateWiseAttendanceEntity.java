package capm.model.mysql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author deepak.jayaprakash
 */
@Entity
@Table(name = "datewise_attendance_list")
@Getter
@Setter
public class DateWiseAttendanceEntity extends BasicAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "employee_list")
    private String employeeList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId")
    private TeamEntity teamEntity;
}
