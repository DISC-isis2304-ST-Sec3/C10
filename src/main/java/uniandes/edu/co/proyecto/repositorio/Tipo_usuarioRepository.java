package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Tipo_usuario;

public interface Tipo_usuarioRepository extends JpaRepository<Tipo_usuario,Integer>{

     @Query(value = "SELECT.* FROM Tipo_usuario", nativeQuery = true)
        Collection<Tipo_usuario> darTiposusuario();

        @Query(value = "SELECT.* FROM Tipo_usuario WHERE id = :id", nativeQuery = true)
        Tipo_usuario darTipousuario(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO Tipo_usuario (id, nombre, cantidad) VALUES(:id, :nombre, :cantidad)",nativeQuery = true)
        void insertarTipousuario(@Param("id") int id,@Param("nombre") String nombre, @Param("cantidad") Integer cantidad);

        @Modifying
        @Transactional
        @Query(value = "UPDATE Tipo_usuario SET nombre =:nombre, cantidad=:cantidad WHERE id =:id", nativeQuery = true)
        void actualizarTipousuario(@Param("id") int id,@Param("nombre") String nombre, @Param("cantidad") Integer cantidad);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM bar WHERE id=:id", nativeQuery = true)
        void eliminarTipousuario(@Param("id") int id);

    
}