
# Proyecto Final: ORM Data Manager (Sakila DB)

**Universidad Autónoma de Santo Domingo (UASD)**
* **Facultad:** Ciencias
* **Escuela:** Informática
* **Materia:** INF514 -Lenguaje de  Programación II (Java)
* **Estudiante:** Aaliyah Maria Francisco Demora.
* **Matricula**: 100712832.

# Descripcion del proyecto:

Este proyecto implementa un sistema basado en la base de datos Sakila, utilizando ORM (Object-Relational Mapping) para gestionar consultas, inserciones, actualizaciones y eliminaciones de forma sencilla y estructurada.

# Objetivo del proyecto: 

El objetivo es demostrar dominio del modelo relacional, manejo de entidades y relaciones y creación de consultas eficientes.  

* Conectar y mapear la base de datos Sakila utilizando un ORM.
* Crear modelos, entidades y sus relaciones.
* Realizar operaciones CRUD completas.
* Implementar consultas requeridas y algunas opciones adicionales.
* Organizar el código de forma clara, modular y sin errores.

# Estructura del Proyecto

El proyecto se organiza de forma modular y clara siguiendo la siguiente estructura de directorios, específica para el proyecto Java:

* **`/src/main/java/.../db`**: Contiene las clases de conexión a la base de datos  y las **entidades** o **modelos** mapeados con el ORM.

* **`/src/main/java/.../manager`**: Aloja la **lógica de negocio principal**, incluyendo las operaciones CRUD (Crear, Leer, Actualizar, Borrar) y otras consultas específicas.

* **`App.java`**: La clase principal que sirve como punto de entrada para la **ejecución de pruebas y demostraciones** del ORM y CRUD.

* **`pom.xml`**: El archivo de configuración principal de **Maven**, que gestiona todas las dependencias del proyecto (incluyendo el driver JDBC).

* **`README.md`**: El archivo de documentación principal del proyecto.


# Tecnologías Utilizadas

**Node.js**: Entorno de ejecución de JavaScript del lado del servidor.

**Sequelize ORM**: Potente Object-Relational Mapper (ORM) para Node.js, utilizado para facilitar la interacción con la base de datos de manera orientada a objetos.

**MySQL / Sakila**: El sistema de gestión de base de datos relacional (MySQL) junto con el schema de ejemplo Sakila, utilizado como fuente de datos para la aplicación.

**ESModules**: Estándar de módulos de JavaScript moderno, utilizado para estructurar el código de manera modular y eficiente.

# Funcionalidades Principales:

-Mapeo de todas las tablas y sus relaciones (1:N, N:N).
-CRUD de entidades principales.
-Consultas personalizadas.
-Código organizado y legible.

# Cómo Ejecutar el Proyecto:

**Prerrequisitos**: 
-Java JDK 17+
-MySQL Server con base de datos sakila.
-Driver JDBC: mysql-connector-j.
-IDE (IntelliJ, VS Code, etc.).

# Configuración DB:

El proyecto usa Borrado Lógico. Asegúrate de que el campo active exista en las tablas relevantes.

# Ejecución: 
Clonar el repositorio.

Abrir en el IDE.

Asegurar que el driver JDBC esté en el classpath.

Configurar la conexión a la base de datos (host, usuario, contraseña).

Ejecutar App.java.
