package uniandes.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Acompaniante;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface AcompanianteRepository extends JpaRepository<Acompaniante,Integer> {
    
    @Query(value = "SELECT.* FROM acompaniantes",nativeQuery = true)
    Collection<Acompaniante> darAcompaniantes();

    @Query(value= "SELECT.* FROM acompaniantes WHERE Num_doc = :Num_doc",nativeQuery = true)
    Reserva darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO acompaniantes (Num_doc,Nombre,Apellido,Tipo_doc) VALUES(hotel_sequence.nextval, :Num_doc, :Nombre, :Apellido, :Tipo_doc)")
    void insertarReserva(@Param("Num_doc") int Num_doc, @Param("Nombre") String Nombre, 
    @Param("Apellido") String Apellido,@Param("Tipo_doc") String Tipo_doc );


    @Modifying
    @Transactional
    @Query(value = "UPDATE acompaniantes SET Num_doc =:Num_doc, Nombre=:Nombre, Apellido=:Apellido, Tipo_doc=:Tipo_doc WHERE Num_doc =:Num_doc", nativeQuery = true)
    void actualizarReserva(@Param("Num_doc") int Num_doc, @Param("Nombre") String Nombre, @Param("Apellido") String Apellido,
    @Param("Tipo_doc") String Tipo_doc);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM acompaniantes WHERE Num_doc=:Num_doc",nativeQuery = true)
    void eliminarReserva(@Param("id") int id);
    
}
