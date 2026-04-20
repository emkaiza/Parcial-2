# Carrito de Compra Java

## Descripción general del proyecto

Este proyecto implementa un carrito de compra sencillo en Java. Incluye clases para representar productos, gestionar categorías de producto, agrupar productos en un carrito y mostrar los detalles de la compra en la consola.

## Autoría y versión

- Autor: Usuario del proyecto
- Versión: 1.0

## Funcionamiento del código

El proyecto está compuesto por las siguientes clases principales:

- `Producto`: representa un producto con nombre, precio, cantidad y categoría.
- `CategoriaProducto`: enumera las categorías válidas para los productos, evitando el uso de cadenas libres.
- `GestorCarrito`: se encarga de mantener la lista de productos del carrito, calcular el total, mostrar el contenido y vaciar el carrito.
- `CarritoCompra`: clase principal que actúa como punto de entrada de la aplicación y delega la gestión del carrito a `GestorCarrito`.
- `ConstantesUI`: define los textos fijos utilizados en la salida por consola para evitar literales dispersos.

### Flujo de ejecución

1. `CarritoCompra.main(...)` crea una instancia de `CarritoCompra`.
2. Se crean algunos objetos `Producto` con categoría, precio y cantidad.
3. Se agregan los productos mediante `agregarProducto(...)`.
4. Se muestra el contenido del carrito y el total con `mostrarProductos()`.
5. Se vacía el carrito con `vaciarCarrito()` y se muestra nuevamente el estado.

## Documentación JavaDoc

Todas las clases del proyecto incluyen JavaDoc para:

- clases
- atributos
- métodos

Esto facilita la comprensión del propósito de cada elemento y permite generar documentación automática si se desea.

## Tests

El proyecto incluye pruebas con JUnit 5 en el archivo `ProductoTest.java`.

### Qué valida la suite de tests

- Creación válida de productos con diferentes categorías.
- Validación de nombre: no puede ser nulo, vacío ni tener una sola letra.
- Validación de precio: debe ser mayor a cero.
- Validación de cantidad: debe ser al menos 1.
- Validación de categoría nula: se convierte a `CategoriaProducto.OTRO`.

### Cómo ejecutar los tests

1. Colocar los JAR de JUnit 5 en la carpeta `lib/`.
2. Ejecutar el script `run-tests.ps1` desde PowerShell:

```powershell
cd d:\Proyecto Java Parcial
.\run-tests.ps1
```

El script compila los archivos fuente y ejecuta los tests automáticamente.
