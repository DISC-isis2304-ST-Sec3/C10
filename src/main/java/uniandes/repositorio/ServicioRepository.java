package uniandes.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(value = "SELECT.* FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value= "SELECT.* FROM servicios WHERE id = :id",nativeQuery = true)
    Servicio darServisio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id, nombre, capacidad, Horario) VALUES(hotel_sequence.nextval, :nombre, :capacidad, :horario)")
    void insertarReserva(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad,
            @Param("Horario") Date Horario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET id =:id, nombre =:nombre, capacidad=:capacidad, Horario=:Horario WHERE id =:id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad,
            @Param("Horario") Date Horario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id=:id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);

}
