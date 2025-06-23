CREATE DATABASE IF NOT EXISTS gestion_almacenes CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE gestion_almacenes;

-- Tabla: cede
CREATE TABLE cede (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    clave VARCHAR(255),
    estado VARCHAR(255),
    municipio VARCHAR(255)
);

-- Tabla: cliente
CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(255),
    telefono VARCHAR(50),
    correo VARCHAR(255)
);

-- Tabla: almacen
CREATE TABLE almacen (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    clave VARCHAR(255),
    fecha_registro DATE,
    precio_venta DOUBLE,
    precio_renta DOUBLE,
    tamano VARCHAR(255),
    estado VARCHAR(50) DEFAULT 'DISPONIBLE',
    cede_id BIGINT,
    cliente_id BIGINT,
    CONSTRAINT fk_almacen_cede FOREIGN KEY (cede_id) REFERENCES cede(id),
    CONSTRAINT fk_almacen_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);


select * from cliente;
select * from cede;
select * from almacen;