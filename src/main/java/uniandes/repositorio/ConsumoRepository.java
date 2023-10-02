package uniandes.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

        @Query(value = "SELECT.* FROM consumos", nativeQuery = true)
        Collection<Reserva> darConsumos();

        @Query(value = "SELECT.* FROM consumos WHERE id = :id", nativeQuery = true)
        Consumo darConsumo(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO consumos (Fecha,descripcion,precioUnitario,cantidad,total,servicio_id,Usuario_id) VALUES(hotel_sequence.nextval, :Fecha, :descripcion, :precioUnitario, :Estado, :Empleado_id,:servicio_id, :usuario_id )")
        void insertarConsumo(@Param("Fecha") Date fechaentrada, @Param("descripcion") String descripcion,
                        @Param("PrecioUnitario") Integer precioUnitario, @Param("cantidad") Integer cantidad,
                        @Param("total") Integer total, @Param("servicio_id") Integer servicio_id,
                        @Param("numero_reserva") Integer numero_reserva, @Param("Usuario_id") int Usuario_id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE consumos SET fechaEntrada =:fechaEntrada, FechaSalida=:FechaSalida, NumeroPersonas=:NumeroPersonas, Cliente_NumeroIdentificacion=:Cliente_NumerodeIdentificacion, Estado=:Estado, Empleado_id=:Empleado_id WHERE id =:id", nativeQuery = true)
        void actualizarConsumo(@Param("Fecha") Date fechaentrada, @Param("descripcion") String descripcion,
                        @Param("PrecioUnitario") Integer precioUnitario, @Param("cantidad") Integer cantidad,
                        @Param("total") Integer total, @Param("servicio_id") Integer servicio_id,
                        @Param("numero_reserva") Integer numero_reserva, @Param("Usuario_id") int Usuario_id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM consumos WHERE id=:id", nativeQuery = true)
        void eliminarConsumo(@Param("id") int id);

}
