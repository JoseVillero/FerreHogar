package com.adsosena.egloapps.repositories;

import com.adsosena.egloapps.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**Interface ProductoRepository:
 * Esta interface implementa JpaRepository permitiendo heredar sus metodos para su utilizacion.
 * @author Jose David */
@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    List<Producto> findByNombreContainingIgnoreCaseOrReferenciaContainingIgnoreCaseOrMarcaContainingIgnoreCase
            (String nombre, String referencia, String marca);
}
