package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.UsanServicios;
import uniandes.edu.co.proyecto.modelo.UsanSpa;

@Repository

public interface UsanServiciosRepository extends JpaRepository<UsanServicios, Integer> {

        @Query(value = "SELECT.* FROM Usan_servicios", nativeQuery = true)
        Collection<UsanServicios> darUsanServicioss();

        @Query(value = "SELECT * FROM Usan_servicios WHERE cliente_id = :cliente_id AND servicio_id = :servicio_id", nativeQuery = true)
        UsanServicios darUsan_servicios(@Param("cliente_id") int id_cliente,
                        @Param("servicio_id") int id_servicio);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO Usan_servicios (cliente_id,servicio_id) VALUES(:cliente_id,:servicio_id )", nativeQuery = true)
        void insertarUsan_servicios(@Param("cliente_id") int id_cliente,
                        @Param("servicio_id") int id_servicio);

        @Modifying
        @Transactional
        @Query(value = "UPDATE Usan_servicios SET cliente_id=:cliente_id_nuevo ,servicio_id=:servicio_id_nuevo WHERE cliente_id = :cliente_id AND servicio_id = :servicio_id", nativeQuery = true)
        void actualizarUsan_servicios(@Param("cliente_id") int id_cliente,
                        @Param("servicio_id") int id_servicio,@Param("cliente_id_nuevo") int id_cliente_nuevo,
                        @Param("servicio_id_nuevo") int id_servicio_nuevo);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Usan_servicios WHERE cliente_id =:cliente_id AND servicio_id =:servicio_id", nativeQuery = true)
        void eliminarUsan_servicios(@Param("cliente_id") int id_cliente,
                        @Param("servicio_id") int id_servicio);

}
