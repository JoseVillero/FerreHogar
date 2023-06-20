package com.adsosena.egloapps.repositories;

import com.adsosena.egloapps.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Interface ProductoRepository:
 * Esta interface implementa JpaRepository permitiendo heredar sus metodos para su utilizacion.
 * @author Jose David */
@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

}
