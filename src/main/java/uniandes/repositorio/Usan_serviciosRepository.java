package uniandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usan_servicios;
import uniandes.edu.co.proyecto.modelo.Usan_spa;

public interface Usan_serviciosRepository extends JpaRepository<Usan_servicios, Integer> {

    @Query(value = "SELECT.* FROM Usan_servicios", nativeQuery = true)
    Collection<Usan_servicios> darUsan_servicios();

    @Query(value = "SELECT * FROM Usan_servicios WHERE NumerodeIdentificación_cliente = :NumerodeIdentificación_cliente AND id_servicio = :id_servicio", nativeQuery = true)
    Usan_servicios darUsan_servicios(@Param("NumerodeIdentificación_cliente") int id_cliente, @Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usan_servicios (NumerodeIdentificación_cliente,id_servicios) VALUES(hotel_sequence.nextval, :NumerodeIdentificación_cliente,:id_servicios )")
    void insertarUsan_servicios(@Param("NumerodeIdentificación_cliente") int id_cliente, @Param("id_servicio") int id_servicio);

     @Modifying
    @Transactional
    @Query(value = "UPDATE INTO Usan_servicios (NumerodeIdentificación_cliente,id_servicios) VALUES(hotel_sequence.nextval, :NumerodeIdentificación_cliente,:id_servicios )")
    void actualizarUsan_servicios(@Param("NumerodeIdentificación_cliente") int id_cliente, @Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usan_servicios WHERE NumerodeIdentificación_cliente = :NumerodeIdentificación_cliente AND id_servicios = :id_servicios", nativeQuery = true)
    void eliminarUsan_servicios(@Param("NumerodeIdentificación_cliente") int id_cliente, @Param("id_servicio") int id_servicio);
    
}
