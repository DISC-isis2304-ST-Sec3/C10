package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservaSpa;

@Repository

public interface ReservaSpaRepository extends JpaRepository<ReservaSpa, Integer> {

        @Query(value = "SELECT.* FROM reservasSPA", nativeQuery = true)
        Collection<ReservaSpa> darReservasSpa();

        @Query(value = "SELECT.* FROM reservasSPA WHERE id = :id", nativeQuery = true)
        ReservaSpa darReservaSpa(@Param("id") Integer id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO reservasSPA (id, horario, habitacion_numero, cliente_id) VALUES(:id, :horario, :habitacion_numero, :cliente_id)", nativeQuery = true)
        void insertarReservaSpa(@Param("id") Integer id, @Param("horario") Date horario, @Param("habitacion_numero") Integer numerohabitacion,
        @Param("cliente_id") Integer numerodocumento);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reservasSPA SET id =:id, horario=:horario, habitacion_numero=:habitacion_numero, cliente_id=:cliente_id WHERE id=:id", nativeQuery = true)
        void actualizarReservaSpa(@Param("id") Integer id, @Param("horario") Date horario,@Param("habitacion_numero") Integer numerohabitacion,
        @Param("cliente_id") Integer numerodocumento);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reservasSPA WHERE id=:id", nativeQuery = true)
        void eliminarReservaSpa(@Param("id") Integer id);

}
