package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.UsanSpa;

@Repository

public interface UsanSpaRepository extends JpaRepository<UsanSpa, Integer> {

    @Query(value = "SELECT.* FROM Usan_spa", nativeQuery = true)
    Collection<UsanSpa> darUsanspas();

    @Query(value = "SELECT * FROM Usan_spa WHERE id_SPA = :id_SPA AND id_ReservaSPA = :id_ReservaSPA", nativeQuery = true)
    UsanSpa darUsanSpa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usan_SPA (id_SPA,id_ReservaSPA) VALUES(hotel_sequence.nextval, :id_SPA,id_ReservaSPA )")
    void insertarUsanSpa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "UPDATE INTO Usan_SPA (id_SPA,id_ReservaSPA) VALUES(hotel_sequence.nextval, :id_SPA,id_ReservaSPA )")
    void actualizarUsanSpa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usan_spa WHERE id_SPA = :id_SPA AND id_ReservaSPA = :id_ReservaSPA", nativeQuery = true)
    void eliminarUsanSpa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);

}
