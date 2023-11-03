package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.PlanDeConsumo;

@Repository

public interface PlanDeConsumoRepository extends JpaRepository<PlanDeConsumo, Integer> {

    @Query(value = "SELECT.* FROM PlanDeConsumo", nativeQuery = true)
    Collection<PlanDeConsumo> darPlanes();

    @Query(value = "SELECT.* FROM PlanDeConsumo WHERE id = :id", nativeQuery = true)
    PlanDeConsumo darPlan(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PlanDeConsumo (id, Nombre,Descripcion,Descuento) VALUES(:id, :Nombre, :Descripcion, :Descuento)",nativeQuery = true)
    void insertarPlan(@Param("id") int id, @Param("Nombre") String Nombre,
            @Param("Descripcion") String Descripcion,
            @Param("Descuento") int Descuento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PlanDeConsumo SET id=:id, Nombre =:Nombre, Descripcion=:Descripcion, Descuento=:Descuento WHERE id =:id", nativeQuery = true)
    void actualizarPlan(@Param("id") int id, @Param("Nombre") String Nombre,
            @Param("Descripcion") String Descripcion,
            @Param("Descuento") int Descuento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PlanDeConsumo WHERE id=:id", nativeQuery = true)
    void eliminarPlan(@Param("id") int id);

}
