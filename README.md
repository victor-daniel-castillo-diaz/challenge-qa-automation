## Prerequisitos
+ Java Development Kit 17.0.2
+ Maven 3.8.5
+ PowerShell versión 5.1 o superior (en caso de plataforma Windows)

## Instalación de Allure

Para Windows, ejecute el script `install-allure.bat`, que se encuentra en la carpeta `/resources`
Para Mac, ejecute el script `install-allure.sh`, que se encuentra en la carpeta `/resources` 

## Instalación de Chrome driver

Para obtener la versión de Chrome, ir a la opción ⋮ > ayuda > Acerca de Google Chrome y descargar la versión correcta del  driver de Chrome para su plataforma https://chromedriver.chromium.org/downloads 

Extraer el ejecutable `chromedriver.exe` y copiarlo en la carpeta `/resources` del proyecto

## Instalación de Gecko driver

Descargar la versión correcta del Gecko driver para su plataforma https://github.com/mozilla/geckodriver/releases/tag/v0.33.0 

Extraer el ejecutable `geckodriver.exe` y copiarlo en la carpeta `/resources` del proyecto

## Reportes

Se generan los reportes JUnit `com.saucedemo.TestRunner.txt` y `TEST-com.saucedemo.TestRunner.xml` en la carpeta `./target/surefire-reports`
Se generan el reporte de allure en la carpeta `/allure-results`

En el reporte de allure, se configuro la toma de evidencias (screen shots) antes y despues de la ejecución de cada paso, no se encontro como configurar en la herramienta de reportes que se incluya la evidencia (screen shot) al producirse un error 

## Para ejecutar las pruebas

Para Windows, ejecute el script `run.bat`, que se encuentra en la carpeta raiz del proyecto, por defecto está configurado para ejecutar en Chrome, si desea ejecutar en Firefox, editar el archivo `run.bat` en la línea 2, reemplazar `Chrome` por `Firefox`. 

Para Mac, debe definirse el valor `Chrome` o `Firefox` en la propiedad browser del archivo `config.properties` que se encuentra en la ruta `src\test\java\com\saucedemo` para definir en que navegador ejecutar las pruebas 

Luego, ejecute los siguientes comandos en una consola 

eliminar reporte anterior
`rmdir /s /q allure-results`

ejecutar las prueba
`clean test -Dcucumber.filter.tags="@shoppingCart or @login or @departments-mercado-libre"` 

abrie el reporte con los resultados de las pruebas
`allure serve`





