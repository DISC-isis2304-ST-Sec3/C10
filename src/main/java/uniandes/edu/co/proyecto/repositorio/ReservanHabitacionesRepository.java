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
        Collection<UsanSpa> darReservanHabitacioness();

        @Query(value = "SELECT * FROM Reservan_habitaciones WHERE id_reserva = :id_reserva AND Numero_habitacion = :Numero_habitacion", nativeQuery = true)
        UsanSpa darReservan_habitaciones(@Param("id_reserva") Integer numReserva,
                        @Param("Numero_habitacion") Integer Num_habitacion);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO Reservan_habitaciones (id_reserva,Numero_habitacion) VALUES(hotel_sequence.nextval, :id_reserva,:Numero_habitacion )")
        void insertarReservanHabitaciones(@Param("id_reserva") int numReserva,
                        @Param("Numero_habitacion") int numHabitacion);

        @Modifying
        @Transactional
        @Query(value = "UPDATE INTO Reservan_habitaciones (id_reserva,Numero_habitacion) VALUES(hotel_sequence.nextval, :id_reserva,:Numero_habitacion )")
        void actualizarReservan_habitaciones(@Param("id_reserva") int numReserva,
                        @Param("Numero_habitacion") int numHabitacion);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Reservan_habitaciones WHERE id_reserva = :id_reserva AND Numero_habitacion = :Numero_habitacion", nativeQuery = true)
        void eliminarReservan_habitaciones(@Param("id_reserva") int numReserva,
                        @Param("Numero_habitacion") int numHabitacion);

}
