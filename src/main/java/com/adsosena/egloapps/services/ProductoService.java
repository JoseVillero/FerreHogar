package com.adsosena.egloapps.services;

import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;

import java.util.List;


/**Interface ProductoService: Esta interface declara los metodos a usar para los servicios(Logica de negocio)
 * @author Jose David */
public interface ProductoService {

    List<ProductoModel> listarProductos();

    Producto agregarProducto(ProductoModel productoModel);

    void eliminarProducto(int id);

    void actualizarProducto(ProductoModel productoModel);

    List<ProductoModel> buscarProductos(String busqueda);


}
