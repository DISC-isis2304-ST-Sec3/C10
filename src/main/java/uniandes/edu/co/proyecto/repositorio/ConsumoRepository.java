package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.Usuario;

@Repository

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

        @Query(value = "SELECT.* FROM consumos", nativeQuery = true)
        Collection<Reserva> darConsumos();

        @Query(value = "SELECT.* FROM consumos WHERE id = :id", nativeQuery = true)
        Consumo darConsumo(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO consumos (id, Fecha,descripcion,preciounitario,cantidad,total,servicio_id,reserva_id, cliente_id) VALUES(:id, :Fecha, :descripcion, :preciounitario, :cantidad, :total,:servicio_id, :reserva_id, :cliente_id )",nativeQuery = true)
        void insertarConsumo(@Param("id") int id,@Param("Fecha") Date fechaentrada, @Param("descripcion") String descripcion,
                        @Param("preciounitario") Integer precioUnitario, @Param("cantidad") Integer cantidad,
                        @Param("total") Integer total, @Param("servicio_id") Integer servicio_id,
                        @Param("reserva_id") Integer numero_reserva, @Param("cliente_id") Integer Usuario_id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE consumos SET Fecha =:Fecha, descripcion=:descripcion, preciounitario=:preciounitario, cantidad=:cantidad, total=:total, servicio_id=:servicio_id, :reserva_id, cliente_id =:cliente_id WHERE id =:id", nativeQuery = true)
        void actualizarConsumo(@Param("id") int id, @Param("Fecha") Date fechaentrada, @Param("descripcion") String descripcion,
                        @Param("preciounitario") Integer precioUnitario, @Param("cantidad") Integer cantidad,
                        @Param("total") Integer total, @Param("servicio_id") Integer servicio_id,
                        @Param("reserva_id") Integer numero_reserva, @Param("cliente_id") Integer Usuario_id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM consumos WHERE id=:id", nativeQuery = true)
        void eliminarConsumo(@Param("id") int id);

}
