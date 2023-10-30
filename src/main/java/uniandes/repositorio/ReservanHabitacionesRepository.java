package uniandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservanHabitaciones;
import uniandes.edu.co.proyecto.modelo.UsanSpa;

public interface ReservanHabitacionesRepository extends JpaRepository<ReservanHabitaciones, Integer> {

        @Query(value = "SELECT.* FROM Reservan_habitaciones", nativeQuery = true)
        Collection<UsanSpa> darReservanHabitacioness();

        @Query(value = "SELECT * FROM Reservan_habitaciones WHERE Numero_reserva = :Numero_reserva AND Numero_habitacion = :Numero_habitacion", nativeQuery = true)
        UsanSpa darReservan_habitaciones(@Param("Numero_reserva") Integer numReserva,
                        @Param("Numero_habitacion") Integer Num_habitacion);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO Reservan_habitaciones (Numero_reserva,Numero_habitacion) VALUES(hotel_sequence.nextval, :Numero_reserva,:Numero_habitacion )")
        void insertarReservanHabitaciones(@Param("Numero_reserva") int numReserva,
                        @Param("Numero_habitacion") int numHabitacion);

        @Modifying
        @Transactional
        @Query(value = "UPDATE INTO Reservan_habitaciones (Numero_reserva,Numero_habitacion) VALUES(hotel_sequence.nextval, :Numero_reserva,:Numero_habitacion )")
        void actualizarReservan_habitaciones(@Param("Numero_reserva") int numReserva,
                        @Param("Numero_habitacion") int numHabitacion);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Reservan_habitaciones WHERE Numero_reserva = :Numero_reserva AND Numero_habitacion = :Numero_habitacion", nativeQuery = true)
        void eliminarReservan_habitaciones(@Param("Numero_reserva") int numReserva,
                        @Param("Numero_habitacion") int numHabitacion);

}
