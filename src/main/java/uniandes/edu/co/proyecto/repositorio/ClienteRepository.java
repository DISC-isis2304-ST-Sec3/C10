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

    @Query("SELECT c FROM Cliente c")
    Collection<Cliente> darClientes();

    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    Cliente darCliente(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.Direccion = :Direccion, c.Telefono = :Telefono, c.planDeconsumo.id = :Plandeconsumo_id WHERE c.id = :id")
    void actualizarCliente(@Param("id") Integer id, @Param("Direccion") String Direccion,
            @Param("Telefono") Integer Telefono,
            @Param("Plandeconsumo_id") Integer Plandeconsumo_id);

    @Modifying
    @Transactional
    @Query("INSERT INTO Cliente (id, Direccion, Telefono, planDeconsumo.id) VALUES(:id, :Direccion, :Telefono, :Plandeconsumo_id )")
    void insertarCliente(@Param("id") Integer id, @Param("Direccion") String Direccion,
            @Param("Telefono") Integer Telefono,
            @Param("Plandeconsumo_id") Integer Plandeconsumo_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cliente c WHERE c.id = :id")
    void eliminarCliente(@Param("id") Integer id);

}