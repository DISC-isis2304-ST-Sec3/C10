package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.modelo.ReservanHabitaciones;

@Repository
public interface ConsultasBasicasReservanHabitacionesRepository extends JpaRepository<ReservanHabitaciones, Integer> {

    // @Query("SELECT rh.habitacionNumero, ((COUNT(r.fechaSalida - r.fechaEntrada))
    // / 365) " +
    // "FROM Reserva r " +
    // "INNER JOIN ReservanHabitaciones rh ON (r.id = rh.pk.numero_reserva.id) " +
    // "WHERE r.fechaEntrada BETWEEN :startDate AND :endDate " +
    // "GROUP BY rh.habitacionNumero")
    // List<Object[]> findHabitacionCountByDate(@Param("startDate") Date startDate,
    // @Param("endDate") Date endDate);
}