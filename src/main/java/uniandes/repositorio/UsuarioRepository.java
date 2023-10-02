package uniandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;

public interface UsuarioRepository {

     @Query(value = "SELECT.* FROM usuarios", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT.* FROM usuarios WHERE id = :id", nativeQuery = true)
    Cliente darCliente(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (Nombre_2,Apellido,Tipo) VALUES(hotel_sequence.nextval, :Nombre_2, :Apellido, :Tipo )")
    void insertarCliente(@Param("Nombre_2") String Nombre_2, @Param("Apellido") String Apellido,
            @Param("Tipo") String Tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET Nombre_2 =:Nombre_2, Apellido=:Apelliod, Tipo=:Tipo, Direccion=:Direccion, Telefono=:Telefono, Plandeconsumoactual=:Plandeconsumoactual WHERE id =:id", nativeQuery = true)
    void actualizarCliente(@Param("Nombre_2") String Nombre_2, @Param("Apellido") String Apellido,
            @Param("Tipo") String Tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id=:id", nativeQuery = true)
    void eliminarCliente(@Param("id") int id);
    
}
