# Conexión con una base de datos MariaDB con Java usando JDBC y JPA


# Introducción

En el siguiente repositorio vamos a mostrar una conexión simple con la base de datos usando las dos formas distintas de JDBC, una normal y la otra conexión Pool. Despues implementaremos una APIREST usando JPA.

JPA y JDBC son dos tecnologías diferentes que se utilizan para acceder a bases de datos desde una aplicación Java.

JDBC (Java Database Connectivity) es una API de Java que proporciona un conjunto de clases e interfaces para interactuar con una base de datos relacional. JDBC se utiliza para escribir consultas SQL, ejecutarlas y obtener resultados de la base de datos. Con JDBC, el programador tiene un control completo sobre la interacción con la base de datos y debe escribir todas las consultas SQL manualmente.

Por otro lado, JPA (Java Persistence API) es una especificación de Java que proporciona un conjunto de clases e interfaces para trabajar con bases de datos relacionales de manera más fácil y eficiente. JPA es una capa de abstracción que oculta los detalles de la base de datos subyacente y permite al programador interactuar con los objetos Java en lugar de con la base de datos. JPA utiliza un ORM (Object-Relational Mapping) para mapear los objetos Java a tablas en la base de datos y viceversa, lo que significa que el programador no tiene que escribir consultas SQL manualmente.

En resumen, la principal diferencia entre JDBC y JPA es que JDBC es una API para interactuar con la base de datos directamente, mientras que JPA es una capa de abstracción que utiliza un ORM para mapear los objetos Java a la base de datos. JPA es más fácil de usar y más eficiente que JDBC, pero JDBC ofrece un mayor control sobre la interacción con la base de datos.

# Índice

- [Instalación](#instalación)
- [Base de datos](#base-de-datos)
- [Uso](#uso)
- [Requisitos](#requisitos)
- [Mejoras](#mejoras)

# Instalación

1. Descargar e instalar Maven en el sistema. Puede hacerse siguiendo las instrucciones en el sitio web oficial de Apache Maven.

2. Clonar el repositorio remoto que contiene el proyecto Maven utilizando una herramienta de control de versiones como Git. Para ello, se debe ejecutar el siguiente comando en la línea de comandos:
```
git clone url_del_repositorio
```
2. Navegar al directorio raíz del proyecto Maven clonado utilizando la línea de comandos.

3. Ejecutar el siguiente comando Maven para construir el proyecto:
```
mvn clean install
```
4. Este comando compila el código fuente del proyecto, empaqueta el proyecto en un archivo .jar y lo instala en el repositorio local de Maven.

5. Si el proyecto depende de otras bibliotecas de terceros, Maven descarga automáticamente las bibliotecas necesarias del repositorio remoto y las agrega al proyecto.

# Base de datos

# Uso

# Requisitos

# Mejoras




