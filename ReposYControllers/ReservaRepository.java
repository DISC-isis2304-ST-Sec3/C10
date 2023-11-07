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

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

        @Query(value = "SELECT.* FROM reservas", nativeQuery = true)
        Collection<Reserva> darReservas();

        @Query(value = "SELECT.* FROM reservas WHERE id = :id", nativeQuery = true)
        Reserva darReserva(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO reservas (id, fechaEntrada,FechaSalida,NumeroPersonas,Cliente_id,Estado,Empleado_id) VALUES(:id :fechaEntrada, :FechaSalida, :NumeroPersonas, :Cliente_id, :Estado, :Empleado_id )",nativeQuery = true)
        void insertarReserva(@Param("id") int id, @Param("fechaEntrada") Date fechaentrada,
                        @Param("FechaSalida") Date fechasalida,
                        @Param("NumeroPersonas") Integer numeropersonas,
                        @Param("Cliente_id") Cliente numerodocumento,
                        @Param("Estado") String estado,
                        @Param("Empleado_id") Integer id_empleado);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reservas SET fechaEntrada =:fechaEntrada, FechaSalida=:FechaSalida, NumeroPersonas=:NumeroPersonas, Cliente_id=:Cliente_id, Estado=:Estado, Empleado_id=:Empleado_id WHERE id =:id", nativeQuery = true)
        void actualizarReserva(@Param("id") int id, @Param("fechaEntrada") Date fechaentrada,
                        @Param("FechaSalida") Date fechasalida,
                        @Param("NumeroPersonas") Integer numeropersonas,
                        @Param("Cliente_id") Cliente numerodocumento,
                        @Param("Estado") String estado,
                        @Param("Empleado_id") Integer id_empleado);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reservas WHERE id=:id", nativeQuery = true)
        void eliminarReserva(@Param("id") int id);

}
