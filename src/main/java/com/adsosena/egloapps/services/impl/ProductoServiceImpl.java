package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.components.converters.ProductConverter;
import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;
import com.adsosena.egloapps.repositories.ProductoRepository;
import com.adsosena.egloapps.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<ProductoModel> listarProductos() {

        ProductConverter productConverter = new ProductConverter();
        List<ProductoModel> productos = new ArrayList<>();
        List<Producto> productoList = productoRepository.findAll();
        System.out.println(productoList);

        for (Producto producto : productoList) {
            productos.add(productConverter.productoToProductoModel(producto));
        }
        return productos;
    }

}
