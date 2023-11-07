package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Tipo_habitacion;

public interface Tipo_habitacionRepository extends JpaRepository<Tipo_habitacion,Integer>{
     @Query(value = "SELECT.* FROM tipo_habitacion", nativeQuery = true)
        Collection<Tipo_habitacion> darTiposhabitacion();

        @Query(value = "SELECT.* FROM tipo_habitacion WHERE id = :id", nativeQuery = true)
        Tipo_habitacion darTipohabitacion(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO tipo_habitacion (id, nombre, descripcion) VALUES(:id, :nombre, :descripcion,)",nativeQuery = true)
        void insertarTipohabitacion(@Param("id") int id,@Param("nombre") String nombre, @Param("descripcion") String descripcion);

        @Modifying
        @Transactional
        @Query(value = "UPDATE tipo_habitacion SET nombre =:nombre, descripcion=:descripcion WHERE id =:id", nativeQuery = true)
        void actualizarTipohabitacion(@Param("id") int id,@Param("nombre") String nombre, @Param("descripcion") String descripcion);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM tipo_habitacion WHERE id=:id", nativeQuery = true)
        void eliminarTipohabitacion(@Param("id") int id);
    
}
