package capm.model.mysql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "date")
    private Date date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;
}
