package uniandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.SPA;

public interface SPARepository extends JpaRepository<SPA,Integer> {

     @Query(value = "SELECT.* FROM SPA", nativeQuery = true)
        Collection<SPA> darSPAS();

        @Query(value = "SELECT.* FROM SPA WHERE id = :id", nativeQuery = true)
        SPA darSPA(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO SPA (id,nombre,Duracion_min,Tipo,Costo) VALUES(hotel_sequence.nextval,:id, :nombre, :Duracion_min, :Tipo, :Costo )")
        void insertarSPA(@Param("id") int id, @Param("nombre") String Nombre_2,
                        @Param("Duracion_min") int Duracionmin, 
                        @Param("Tipo") String Tipo,
                        @Param("Costo") int Costo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE SPA SET nombre =:nombre, Duracion_min=:Duracion_min, Tipo=:Tipo, Costo=:Costo WHERE id =:id", nativeQuery = true)
        void actualizarSPA(@Param("id") int id, @Param("nombre") String Nombre_2,
                        @Param("Duracion_min") int Duracionmin, 
                        @Param("Tipo") String Tipo,
                        @Param("Costo") int Costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM SPA WHERE id=:id", nativeQuery = true)
    void eliminarSPA(@Param("id") int id);
    
}
