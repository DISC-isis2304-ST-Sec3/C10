package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Servicio;

@Repository

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

        @Query(value = "SELECT.* FROM servicio", nativeQuery = true)
        Collection<Servicio> darServicios();

        @Query(value = "SELECT.* FROM servicio WHERE id = :id", nativeQuery = true)
        Servicio darServicio(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO servicio (id, nombre, capacidad, horario) VALUES( :id, :nombre, :capacidad, :horario)", nativeQuery = true)
        void insertarServicio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") int capacidad,
                        @Param("horario") Date Horario);

        @Modifying
        @Transactional
        @Query(value = "UPDATE servicio SET id =:id, nombre =:nombre, capacidad=:capacidad, horario=:horario WHERE id =:id", nativeQuery = true)
        void actualizarServicio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") int capacidad,
                        @Param("horario") Date Horario);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM servicios WHERE id=:id", nativeQuery = true)
        void eliminarServicio(@Param("id") Integer id);

}
