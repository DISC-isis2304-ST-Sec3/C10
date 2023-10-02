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

public interface ReservaSpaRepository extends JpaRepository<ReservaSpa, Integer> {

        @Query(value = "SELECT.* FROM reservasSPA", nativeQuery = true)
        Collection<ReservaSpa> darReservasSpa();

        @Query(value = "SELECT.* FROM reservasSPA WHERE id = :id", nativeQuery = true)
        ReservaSpa darReservaSpa(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO reservasSPA (id, horario")
        void insertarReservaSpa(@Param("id") int id, @Param("horario") Date horario);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reservasSPA SET id =:id, horario=:horario", nativeQuery = true)
        void actualizarReservaSpa(@Param("id") int id, @Param("horario") Date horario);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reservasSPA WHERE id=:id", nativeQuery = true)
        void eliminarReservaSpa(@Param("id") int id);

}
