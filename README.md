# Conexión con una base de datos MariaDB con Java usando JDBC y JPA


# Introducción

En el siguiente repositorio vamos a mostrar una conexión simple con la base de datos usando las dos formas distintas de JDBC, una normal y la otra conexión Pool. Despues implementaremos una APIREST usando JPA. Para ello vamos a crear un proyecto usando el framework [Spring Boot](https://start.spring.io/) para Java.

JPA y JDBC son dos tecnologías diferentes que se utilizan para acceder a bases de datos desde una aplicación Java.

JDBC (Java Database Connectivity) es una API de Java que proporciona un conjunto de clases e interfaces para interactuar con una base de datos relacional. JDBC se utiliza para escribir consultas SQL, ejecutarlas y obtener resultados de la base de datos. Con JDBC, el programador tiene un control completo sobre la interacción con la base de datos y debe escribir todas las consultas SQL manualmente.

Por otro lado, JPA (Java Persistence API) es una especificación de Java que proporciona un conjunto de clases e interfaces para trabajar con bases de datos relacionales de manera más fácil y eficiente. JPA es una capa de abstracción que oculta los detalles de la base de datos subyacente y permite al programador interactuar con los objetos Java en lugar de con la base de datos. JPA utiliza un ORM (Object-Relational Mapping) para mapear los objetos Java a tablas en la base de datos y viceversa, lo que significa que el programador no tiene que escribir consultas SQL manualmente.

En resumen, la principal diferencia entre JDBC y JPA es que JDBC es una API para interactuar con la base de datos directamente, mientras que JPA es una capa de abstracción que utiliza un ORM para mapear los objetos Java a la base de datos. JPA es más fácil de usar y más eficiente que JDBC, pero JDBC ofrece un mayor control sobre la interacción con la base de datos.

Por ello puedes encontrar una versión de nuestro trabajo JDBC en la rama [pool](https://github.com/Adrianlm17/Mate_JDBC/tree/pool), otra versión del trabajo usando JPA en la rama [JPA](https://github.com/Adrianlm17/Mate_JDBC/tree/JPA) y por último, en la rama [principal](https://github.com/Adrianlm17/Mate_JDBC/tree/main) utilizamos todos esos desarrollos previos para implementar una APIREST apoyandonos en Spring.

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

## JDBC

## JPA

## API JPA

Para implementar todo el conocimiento adquirido con el contenido de la unidad teniendo en cuenta lo aprendido tanto de JDBC como de JPA, hemos creado una API que realiza un CRUD sobre nuestra base de datos.

En el siguiente postman después de haber iniciado la aplicación ejecutando el la clase principal `LibreriasAplication.java`, puedes `LEER todos LOS LIBROS`, `AÑADIR`, `BUSCAR`, `ELIMINAR`.


[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.gw.postman.com/run-collection/24367189-304016c1-1de3-468d-b641-a6a15a347e51?action=collection%2Ffork&collection-url=entityId%3D24367189-304016c1-1de3-468d-b641-a6a15a347e51%26entityType%3Dcollection%26workspaceId%3D6054a904-5fac-4f5b-937f-3c38ba681f2c)

# Mejoras

Las mejoras que están pendientes de implementarse son:
- Estudio de una base de datos más completa y funcional
- Queries más prácticas y estratégicas de la base de datos




