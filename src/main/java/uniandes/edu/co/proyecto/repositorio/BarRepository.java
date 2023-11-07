package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface BarRepository extends JpaRepository<Bar,Integer>{

     @Query(value = "SELECT.* FROM bar", nativeQuery = true)
        Collection<Bar> darBares();

        @Query(value = "SELECT.* FROM bar WHERE id = :id", nativeQuery = true)
        Bar darBar(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO bar (id, Ingredientes, Tipo_plato ,Disponible) VALUES(:id, :Ingredientes, :Tipo_plato, :Disponible )",nativeQuery = true)
        void insertarBar(@Param("id") int id,@Param("Ingredientes") String ingredientes, @Param("Tipo_plato") String tipoplato,
                        @Param("Disponible") String disponible);

        @Modifying
        @Transactional
        @Query(value = "UPDATE bar SET Ingredientes =:Ingredientes, Tipo_plato=:Tipo_plato, disponible=:disponible WHERE id =:id", nativeQuery = true)
        void actualizarBar(@Param("id") int id,@Param("Ingredientes") String ingredientes, @Param("Tipo_plato") String tipoplato,
                        @Param("Disponible") String disponible);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM bar WHERE id=:id", nativeQuery = true)
        void eliminarBar(@Param("id") int id);
    
}
