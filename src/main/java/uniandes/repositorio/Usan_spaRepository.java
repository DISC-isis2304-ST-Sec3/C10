package uniandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Usan_spa;

public interface Usan_spaRepository extends JpaRepository<Usan_spa,Integer> {

     @Query(value = "SELECT.* FROM Usan_spa", nativeQuery = true)
    Collection<Usan_spa> darUsan_spa();

    @Query(value = "SELECT * FROM Usan_spa WHERE id_SPA = :id_SPA AND id_ReservaSPA = :id_ReservaSPA", nativeQuery = true)
    Usan_spa darUsan_spa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usan_SPA (id_SPA,id_ReservaSPA) VALUES(hotel_sequence.nextval, :id_SPA,:id_ReservaSPA )")
    void insertarUsan_spa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);

     @Modifying
    @Transactional
    @Query(value = "UPDATE INTO Usan_SPA (id_SPA,id_ReservaSPA) VALUES(hotel_sequence.nextval, :id_SPA,:id_ReservaSPA )")
    void actualizarUsan_spa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usan_spa WHERE id_SPA = :id_SPA AND id_ReservaSPA = :id_ReservaSPA", nativeQuery = true)
    void eliminarUsan_spa(@Param("id_SPA") int id_SPA, @Param("id_ReservaSPA") int id_ReservaSPA);
    
}
