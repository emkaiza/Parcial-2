import java.util.ArrayList;

/**
 * Encapsula la lógica de gestión de productos del carrito.
 * <p>
 * Mantiene una lista de productos y calcula el total de la compra.
 * </p>
 */
public class GestorCarrito {
    /** Lista pública de productos del carrito para uso directo cuando sea necesario. */
    public ArrayList<Producto> lista;

    /** Total acumulado de los productos agregados. */
    private double total;

    /**
     * Inicializa un gestor de carrito con lista vacía y total en cero.
     */
    public GestorCarrito() {
        lista = new ArrayList<>();
        total = 0.0;
    }

    /**
     * Agrega un producto al carrito y actualiza el total.
     *
     * @param producto producto a agregar
     */
    public void agregarProducto(Producto producto) {
        lista.add(producto);
        total += producto.getPrecio() * producto.getCantidad();
        System.out.println(producto.getNombre() + ConstantesUI.PRODUCTO_ANADIDO + producto.getCantidad() + ConstantesUI.PRECIO_TOTAL + producto.getPrecio() * producto.getCantidad());
    }

    /**
     * Muestra en consola el detalle de los productos del carrito y el total.
     */
    public void mostrarProductos() {
        if (lista.isEmpty()) {
            System.out.println(ConstantesUI.CARRITO_VACIO);
        } else {
            System.out.println(ConstantesUI.LISTADO_PRODUCTOS);
            for (Producto producto : lista) {
                System.out.println(ConstantesUI.PRODUCTO_ELEMENTO_INICIO + producto.getNombre() + " [" + producto.getCategoria().getEtiqueta() + "]" + ConstantesUI.PRODUCTO_CANTIDAD + producto.getCantidad() + ConstantesUI.PRODUCTO_CIERRE);
            }
            System.out.println(ConstantesUI.TOTAL + total);
        }
    }

    /**
     * Calcula el total acumulado de la compra.
     *
     * @return total de la compra
     */
    public double calcularTotal() {
        return total;
    }

    /**
     * Elimina todos los productos del carrito y reinicia el total.
     */
    public void vaciarCarrito() {
        lista.clear();
        total = 0.0;
    }
}
