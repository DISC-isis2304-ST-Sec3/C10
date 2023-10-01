package uniandes.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva, Integer> {

    @Query(value = "SELECT.* FROM reservas",nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value= "SELECT.* FROM bares WHERE id = :id",nativeQuery = true)
    Reserva darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (fechaEntrada,FechaSalida,NumeroPersonas,Cliente_NumerodeIdentificacion,Estado,Empleado_id) VALUES(hotel_sequence.nextval, :fechaEntrada, :FechaSalida, :NumeroPersonas, :Cliente_NumerodeIdentificacion, :Estado, :Empleado_id )")
    void insertarReserva(@Param("fechaEntrada") Date fechaentrada, @Param("FechaSalida") Date fechasalida, 
    @Param("NumeroPersonas") Integer numeropersonas,@Param("Cliente_NumerodeIdentificacion") Integer numerodocumento
    ,@Param("Estado") String estado,@Param("Empleado_id") Integer id_empleado  );


    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET fechaEntrada =:fechaEntrada, FechaSalida=:FechaSalida, NumeroPersonas=:NumeroPersonas, Cliente_NumeroIdentificacion=:Cliente_NumerodeIdentificacion, Estado=:Estado, Empleado_id=:Empleado_id WHERE id =:id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("fechaEntrada") Date fechaentrada, @Param("FechaSalida") Date fechasalida, 
    @Param("NumeroPersonas") Integer numeropersonas,@Param("Cliente_NumerodeIdentificacion") Integer numerodocumento
    ,@Param("Estado") String estado, @Param("Empleado_id") Integer id_empleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id=.id",nativeQuery = true)
    void eliminarReserva(@Param("id") int id);
    
    
}
