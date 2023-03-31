-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS `biblioteca_jdbc`;

-- Seleccionar la base de datos
USE `biblioteca_jdbc`;

-- Crear tabla "autor"
CREATE TABLE `autor` (
  autor_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  nacionalidad VARCHAR(255) NOT NULL
);

-- Crear tabla "biblioteca"
CREATE TABLE biblioteca (
  biblioteca_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL
);

-- Crear tabla "categoria_libro"
CREATE TABLE categoria_libro (
  categoria_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL
);

-- Crear tabla "editorial"
CREATE TABLE editorial (
  editorial_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL
);

-- Crear tabla "libros"
CREATE TABLE libros (
  libro_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  fecha_publicacion DATE NOT NULL,
  isbn VARCHAR(255) NOT NULL,
  categoria_id INT NOT NULL,
  editorial_id INT NOT NULL,
  FOREIGN KEY (categoria_id) REFERENCES categoria_libro (categoria_id),
  FOREIGN KEY (editorial_id) REFERENCES editorial (editorial_id)
);



-- Insertar datos en la tabla "autor"
INSERT INTO `autor` (nombre, nacionalidad)
VALUES ('Gabriel García Márquez', 'Colombiana'),
       ('Mario Vargas Llosa', 'Peruana'),
       ('Jorge Luis Borges', 'Argentina'),
       ('Pablo Neruda', 'Chilena');

-- Insertar datos en la tabla "biblioteca"
INSERT INTO `biblioteca` (nombre, direccion)
VALUES ('Biblioteca Nacional de España', 'Paseo de Recoletos, 20-22, 28071 Madrid'),
       ('Biblioteca Nacional de Colombia', 'Calle 24 #5-60, Bogotá, Colombia'),
       ('Biblioteca Nacional del Perú', 'Av. De la Poesía 160, San Borja 15037, Perú');

-- Insertar datos en la tabla "categoria_libro"
INSERT INTO `categoria_libro` (nombre)
VALUES ('Novela'),
       ('Poesía'),
       ('Ensayo'),
       ('Historia');

-- Insertar datos en la tabla "editorial"
INSERT INTO `editorial` (nombre, direccion)
VALUES ('Alfaguara', 'Calle del Obradoiro, 1, 28223 Pozuelo de Alarcón, Madrid'),
       ('Penguin Random House', '1745 Broadway, New York, NY 10019, Estados Unidos'),
       ('Anagrama', 'Carrer de la Nació, 7, 08002 Barcelona');

-- Insertar datos en la tabla "libros"
INSERT INTO `libros` (titulo, fecha_publicacion, isbn, categoria_id, editorial_id)
VALUES ('Cien años de soledad', '1967-05-30', '978-8439728201', 1, 1),
       ('La ciudad y los perros', '1963-10-26', '978-8420471839', 1, 2),
       ('El aleph', '1949-09-30', '978-8420634242', 2, 3),
       ('Veinte poemas de amor y una canción desesperada', '1924-08-25', '978-0307474742', 2, 2);
