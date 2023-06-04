package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;

public class ProductConverter {

    public ProductoModel productoToProductoModel(Producto producto){

        ProductoModel productoModel = new ProductoModel();

        productoModel.setId(producto.getId());
        productoModel.setCodigo(producto.getCodigo());
        productoModel.setReferencia(producto.getReferencia());
        productoModel.setNombre(producto.getNombre());
        productoModel.setMarca(producto.getMarca());
        productoModel.setPrecio(producto.getPrecio());
        productoModel.setDescripcion(producto.getDescripcion());
        return productoModel;
    }

    public Producto productoModelToProducto(ProductoModel productoModel){

        Producto producto = new Producto();

        producto.setCodigo(productoModel.getCodigo());
        producto.setReferencia(productoModel.getReferencia());
        producto.setNombre(productoModel.getNombre());
        producto.setMarca(productoModel.getMarca());
        producto.setDescripcion(productoModel.getDescripcion());
        return producto;
    }





}
