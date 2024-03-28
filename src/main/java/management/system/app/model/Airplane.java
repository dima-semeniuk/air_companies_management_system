package management.system.app.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "factory_serial_number", nullable = false, unique = true)
    private String factorySerialNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;

    @Column(name = "number_of_flights", nullable = false)
    private Integer numberOfFlights;

    @Column(name = "flight_distance", nullable = false)
    private Double flightDistance;

    @Column(name = "fuel_capacity", nullable = false)
    private Double fuelCapacity;

    @Column(name = "airplane_type", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Type airplaneType;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    public enum Type {
        PASSENGER,
        CARGO,
        BUSINESS,
        AIRSHIP
    }
}
