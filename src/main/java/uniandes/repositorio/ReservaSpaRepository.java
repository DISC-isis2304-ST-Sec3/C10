package uniandes.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservaSpa;

public interface ReservaSpaRepository extends JpaRepository<ReservaSpa, Integer>{

    @Query(value = "SELECT.* FROM reservasSPA",nativeQuery = true)
    Collection<ReservaSpa> darReservas();

    @Query(value= "SELECT.* FROM reservasSPA WHERE id = :id",nativeQuery = true)
    Reserva darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasSPA (fechaEntrada,FechaSalida,NumeroPersonas,Cliente_NumerodeIdentificacion,Estado,Empleado_id,Habitacion_numero) VALUES(hotel_sequence.nextval, :fechaEntrada, :FechaSalida, :NumeroPersonas, :Cliente_NumerodeIdentificacion, :Estado, :Empleado_id, :Habitacion_numero )")
    void insertarReserva(@Param("fechaEntrada") Date fechaentrada, @Param("FechaSalida") Date fechasalida, 
    @Param("NumeroPersonas") Integer numeropersonas,@Param("Cliente_NumerodeIdentificacion") Integer numerodocumento
    ,@Param("Estado") String estado,@Param("Empleado_id") Integer id_empleado, @Param("Habitacion_numero") int Habitacion_numero  );


    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasSPA SET fechaEntrada =:fechaEntrada, FechaSalida=:FechaSalida, NumeroPersonas=:NumeroPersonas, Cliente_NumeroIdentificacion=:Cliente_NumerodeIdentificacion, Estado=:Estado, Empleado_id=:Empleado_id WHERE id =:id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("fechaEntrada") Date fechaentrada, @Param("FechaSalida") Date fechasalida, 
    @Param("NumeroPersonas") Integer numeropersonas,@Param("Cliente_NumerodeIdentificacion") Integer numerodocumento
    ,@Param("Estado") String estado, @Param("Empleado_id") Integer id_empleado, @Param("Habitacion_numero") int Habitacion_numero );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasSPA WHERE id=:id",nativeQuery = true)
    void eliminarReserva(@Param("id") int id);
    







    
    
    
}
