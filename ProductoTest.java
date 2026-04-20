import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @ParameterizedTest
    @CsvSource({
        "Leche,ALIMENTACION,2.5,1",
        "Jabón,HIGIENE,1.0,2",
        "Camiseta,ROPA,10.0,3",
        "Auriculares,ELECTRONICA,25.5,1",
        "Salsa,OTRO,0.5,5"
    })
    void constructorValidoCreaProducto(String nombre, CategoriaProducto categoria, double precio, int cantidad) {
        Producto producto = new Producto(nombre, precio, cantidad, categoria);

        assertEquals(nombre, producto.getNombre());
        assertEquals(categoria, producto.getCategoria());
        assertEquals(precio, producto.getPrecio(), 1e-9);
        assertEquals(cantidad, producto.getCantidad());
    }

    @Test
    void constructorNombreNullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> new Producto(null, 2.5, 1, CategoriaProducto.ALIMENTACION));
    }

    @Test
    void constructorNombreVacioLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> new Producto("", 1.0, 1, CategoriaProducto.HIGIENE));
    }

    @Test
    void constructorNombreMuyCortoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> new Producto("A", 5.0, 1, CategoriaProducto.ROPA));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -0.01})
    void constructorPrecioNoValidoLanzaExcepcion(double precio) {
        assertThrows(IllegalArgumentException.class,
            () -> new Producto("Leche", precio, 1, CategoriaProducto.ALIMENTACION));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void constructorCantidadNoValidaLanzaExcepcion(int cantidad) {
        assertThrows(IllegalArgumentException.class,
            () -> new Producto("Huevos", 1.0, cantidad, CategoriaProducto.ALIMENTACION));
    }

    @Test
    void constructorCategoriaNullSeConvierteEnOtro() {
        Producto producto = new Producto("Leche", 2.5, 1, null);

        assertEquals(CategoriaProducto.OTRO, producto.getCategoria());
    }
}