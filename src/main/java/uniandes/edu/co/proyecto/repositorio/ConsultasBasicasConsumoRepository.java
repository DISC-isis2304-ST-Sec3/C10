package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.modelo.Consumo;

@Repository
public interface ConsultasBasicasConsumoRepository extends JpaRepository<Consumo, Integer> {
        @Query("SELECT c.servicio.id, COUNT(*) AS CANT_CONSUMOS " +
                        "FROM Consumo c " +
                        "WHERE c.fecha BETWEEN ?1 AND ?2 " +
                        "GROUP BY c.servicio.id " +
                        "ORDER BY COUNT(*) DESC")
        List<Object[]> findConsumoByDateRange(Date startDate, Date endDate);

        @Query("SELECT c.servicio.id FROM Consumo c WHERE (c.fecha BETWEEN :startDate AND :endDate) AND (c.precioUnitario = :precioUnitario)")
        List<Integer> findServicioIdsByFechaAndPrecioUnitario(@Param("startDate") Date startDate,
                        @Param("endDate") Date endDate, @Param("precioUnitario") int precioUnitario);

        @Query("SELECT c.id, c.descripcion, c.total, c.usuarioid.id, c.servicio.id " +
                        "FROM Consumo c " +
                        "WHERE (c.usuarioid.id = ?1) AND (c.fecha BETWEEN ?2 AND ?3)")
        List<Object[]> findConsumoByClienteIdAndFechaBetween(Long clienteId, Date startDate, Date endDate);

}
