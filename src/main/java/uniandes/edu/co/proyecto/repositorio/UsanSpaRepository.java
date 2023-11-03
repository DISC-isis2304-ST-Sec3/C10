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

    @Query(value = "SELECT * FROM Usan_spa WHERE SPA_id = :SPA_id AND Reservaspa_id = :Reservaspa_id", nativeQuery = true)
    UsanSpa darUsanSpa(@Param("SPA_id") int id_SPA, @Param("Reservaspa_id") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usan_SPA (SPA_id,Reservaspa_id) VALUES(:SPA_id,:Reservaspa_id )", nativeQuery = true)
    void insertarUsanSpa(@Param("SPA_id") int id_SPA, @Param("Reservaspa_id") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Usan_SPA SET SPA_id=:SPA_id_nuevo ,Reservaspa_id=:Reservaspa_id_nuevo SPA_id = :SPA_id AND Reservaspa_id = :Reservaspa_id ", nativeQuery = true)
    void actualizarUsanSpa(@Param("SPA_id") int id_SPA, @Param("Reservaspa_id") int id_ReservaSPA, @Param("SPA_id_nuevo") int id_SPA_nuevo, @Param("Reservaspa_id_nuevo") int id_ReservaSPA_nuevo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usan_spa WHERE id_SPA = :id_SPA AND Reservaspa_id = :Reservaspa_id", nativeQuery = true)
    void eliminarUsanSpa(@Param("id_SPA") int id_SPA, @Param("Reservaspa_id") int id_ReservaSPA);

}
