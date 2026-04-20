/**
 * Contiene constantes de texto usadas en la interfaz de consola.
 * <p>
 * Centraliza los mensajes fijos para evitar literales dispersos en el código.
 * </p>
 */
public final class ConstantesUI {
    /** Mensaje parcial para indicar que un producto se añadió al carrito. */
    public static final String PRODUCTO_ANADIDO = " añadido al carrito. Cantidad: ";

    /** Mensaje parcial para indicar el precio total de un producto agregado. */
    public static final String PRECIO_TOTAL = ". Precio total: $";

    /** Mensaje mostrado cuando el carrito no contiene productos. */
    public static final String CARRITO_VACIO = "El carrito está vacío.";

    /** Mensaje de encabezado para el listado de productos del carrito. */
    public static final String LISTADO_PRODUCTOS = "Productos en el carrito:";

    /** Prefijo de línea para cada producto en el listado. */
    public static final String PRODUCTO_ELEMENTO_INICIO = "- ";

    /** Texto intermedio usado para mostrar la cantidad del producto. */
    public static final String PRODUCTO_CANTIDAD = " (Cantidad: ";

    /** Texto de cierre para la línea de producto en el listado. */
    public static final String PRODUCTO_CIERRE = ")";

    /** Etiqueta usada para mostrar el total acumulado. */
    public static final String TOTAL = "Total: $";

    /** Mensaje mostrado cuando el carrito es vaciado. */
    public static final String CARRITO_VACIADO = "Carrito vaciado.";

    /**
     * Constructor privado para evitar instanciación.
     */
    private ConstantesUI() {
        // Clase de utilidades, no se instancia.
    }
}
