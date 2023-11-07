package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservanHabitaciones;
import uniandes.edu.co.proyecto.modelo.UsanSpa;

@Repository

public interface ReservanHabitacionesRepository extends JpaRepository<ReservanHabitaciones, Integer> {

        @Query(value = "SELECT.* FROM Reservan_habitaciones", nativeQuery = true)
        Collection<ReservanHabitaciones> darReservanHabitacioness();

        @Query(value = "SELECT * FROM Reservan_habitaciones WHERE reserva_id = :reserva_id AND habitacion_numero = :habitacion_numero", nativeQuery = true)
        ReservanHabitaciones darReservan_habitaciones(@Param("reserva_id") Integer numReserva,
                        @Param("habitacion_numero") Integer Num_habitacion);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO Reservan_habitaciones (reserva_id,habitacion_numero) VALUES( :reserva_id,:habitacion_numero )", nativeQuery = true)
        void insertarReservanHabitaciones(@Param("reserva_id") Integer numReserva,
                        @Param("habitacion_numero") Integer numHabitacion);

        @Modifying
        @Transactional
        @Query(value = "UPDATE INTO Reservan_habitaciones (reserva_id,habitacion_numero) VALUES( :reserva_id,:habitacion_numero )", nativeQuery = true)
        void actualizarReservan_habitaciones(@Param("reserva_id") Integer numReserva,
                        @Param("habitacion_numero") Integer numHabitacion);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Reservan_habitaciones WHERE reserva_id = :reserva_id AND habitacion_numero = :habitacion_numero", nativeQuery = true)
        void eliminarReservan_habitaciones(@Param("reserva_id") Integer numReserva,
                        @Param("habitacion_numero") Integer numHabitacion);

}
