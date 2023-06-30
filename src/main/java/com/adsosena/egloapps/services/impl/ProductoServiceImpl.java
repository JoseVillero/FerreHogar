package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.components.converters.ProductoConverter;
import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;
import com.adsosena.egloapps.repositories.ProductoRepository;
import com.adsosena.egloapps.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**Clase ProductoServiceImpl: Esta clase ejecuta los servicios
 * es decir contiene la logica de negocio de la aplicacion.
 * Esta clase implementa la interface ProductoService, dicha interface
 * tiene metodos declados. La clase ProductoServiceImpl sobreescribe los metodos heredados de la interface
 * @author Jose David */
@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    private ProductoConverter productoConverter;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
        this.productoConverter = new ProductoConverter();
    }

    /**Metodo listarProductos: Este metodo solicita al objeto del repositorio buscar todos
     * los productos de la base de datos y retorna un listado de estos
     * @return List<ProductoModel></>*/
    @Override
    public List<ProductoModel> listarProductos() {

        List<ProductoModel> productos = new ArrayList<>();
        List<Producto> productoList = productoRepository.findAll();

        for (Producto producto : productoList) {
            productos.add(productoConverter.productoToProductoModel(producto));
        }
        return productos;
    }

    @Override
    public Producto agregarProducto(ProductoModel productoModel) {

        return productoRepository.save(productoConverter.productoModelToProducto(productoModel));
    }

}
