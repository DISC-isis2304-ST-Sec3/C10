package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.modelo.Consumo;

@Repository
public interface ConsultasBasicasRepository extends JpaRepository<Consumo, Integer> {
    @Query("SELECT c.servicio.id, COUNT(*) AS CANT_CONSUMOS " +
            "FROM Consumo c " +
            "WHERE c.fecha BETWEEN ?1 AND ?2 " +
            "GROUP BY c.servicio.id " +
            "ORDER BY COUNT(*) DESC")
    List<Object[]> findConsumoByDateRange(Date startDate, Date endDate);
}
