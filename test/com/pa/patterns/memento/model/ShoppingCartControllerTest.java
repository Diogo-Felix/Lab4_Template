package com.pa.patterns.memento.model;

import org.junit.jupiter.api.*;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


class ShoppingCartControllerTest {
    private ShoppingCartController ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new ShoppingCartController();
    }

    @Test
    void addProduct() {
        assertEquals(0, ctrl.getProducts().size());
        ctrl.addProduct("Test product", 42.0);
        assertEquals(1, ctrl.getProducts().size());
    }

    @Test
    void reset() {
        ctrl.addProduct("Test product", 42.0);
        ctrl.addProduct("Test product2", 43.0);
        ctrl.reset();
        assertEquals(0, ctrl.getProducts().size());
    }

    @Test
    void removeProduct() {
        ctrl.addProduct("Test product", 42.0);
        ctrl.removeProduct("Test product");
        assertEquals(0, ctrl.getProducts().size());
    }

    @Test
    void undo() throws NoMementoException {
        ctrl.addProduct("Test product", 42.0);
        ctrl.undo();
        assertEquals(0, ctrl.getProducts().size());
    }

    @Test
    void getProducts() {
        ctrl.addProduct("product test", 10);
        Collection<Product> products = ctrl.getProducts();
        assertEquals(products,ctrl.getProducts());
    }

    @Test
    void showAll() {
        ctrl.addProduct("product test", 10);
        assertEquals("[product test (10.0)]", ctrl.getProducts().toString());
    }
}