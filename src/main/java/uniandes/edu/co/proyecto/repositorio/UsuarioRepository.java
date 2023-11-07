package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Usuario;

@Repository

public interface UsuarioRepository {

        @Query(value = "SELECT.* FROM usuarios", nativeQuery = true)
        Collection<Usuario> darUsuarios();

        @Query(value = "SELECT.* FROM usuarios WHERE id = :id", nativeQuery = true)
        Usuario darUsuario(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO usuarios (Nombre_2,Apellido,Tipo_usuario_id) VALUES(hotel_sequence.nextval, :Nombre_2, :Apellido, :Tipo_usuario_id )", nativeQuery = true)
        void insertarUsuario(@Param("Nombre_2") String Nombre_2, @Param("Apellido") String Apellido,
                        @Param("Tipo_usuario_id") Integer Tipo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE usuarios SET Nombre_2 =:Nombre_2, Apellido=:Apellido, Tipo_usuario_id=:Tipo_usuario_id WHERE id =:id", nativeQuery = true)
        void actualizarUsuario(@Param("Nombre_2") String Nombre_2, @Param("Apellido") String Apellido,
                        @Param("Tipo_usuario_id") Integer Tipo);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM usuarios WHERE id=:id", nativeQuery = true)
        void eliminarUsuario(@Param("id") int id);

}
