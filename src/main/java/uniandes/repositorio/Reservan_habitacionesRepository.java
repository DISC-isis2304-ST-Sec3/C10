package uniandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reservan_habitaciones;
import uniandes.edu.co.proyecto.modelo.Usan_spa;

public interface Reservan_habitacionesRepository extends JpaRepository<Reservan_habitaciones,Integer> {

     @Query(value = "SELECT.* FROM Reservan_habitaciones", nativeQuery = true)
    Collection<Usan_spa> darReservan_habitaciones();

    @Query(value = "SELECT * FROM Reservan_habitaciones WHERE Numero_reserva = :Numero_reserva AND Numero_habitacion = :Numero_habitacion", nativeQuery = true)
    Usan_spa darReservan_habitaciones(@Param("Numero_reserva") int Num_reserva, @Param("Numero_habitacion") int Num_habitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usan_SPA (Numero_reserva,Numero_habitacion) VALUES(hotel_sequence.nextval, :Numero_reserva,:Numero_habitacion )")
    void insertarReservan_habitaciones(@Param("Numero_reserva") int id_SPA, @Param("Numero_habitacion") int id_ReservaSPA);

     @Modifying
    @Transactional
    @Query(value = "UPDATE INTO Usan_SPA (Numero_reserva,Numero_habitacion) VALUES(hotel_sequence.nextval, :Numero_reserva,:Numero_habitacion )")
    void actualizarReservan_habitaciones(@Param("Numero_reserva") int id_SPA, @Param("Numero_habitacion") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usan_spa WHERE Numero_reserva = :Numero_reserva AND Numero_habitacion = :Numero_habitacion", nativeQuery = true)
    void eliminarReservan_habitaciones(@Param("Numero_reserva") int id_SPA, @Param("Numero_habitacion") int id_ReservaSPA);
    
}
