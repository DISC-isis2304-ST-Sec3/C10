package uniandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository {

     @Query(value = "SELECT.* FROM usuarios", nativeQuery = true)
    Collection<Usuario> darClientes();

    @Query(value = "SELECT.* FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuario darCliente(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (Nombre_2,Apellido,Tipo) VALUES(hotel_sequence.nextval, :Nombre_2, :Apellido, :Tipo )")
    void insertarCliente(@Param("Nombre_2") String Nombre_2, @Param("Apellido") String Apellido,
            @Param("Tipo") String Tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET Nombre_2 =:Nombre_2, Apellido=:Apelliod, Tipo=:Tipo WHERE id =:id", nativeQuery = true)
    void actualizarCliente(@Param("Nombre_2") String Nombre_2, @Param("Apellido") String Apellido,
            @Param("Tipo") String Tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id=:id", nativeQuery = true)
    void eliminarCliente(@Param("id") int id);
    
}
