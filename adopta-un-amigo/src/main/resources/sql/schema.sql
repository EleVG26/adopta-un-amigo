CREATE TABLE propietario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_nac DATE NOT NULL,
    raza VARCHAR(255) NOT NULL,
    peso INT NOT NULL,
    tiene_chip BOOLEAN NOT NULL,
    sexo VARCHAR(255) NOT NULL,
    propietario_id BIGINT,
    FOREIGN KEY (propietario_id) REFERENCES propietario(id)
);
