package com.adsosena.egloapps.services;

import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;

import java.util.List;


/**interface ProductoService: Esta interface declara los metodos a usar para los servicios(Logica de negocio)
 * @author Jose David */
public interface ProductoService {

    List<ProductoModel> listarProductos();
    Producto agregarProducto(ProductoModel productoModel);

}
