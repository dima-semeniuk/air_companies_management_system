package management.system.app.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status flightStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @Column(name = "departure_country", nullable = false)
    private String departureCountry;

    @Column(name = "destination_country", nullable = false)
    private String destinationCountry;

    @Column(nullable = false)
    private Integer distance;

    @Column(name = "estimated_flight_time", nullable = false)
    private String estimatedFlightTime;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public enum Status {
        ACTIVE,
        COMPLETED,
        DELAYED,
        PENDING
    }
}
