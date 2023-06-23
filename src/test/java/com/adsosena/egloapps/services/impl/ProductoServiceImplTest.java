package com.adsosena.egloapps.services.impl;


import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;
import com.adsosena.egloapps.repositories.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductoServiceImplTest {

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Mock
    private ProductoRepository productoRepository;


    private List<Producto> productoList;

    @BeforeEach
    void setUp() {

        productoList = new ArrayList<>();

        Producto producto = new Producto();
        Producto producto2 = new Producto();

        producto.setId(1);
        producto.setCodigo(203);
        producto.setReferencia("LAMPARA");
        producto.setNombre("LAMPARA LED");
        producto.setPrecio(155000.85);
        producto.setMarca("EGLO");
        producto.setDescripcion("TEST DESCRIPTION ");

        producto2.setId(2);
        producto2.setCodigo(105);
        producto2.setReferencia("BOMBILLA");
        producto2.setNombre("BOMBILLA LED");
        producto2.setPrecio(190000.95);
        producto2.setMarca("EGLO");
        producto2.setDescripcion("TEST DESCRIPTION ");

        productoList.add(producto);
        productoList.add(producto2);


        when(productoRepository.findAll()).thenReturn(productoList);

    }

    @Test
    void listarProductos() {

        List<ProductoModel> productoModelListTest = productoService.listarProductos();

        assertEquals(2, productoModelListTest.size());
        assertInstanceOf(ProductoModel.class,productoModelListTest.get(0));
        assertInstanceOf(ProductoModel.class,productoModelListTest.get(1));

    }


}