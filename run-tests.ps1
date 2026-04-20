# Ejecuta los tests JUnit 5 para el proyecto
$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $projectRoot

# Compilar fuentes y tests
Write-Host "Compilando clases..."
javac -cp ".;lib/*" Producto.java CategoriaProducto.java ProductoTest.java
if ($LASTEXITCODE -ne 0) {
    Write-Error "Error en la compilación."
    exit $LASTEXITCODE
}

# Ejecutar tests
Write-Host "Ejecutando tests..."
java -cp ".;lib/junit-platform-console-standalone-1.10.0.jar;lib/junit-jupiter-api-5.10.0.jar;lib/junit-jupiter-params-5.10.0.jar;lib/junit-platform-commons-1.10.0.jar;lib/opentest4j-1.3.0.jar;lib/apiguardian-api-1.1.0.jar" org.junit.platform.console.ConsoleLauncher --scan-classpath
if ($LASTEXITCODE -ne 0) {
    Write-Error "Algunos tests fallaron o no se pudo ejecutar el runner."
    exit $LASTEXITCODE
}

Write-Host "Tests ejecutados correctamente."