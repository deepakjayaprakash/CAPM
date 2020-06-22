package capm.model.mysql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author deepak.jayaprakash
 */
@Entity
@Table(name = "employee_attendance_list")
@Getter
@Setter
public class EmployeeAttendanceEntity extends BasicAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_list")
    private String dateList;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;
}
