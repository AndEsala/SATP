# Sistema de Administración de Torneos de Patinaje - SATP
## Descripción
El **Sistema de Administración de Torneos de Patinaje (SATP)** es una aplicación para la gestión de torneos de patinaje en el departamento de Córdoba. La aplicación permite la creación de torneos, la inscripción de patinadores, la asignación automática de baterías y la toma de los tiempos que registren los patinadores en cada una de las competencias.

## Requerimientos
- Java JDK >= 17
- MySQL Community Edition >= 8.0.26

## Plugins de Visual Studio Code
- Java Extension Pack
- Spring Boot Extension Pack

## Configuración
1. Clonar el repositorio.
2. Abrir el proyecto en Visual Studio Code.
3. Configurar la base de datos
    - Crear una base de datos en MySQL con el nombre `patinaje`.
    - Importar en la base de datos creada el archivo `patinaje-ids.sql` que se encuentra en la carpeta raíz.
    - Modificar las credenciales de acceso a la base de datos `username` y `password` en el archivo `application.properties`.
4. Ejecutar el proyecto
    - Para ejecutar el proyecto se debe abrir el plugin de Spring Boot Dashboard y seleccionar el proyecto.
    - Luego, se debe hacer clic en el botón de play que aparece al lado del nombre del proyecto.
    - Finalmente, se debe abrir el navegador y acceder a la dirección `http://localhost:8080`.
  
## Testing
Para ejecutar las pruebas unitarias se deben seguir los siguientes pasos:
1. Instalar Apache Maven.
2. Configurar la variable de entorno `MVN_HOME` con la ruta de instalación de Apache Maven.
3. Agregar la ruta de instalación de Apache Maven al `PATH`.
4. Abrir una terminal y ejecutar el comando `mvn test` en la carpeta raíz del proyecto.

## Autores
- Ayala Fabra Miguel Ángel.
- Esala Muñoz Andrés Felipe.
- Galvis Díaz Jesús David.
- Montiel Díaz Santiago.
- Olea Sarmiento José Domingo.
- Ortega Hoyos Andrés David.