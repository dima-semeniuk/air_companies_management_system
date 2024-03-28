package management.system.app.model;

import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "air_companies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "company_type", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Type companyType;

    @Column(name = "founded_at", nullable = false)
    private LocalDate foundedAt;

    public enum Type {
        PJSC,
        LLC,
        CORPORATION
    }
}
