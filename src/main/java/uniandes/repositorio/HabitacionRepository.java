package uniandes.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

        @Query(value = "SELECT.* FROM habitaciones", nativeQuery = true)
        Collection<Reserva> darHabitaciones();

        @Query(value = "SELECT.* FROM habitaciones WHERE Numero = :Numero", nativeQuery = true)
        Habitacion darHabitacion(@Param("Numero") int Numero);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO habitaciones (Numero,Tipo,CapacidadMax,Dotacion,Estado,Tarifa,Plandeconsumo_id) VALUES(hotel_sequence.nextval, :Numero,:Tipo,:CapacidadMax,:Dotacion,:Estado,:Tarifa,:PlanDeConsumo_id )")
        void insertarHabitacion(@Param("Numero") int Numero, @Param("Tipo") String Tipo,
                        @Param("CapacidadMax") Integer CapacidadMax, @Param("Dotacion") String Dotacion,
                        @Param("Estado") String estado, @Param("Tarifa") Integer Tarifa,
                        @Param("Plandeconsumo_id") int Plandeconsumo_id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE habitaciones SET Numero =:Numero,Tipo:=Tipo, CapacidadMax=:CapacidadMax, Dotacion=:Dotacion, Estado=:Estado, Tarifa=:Tarifa, Plandeconsumo_id=:Plandeconsumo_id WHERE Numero =:Numero", nativeQuery = true)
        void actualizarHabitacion(@Param("Numero") int Numero, @Param("Tipo") String Tipo,
                        @Param("CapacidadMax") Integer CapacidadMax, @Param("Dotacion") String Dotacion,
                        @Param("Estado") String estado, @Param("Tarifa") Integer Tarifa,
                        @Param("Plandeconsumo_id") int Plandeconsumo_id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM habitaciones WHERE Numero=:Numero", nativeQuery = true)
        void eliminarHabitacion(@Param("Numero") int habitacion);

}
