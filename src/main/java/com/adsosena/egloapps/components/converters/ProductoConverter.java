package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;

import java.util.ArrayList;

/**Clase ProductoConverter:
 * Brinda metodos que permite convertir un objeto de una clase modelo(una clase java estandar)
 * en un objeto de una entidad (una clase que representa una tabla)
 * @author Jose David */

public class ProductoConverter {


    /**Metodo productoToProductoModel:
     * permite convertir un objeto Producto(base de datos) a un objeto ProductoModel
     * @param producto de tipo Producto
     * @return ProductoModel*/
    public ProductoModel productoToProductoModel(Producto producto){

        ProductoModel productoModel = new ProductoModel();

        productoModel.setId(producto.getId());
        productoModel.setCodigo(producto.getCodigo());
        productoModel.setReferencia(producto.getReferencia());
        productoModel.setNombre(producto.getNombre());
        productoModel.setMarca(producto.getMarca());
        productoModel.setPrecio(producto.getPrecio());
        productoModel.setDescripcion(producto.getDescripcion());
        productoModel.setImagen(producto.getImagen());
        productoModel.setCantidadDisponible(producto.getCantidadDisponible());
        productoModel.setTransacciones(producto.getTransacciones());

        return productoModel;
    }

    /**Metodo productoModelToProducto:
     * permite convertir un objeto ProductoModel (objeto java) a un objeto Producto para persistencia en base de datos
     * @param productoModel de tipo ProductoModel
     * @return Producto*/
    public Producto productoModelToProducto(ProductoModel productoModel){
        Producto producto = setAtributosProductos(productoModel);
        producto.setTransacciones(new ArrayList<>());
        return producto;
    }

    public Producto actualizarProducto(ProductoModel productoModel){
       return setAtributosProductos(productoModel);
    }

    private Producto setAtributosProductos(ProductoModel productoModel){
        Producto producto = new Producto();

        producto.setId(productoModel.getId());
        producto.setCodigo(productoModel.getCodigo());
        producto.setReferencia(productoModel.getReferencia());
        producto.setNombre(productoModel.getNombre());
        producto.setMarca(productoModel.getMarca());
        producto.setDescripcion(productoModel.getDescripcion());
        producto.setPrecio(productoModel.getPrecio());
        producto.setImagen(productoModel.getImagen());
        producto.setCantidadDisponible(productoModel.getCantidadDisponible());

        return producto;
    }
}
