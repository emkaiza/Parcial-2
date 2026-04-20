/**
 * Representa un producto disponible para agregar al carrito de compra.
 * <p>
 * Cada producto tiene un nombre, precio unitario, cantidad y una categoría
 * para evitar el uso de textos libres en la clasificación.
 * </p>
 */
class Producto {
    /** Nombre del producto. No puede estar vacío ni ser nulo. */
    private String nombre;

    /** Precio unitario del producto. Debe ser mayor que cero. */
    private double precio;

    /** Cantidad del producto en el carrito. Debe ser al menos 1. */
    private int cantidad;

    /** Categoría asignada al producto mediante {@link CategoriaProducto}. */
    private CategoriaProducto categoria;

    /**
     * Crea un producto con categoría explícita.
     *
     * @param nombre nombre del producto
     * @param precio precio unitario del producto
     * @param cantidad cantidad del producto
     * @param categoria categoría del producto; si es {@code null}, se asigna {@link CategoriaProducto#OTRO}
     * @throws IllegalArgumentException si el nombre, precio o cantidad no cumplen las reglas de validación
     */
    public Producto(String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        setNombre(nombre);
        setPrecio(precio);
        setCantidad(cantidad);
        setCategoria(categoria);
    }

    /**
     * Crea un producto con categoría predeterminada {@link CategoriaProducto#OTRO}.
     *
     * @param nombre nombre del producto
     * @param precio precio unitario del producto
     * @param cantidad cantidad del producto
     */
    public Producto(String nombre, double precio, int cantidad) {
        this(nombre, precio, cantidad, CategoriaProducto.OTRO);
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre nombre del producto; no puede ser nulo o menor de 2 caracteres
     * @throws IllegalArgumentException si el nombre es nulo o demasiado corto
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().length() < 2) {
            throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres y no puede ser vacío.");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Obtiene el precio unitario del producto.
     *
     * @return precio unitario
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio unitario del producto.
     *
     * @param precio precio del producto; debe ser mayor que cero
     * @throws IllegalArgumentException si el precio es cero o negativo
     */
    public void setPrecio(double precio) {
        if (precio <= 0.0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad de unidades del producto.
     *
     * @return cantidad de unidades
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades del producto.
     *
     * @param cantidad cantidad de unidades; debe ser mayor o igual a 1
     * @throws IllegalArgumentException si la cantidad es menor que 1
     */
    public void setCantidad(int cantidad) {
        if (cantidad < 1) {
            throw new IllegalArgumentException("La cantidad debe ser al menos 1.");
        }
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la categoría asociada al producto.
     *
     * @return categoría del producto
     */
    public CategoriaProducto getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param categoria categoría del producto; si es {@code null}, se asigna {@link CategoriaProducto#OTRO}
     */
    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria == null ? CategoriaProducto.OTRO : categoria;
    }
}