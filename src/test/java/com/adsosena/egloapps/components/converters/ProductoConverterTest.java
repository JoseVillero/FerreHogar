package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.models.ProductoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductoConverterTest {

    @InjectMocks
    private ProductoConverter productoConverter;

    @Mock
    private Producto producto;

    @Mock
    private ProductoModel productoModel;


    @BeforeEach
    void setUp() {

        when(producto.getId()).thenReturn(1);
        when(producto.getCodigo()).thenReturn(103);
        when(producto.getReferencia()).thenReturn("LAMPARA");
        when(producto.getNombre()).thenReturn("Producto de prueba");
        when(producto.getMarca()).thenReturn("Marca de prueba");
        when(producto.getPrecio()).thenReturn(145000.0);
        when(producto.getDescripcion()).thenReturn("Descripción de prueba");


        when(productoModel.getCodigo()).thenReturn(105);
        when(productoModel.getReferencia()).thenReturn("LAMPARA");
        when(productoModel.getNombre()).thenReturn("Producto de prueba 2");
        when(productoModel.getMarca()).thenReturn("Marca de prueba 2");
        when(productoModel.getDescripcion()).thenReturn("Descripción de prueba 2");

    }

    @Test
    void testProductoToProductoModel() {

        ProductoModel productoModel = productoConverter.productoToProductoModel(producto);
        assertNotNull(productoModel);
        assertEquals(producto.getId(), productoModel.getId());
        assertEquals(producto.getCodigo(), productoModel.getCodigo());
        assertEquals(producto.getReferencia(), productoModel.getReferencia());
        assertEquals(producto.getNombre(), productoModel.getNombre());
        assertEquals(producto.getMarca(), productoModel.getMarca());
        assertEquals(producto.getPrecio(), productoModel.getPrecio());
        assertEquals(producto.getDescripcion(), productoModel.getDescripcion());
    }

    @Test
    void testProductoModelToProducto() {

        Producto producto = productoConverter.productoModelToProducto(productoModel);
        assertNotNull(producto);

        assertEquals(productoModel.getCodigo(), producto.getCodigo());
        assertEquals(productoModel.getReferencia(), producto.getReferencia());
        assertEquals(productoModel.getNombre(), producto.getNombre());
        assertEquals(productoModel.getMarca(), producto.getMarca());
        assertEquals(productoModel.getDescripcion(), producto.getDescripcion());
    }
}