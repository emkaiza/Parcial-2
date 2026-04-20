# TESTING - Análisis de caja negra para `Producto`

## Objetivo
Realizar un análisis de caja negra sobre los atributos públicos de la clase `Producto` para validar criterios de aceptación y generar casos de prueba.

## Criterios de aceptación

1. Nombre
   - No puede ser vacío.
   - Debe tener una longitud mínima de 2 caracteres.
   - Debe ser un texto válido, sin ser `null`.

2. Categoría
   - Debe pertenecer a las categorías definidas en `CategoriaProducto`.
   - No se permite una categoría libre o inválida.
   - Si se usa `null`, se debe tratar como `CategoriaProducto.OTRO`.

3. Precio
   - No puede ser negativo.
   - Debe ser mayor que cero.

4. Cantidad
   - No puede ser negativa.
   - Debe ser un entero mayor o igual a 1.

## Análisis de parámetros

| Atributo   | Tipo esperado | Restricciones | Valores válidos típicos | Valores inválidos típicos |
|------------|---------------|---------------|-------------------------|---------------------------|
| nombre     | `String`      | No nulo, no vacío, longitud mínima 2 | "Leche", "Pan", "Huevos" | `null`, `""`, `"A"` |
| categoria  | `CategoriaProducto` | Debe ser una constante válida | `CategoriaProducto.ALIMENTACION`, `HIGIENE`, `ROPA` | `null`* (tratado como OTRO), categoría libre no válida |
| precio     | `double`      | > 0 | `1.0`, `2.5`, `0.01` | `0.0`, `-1.0`, `-0.01` |
| cantidad   | `int`         | >= 1 | `1`, `2`, `10` | `0`, `-1`, `-5` |

> Nota: en la implementación actual, `CategoriaProducto.fromString` permite normalizar texto a una categoría válida, pero el constructor `Producto` usa el enum directamente.

## Casos válidos

| Caso | Nombre | Categoría | Precio | Cantidad | Resultado esperado |
|------|--------|-----------|--------|----------|--------------------|
| V1   | "Leche" | `CategoriaProducto.ALIMENTACION` | 2.5 | 1 | Producto creado correctamente |
| V2   | "Jabón" | `CategoriaProducto.HIGIENE` | 1.0 | 2 | Producto creado correctamente |
| V3   | "Camiseta" | `CategoriaProducto.ROPA` | 10.0 | 3 | Producto creado correctamente |
| V4   | "Auriculares" | `CategoriaProducto.ELECTRONICA` | 25.5 | 1 | Producto creado correctamente |
| V5   | "Salsa" | `CategoriaProducto.OTRO` | 0.5 | 5 | Producto creado correctamente |

## Casos no válidos

| Caso | Nombre | Categoría | Precio | Cantidad | Resultado esperado |
|------|--------|-----------|--------|----------|--------------------|
| N1   | `null` | `CategoriaProducto.ALIMENTACION` | 2.5 | 1 | Error o rechazo de entrada | 
| N2   | "" | `CategoriaProducto.HIGIENE` | 1.0 | 1 | Error o rechazo de entrada |
| N3   | "A" | `CategoriaProducto.ROPA` | 5.0 | 1 | Error o rechazo de entrada |
| N4   | "Leche" | `CategoriaProducto.ALIMENTACION` | 0.0 | 1 | Error o rechazo de entrada |
| N5   | "Pan" | `CategoriaProducto.ALIMENTACION` | -1.0 | 1 | Error o rechazo de entrada |
| N6   | "Huevos" | `CategoriaProducto.ALIMENTACION` | 1.0 | 0 | Error o rechazo de entrada |
| N7   | "Queso" | `CategoriaProducto.ALIMENTACION` | 1.0 | -2 | Error o rechazo de entrada |
| N8   | "Lechuga" | `null` | 1.0 | 1 | Dependiendo de la implementación, debería mapear a `OTRO` o rechazarse |

## Observaciones

- Si se decide reforzar las validaciones, la clase `Producto` puede incluir comprobaciones de constructor o setters para garantizar los criterios de aceptación.
- El análisis se basa en el comportamiento esperado de un dominio de carrito de compras estándar.
- Si se usan patrones adicionales, como `Optional` o validadores específicos, se recomienda documentar los resultados esperados para `null` y valores límite.
