package com.adsosena.egloapps.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProductoModelTest {

    private ProductoModel productoModel;

    private ProductoModel productoModel2;


    @BeforeEach
    void setUp() {

        productoModel = new ProductoModel(6,203,"LAMPARA CRISTAL", "LAMPARA DE COMEDOR",
                "EGLO",174000.05,"DESCRIPTION TEST");

        productoModel2 = new ProductoModel();

    }

    @Test
    void testAllArgumentsConstructor(){
        assertNotNull(productoModel);
    }

    @Test
    void testNoArgumentsConstructor(){
        assertNotNull(productoModel2);
    }

    @Test
    void getId() {
        assertEquals(6, productoModel.getId());
    }

    @Test
    void getCodigo() {
        assertEquals(203, productoModel.getCodigo());
    }

    @Test
    void getReferencia() {
        assertEquals("LAMPARA CRISTAL", productoModel.getReferencia());
    }

    @Test
    void getNombre() {
        assertEquals("LAMPARA DE COMEDOR", productoModel.getNombre());
    }

    @Test
    void getMarca() {
        assertEquals("EGLO", productoModel.getMarca());
    }

    @Test
    void getPrecio() {
        assertEquals(174000.05,productoModel.getPrecio());

    }

    @Test
    void getDescripcion() {
        assertEquals("DESCRIPTION TEST", productoModel.getDescripcion());
    }

    @Test
    void setId() {
        productoModel2.setId(5);
        assertEquals(5, productoModel2.getId());
    }

    @Test
    void setCodigo() {
        productoModel2.setCodigo(105);
        assertEquals(105, productoModel2.getCodigo());
    }

    @Test
    void setReferencia() {
        productoModel2.setReferencia("LAMPARA");
        assertEquals("LAMPARA", productoModel2.getReferencia());
    }

    @Test
    void setNombre() {
        productoModel2.setNombre("LAMPARA LED");
        assertEquals("LAMPARA LED", productoModel2.getNombre());
    }

    @Test
    void setMarca() {
        productoModel2.setMarca("EGLO");
        assertEquals("EGLO", productoModel2.getMarca());
    }

    @Test
    void setPrecio() {
        productoModel2.setPrecio(180000.45);
        assertEquals(180000.45, productoModel2.getPrecio());
    }

    @Test
    void setDescripcion() {
        productoModel2.setDescripcion("TEST DESCRIPTION");
        assertEquals("TEST DESCRIPTION", productoModel2.getDescripcion());
    }
}