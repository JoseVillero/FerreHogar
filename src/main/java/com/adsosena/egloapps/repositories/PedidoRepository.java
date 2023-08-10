package com.adsosena.egloapps.repositories;

import com.adsosena.egloapps.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Modifying
    @Query("UPDATE Pedido p SET p.cantidad = :cantidad WHERE p.id = :id")
    void updateCantidad(@Param("id") Long id, @Param("cantidad") int cantidad);
}
