package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Reserva;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

        @Query(value = "SELECT.* FROM cliente", nativeQuery = true)
        Collection<Cliente> darClientes();

        @Query(value = "SELECT.* FROM cliente WHERE id = :id", nativeQuery = true)
        Cliente darCliente(@Param("id") Integer id);
 
 
        @Modifying
        @Transactional
        @Query(value = "UPDATE cliente SET Direccion=:Direccion, Telefono=:Telefono, Plandeconsumo_id=:Plandeconsumo_id WHERE id =:id", nativeQuery = true)
        void actualizarCliente(@Param("id") Integer id, @Param("Direccion") String Direccion,
                        @Param("Telefono") Integer Telefono,
                        @Param("Plandeconsumo_id") Integer Plandeconsumo_id);
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO cliente (id,Direccion,Telefono,Plandeconsumo_id) VALUES(:id, :Direccion, :Telefono, :Plandeconsumo_id )",nativeQuery = true)
        void insertarCliente( @Param("id") Integer id, @Param("Direccion") String Direccion,
                        @Param("Telefono") Integer Telefono,
                        @Param("Plandeconsumo_id") Integer Plandeconsumo_id);

       

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE id=:id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);

}