package capm.model.mysql;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author deepak.jayaprakash
 */
@MappedSuperclass
@Getter
@Setter
public class BasicAudit {
    @Temporal(TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public String toString() {
        return "BasicAudit{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
