package uniandes.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

        @Query(value = "SELECT.* FROM clientes", nativeQuery = true)
        Collection<Cliente> darClientes();

        @Query(value = "SELECT.* FROM clientes WHERE id = :id", nativeQuery = true)
        Cliente darCliente(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO clientes (Nombre_2,Apellido,Tipo,Direccion,Telefono,Plandeconsumoactual) VALUES(hotel_sequence.nextval, :Nombre_2, :Apellido, :Tipo, :Direccion, :Telefono, :Plandeconsumoactual )")
        void insertarCliente(@Param("id") int id, @Param("Nombre_2") String Nombre_2,
                        @Param("Apellido") String Apellido,
                        @Param("Tipo") String Tipo, @Param("Direccion") String Direccion,
                        @Param("Telefono") int Telefono,
                        @Param("Plandeconsumoactual") String Plandeconsumoactual);

        @Modifying
        @Transactional
        @Query(value = "UPDATE clientes SET Nombre_2 =:Nombre_2, Apellido=:Apelliod, Tipo=:Tipo, Direccion=:Direccion, Telefono=:Telefono, Plandeconsumoactual=:Plandeconsumoactual WHERE id =:id", nativeQuery = true)
        void actualizarCliente(@Param("id") int id, @Param("Nombre_2") String Nombre_2,
                        @Param("Apellido") String Apellido,
                        @Param("Tipo") String Tipo, @Param("Direccion") String Direccion,
                        @Param("Telefono") int Telefono,
                        @Param("Plandeconsumoactual") String Plandeconsumoactual);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM clientes WHERE id=.id", nativeQuery = true)
        void eliminarCliente(@Param("id") int id);

}