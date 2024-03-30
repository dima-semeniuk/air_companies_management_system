package management.system.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "air_companies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "company_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type companyType;

    @Column(name = "founded_at", nullable = false)
    private Integer foundedAt;

    public enum Type {
        PJSC,
        LLC,
        CORPORATION
    }

    public AirCompany(Long id) {
        this.id = id;
    }
}
