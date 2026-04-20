/**
 * Enumera las categorías disponibles para un producto.
 * <p>
 * Evita el uso de textos abiertos y proporciona etiquetas legibles para la consola.
 * </p>
 */
public enum CategoriaProducto {
    /** Categoría de alimentación. */
    ALIMENTACION("Alimentación"),

    /** Categoría de higiene. */
    HIGIENE("Higiene"),

    /** Categoría de electrónica. */
    ELECTRONICA("Electrónica"),

    /** Categoría de ropa. */
    ROPA("Ropa"),

    /** Categoría genérica para productos sin otra categoría asignada. */
    OTRO("Otro");

    /** Etiqueta legible asociada a la categoría. */
    private final String etiqueta;

    /**
     * Constructor de categoría con etiqueta visible.
     *
     * @param etiqueta etiqueta de la categoría
     */
    CategoriaProducto(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Obtiene la etiqueta legible de la categoría.
     *
     * @return etiqueta de la categoría
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Convierte un texto en la categoría correspondiente.
     * <p>
     * Si el texto es nulo o no coincide con ninguna categoría conocida, devuelve {@link #OTRO}.
     * </p>
     *
     * @param texto texto de categoría
     * @return categoría correspondiente o {@link #OTRO}
     */
    public static CategoriaProducto fromString(String texto) {
        if (texto == null) {
            return OTRO;
        }
        switch (texto.trim().toLowerCase()) {
            case "alimentacion":
            case "alimentación":
                return ALIMENTACION;
            case "higiene":
                return HIGIENE;
            case "electronica":
            case "electrónica":
                return ELECTRONICA;
            case "ropa":
                return ROPA;
            default:
                return OTRO;
        }
    }

    /**
     * Devuelve la etiqueta legible de la categoría.
     *
     * @return etiqueta de la categoría
     */
    @Override
    public String toString() {
        return etiqueta;
    }
}
