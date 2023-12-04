-- Crear la base de datos
CREATE DATABASE RedSocialDB;

-- Usar la base de datos
USE RedSocialDB;

-- Crear la tabla Ciudad
CREATE TABLE Ciudad (
    ID_Ciudad INT PRIMARY KEY,
    Nombre VARCHAR(50)
);

-- Crear la tabla Personas
CREATE TABLE Personas (
    ID_Persona INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Edad INT,
    CiudadID INT,
    FOREIGN KEY (CiudadID) REFERENCES Ciudad(ID_Ciudad)
);

-- Crear la tabla Restaurantes
CREATE TABLE Restaurantes (
    ID_Restaurante INT PRIMARY KEY,
    Nombre VARCHAR(50),
    CiudadID INT,
    FOREIGN KEY (CiudadID) REFERENCES Ciudad(ID_Ciudad)
);

-- Insertar datos en la tabla Ciudad
INSERT INTO Ciudad VALUES (1, 'Buenos Aires');
INSERT INTO Ciudad VALUES (2, 'Caracas');

-- Insertar datos en la tabla Personas
INSERT INTO Personas VALUES (101, 'Miguel', 29, 1);
INSERT INTO Personas VALUES (102, 'Carlos', 35, 2);

-- Insertar datos en la tabla Restaurantes
INSERT INTO Restaurantes VALUES (201, 'Ato Grill', 1);
INSERT INTO Restaurantes VALUES (202, 'Osaka', 2);

-- Consulta con JOIN (Obtener personas y su ciudad)
SELECT Personas.Nombre AS Persona, Ciudad.Nombre AS Ciudad
FROM Personas
JOIN Ciudad ON Personas.CiudadID = Ciudad.ID_Ciudad;

-- Consulta con INNER JOIN (Obtener restaurantes y su ciudad)
SELECT Restaurantes.Nombre AS Restaurante, Ciudad.Nombre AS Ciudad
FROM Restaurantes
INNER JOIN Ciudad ON Restaurantes.CiudadID = Ciudad.ID_Ciudad;

-- Consulta con LEFT JOIN (Obtener todas las personas y los restaurantes de su ciudad, si tienen)
SELECT Personas.Nombre AS Persona, Restaurantes.Nombre AS Restaurante
FROM Personas
LEFT JOIN Restaurantes ON Personas.CiudadID = Restaurantes.CiudadID;

-- Consulta con RIGHT JOIN (Obtener todas las personas con su ciudad y los restaurantes)
SELECT Personas.Nombre AS Persona, Ciudad.Nombre AS Ciudad, Restaurantes.Nombre AS Restaurante
FROM Personas
RIGHT JOIN Restaurantes ON Personas.CiudadID = Restaurantes.CiudadID
JOIN Ciudad ON Personas.CiudadID = Ciudad.ID_Ciudad;

-- Eliminar las tablas
DROP TABLE Personas;
DROP TABLE Restaurantes;
DROP TABLE Ciudad;

-- Eliminar la base de datos
DROP DATABASE RedSocialDB;