package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

      @Query(value = "SELECT.* FROM empleado", nativeQuery = true)
        Collection<Empleado> darEmpleados();

        @Query(value = "SELECT.* FROM empleado WHERE id = :id", nativeQuery = true)
        Empleado darEmpleado(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO empleado (id, Funcion,salario,longevidad) VALUES(:id, :Funcion, :salario, :longevidad)",nativeQuery = true)
        void insertarEmpleado(@Param("id") int id,@Param("Funcion") String funcion, @Param("descripcion") String descripcion,
                        @Param("salario") Integer salario, @Param("longevidad") Integer longevidad);

        @Modifying
        @Transactional
        @Query(value = "UPDATE empleado SET Funcion =:Funcion, salario=:salario, longevidad=:longevidad WHERE id =:id", nativeQuery = true)
        void actualizarEmpleado(@Param("id") int id,@Param("Funcion") String funcion, @Param("descripcion") String descripcion,
                        @Param("salario") Integer salario, @Param("longevidad") Integer longevidad);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM empleado WHERE id=:id", nativeQuery = true)
        void eliminarEmpleado(@Param("id") int id);
    
}
