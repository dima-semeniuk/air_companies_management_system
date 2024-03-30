package management.system.app.repository;

import java.time.LocalDateTime;
import java.util.List;
import management.system.app.model.Flight;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByAirCompanyNameContainingIgnoreCaseAndFlightStatus(
            String name, Flight.Status flightStatus, Pageable pageable);

    @Query("SELECT f FROM Flight f JOIN FETCH f.airplane JOIN FETCH f.airCompany "
            + "WHERE f.startedAt < :timePoint AND f.flightStatus = 'ACTIVE'")
    List<Flight> findAllActiveFlightsOverLimit(LocalDateTime timePoint,
                                          Pageable pageable);

    //this query find all flights where the difference between the startedAt and
    // endedAt of the flight in minutes is greater than the value of the
    // estimated_flight_time in minutes, which is taken from a string value
    // in the format "hh:mm" by substring function
    @Query("SELECT f FROM Flight f JOIN FETCH f.airplane JOIN FETCH f.airCompany "
            + "WHERE TIMESTAMPDIFF(MINUTE, f.startedAt, f.endedAt) "
            + "> (SUBSTRING(f.estimatedFlightTime, 1, 2) * 60 "
            + "+ SUBSTRING(f.estimatedFlightTime, 4)) "
            + "AND f.flightStatus = 'COMPLETED'")
    List<Flight> findAllCompletedFlightsOverdue(Pageable pageable);
}
