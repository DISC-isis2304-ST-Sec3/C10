package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.PlanDeConsumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

@Repository

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

        @Query(value = "SELECT.* FROM habitaciones", nativeQuery = true)
        Collection<Habitacion> darHabitaciones();

        @Query(value = "SELECT.* FROM habitaciones WHERE Numero = :Numero", nativeQuery = true)
        Habitacion darHabitacion(@Param("Numero") int Numero);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO habitaciones (Numero,Tipo,CapacidadMax,Dotacion,Estado,Tarifa,Plandeconsumo_id,Tipo_habitacion_id) VALUES(:Numero,:Tipo,:CapacidadMax,:Dotacion,:Estado,:Tarifa,:Plandeconsumo_id,:Tipo_habitacion_id )", nativeQuery = true)
        void insertarHabitacion(@Param("Numero") int Numero, @Param("Tipo") String Tipo,
                        @Param("CapacidadMax") Integer CapacidadMax, @Param("Dotacion") String Dotacion,
                        @Param("Estado") String estado, @Param("Tarifa") Integer Tarifa,
                        @Param("Plandeconsumo_id") Integer Plandeconsumo_id,
                        @Param("Tipo_habitacion_id") String tipo_habitacion_id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE habitaciones SET Numero =:Numero,Tipo:=Tipo, CapacidadMax=:CapacidadMax, Dotacion=:Dotacion, Estado=:Estado, Tarifa=:Tarifa, Plandeconsumo_id=:Plandeconsumo_id, Tipo_habitacion_id=:Tipo_habitacion_id WHERE Numero =:Numero", nativeQuery = true)
        void actualizarHabitacion(@Param("Numero") int Numero, @Param("Tipo") String Tipo,
                        @Param("CapacidadMax") Integer CapacidadMax, @Param("Dotacion") String Dotacion,
                        @Param("Estado") String estado, @Param("Tarifa") Integer Tarifa,
                        @Param("Plandeconsumo_id") Integer Plandeconsumo_id,
                        @Param("Tipo_habitacion_id") String tipo_habitacion_id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM habitaciones WHERE Numero=:Numero", nativeQuery = true)
        void eliminarHabitacion(@Param("Numero") int habitacion);

}
