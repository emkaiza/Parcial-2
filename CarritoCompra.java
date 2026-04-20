
/**
 * Clase principal del programa que utiliza {@link GestorCarrito} para gestionar
 * la interacción con un carrito de compra.
 * <p>
 * Esta clase sirve como punto de entrada y delega las operaciones de gestión de
 * productos a la clase {@link GestorCarrito}.
 * </p>
 */
public class CarritoCompra {
    /** Gestor responsable de la lista de productos y del cálculo del total. */
    private GestorCarrito gestor;

    /**
     * Crea una nueva instancia de carrito con un gestor vacío.
     */
    public CarritoCompra() {
        gestor = new GestorCarrito();
    }

    /**
     * Agrega un producto al carrito.
     *
     * @param producto producto a agregar
     */
    public void agregarProducto(Producto producto) {
        gestor.agregarProducto(producto);
    }

    /**
     * Muestra en consola los productos actualmente en el carrito.
     */
    public void mostrarProductos() {
        gestor.mostrarProductos();
    }

    /**
     * Vacía el carrito eliminando todos los productos y reiniciando el total.
     */
    public void vaciarCarrito() {
        gestor.vaciarCarrito();
    }

    /**
     * Devuelve el gestor interno del carrito.
     *
     * @return gestor del carrito
     */
    public GestorCarrito getGestor() {
        return gestor;
    }

    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        CarritoCompra carrito = new CarritoCompra();
        Producto leche = new Producto("Leche", 2.5, 1, CategoriaProducto.ALIMENTACION);
        Producto pan = new Producto("Pan", 1.0, 2, CategoriaProducto.ALIMENTACION);
        Producto huevos = new Producto("Huevos", 3.0, 1, CategoriaProducto.ALIMENTACION);
        carrito.agregarProducto(leche);
        carrito.agregarProducto(pan);
        carrito.agregarProducto(huevos);
        carrito.mostrarProductos();
        
        carrito.vaciarCarrito();
        System.out.println(ConstantesUI.CARRITO_VACIADO);
        carrito.mostrarProductos();
    }
}