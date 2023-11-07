package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante,Integer> {

     @Query(value = "SELECT.* FROM restaurante", nativeQuery = true)
        Collection<Reserva> darConsumos();

        @Query(value = "SELECT.* FROM restaurante WHERE id = :id", nativeQuery = true)
        Restaurante darConsumo(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO restaurante (id, Menu, Tipo_plato ,Disponible) VALUES(:id, :Ingredientes, :Tipo_plato, :Disponible )",nativeQuery = true)
        void insertarConsumo(@Param("id") int id,@Param("Menu") String menu, @Param("Tipo_plato") String tipoplato,
                        @Param("Disponible") String disponible);

        @Modifying
        @Transactional
        @Query(value = "UPDATE restaurante SET Menu =:Menu, Tipo_plato=:Tipo_plato, disponible=:disponible WHERE id =:id", nativeQuery = true)
        void actualizarConsumo(@Param("id") int id,@Param("Menu") String menu, @Param("Tipo_plato") String tipoplato,
                        @Param("Disponible") String disponible);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM restaurante WHERE id=:id", nativeQuery = true)
        void eliminarConsumo(@Param("id") int id);
    
}
