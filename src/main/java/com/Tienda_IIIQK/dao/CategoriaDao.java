
package com.Tienda_IIIQK.dao;

import com.Tienda_IIIQK.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    List <Categoria> findByDescripcionContainingIgnoreCase(String descripcion);
}
