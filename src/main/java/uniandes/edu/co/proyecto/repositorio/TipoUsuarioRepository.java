package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
    @Modifying
    @Transactional
    @Query("INSERT INTO TipoUsuario (id, nombre, descripcion) VALUES(:id, :nombre, :descripcion)")
    void insertarTipoUsuario(@Param("id") Integer id, @Param("nombre") String nombre,
            @Param("descripcion") String descripcion);
}