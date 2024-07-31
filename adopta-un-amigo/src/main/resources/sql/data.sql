INSERT INTO propietario (nombre) VALUES ('Carlos Ramirez');
INSERT INTO propietario (nombre) VALUES ('Ana Lopez');

INSERT INTO mascota (nombre, fecha_nac, raza, peso, tiene_chip, url_foto, propietario_id) VALUES
('Fido', '2020-01-01', 'Labrador', 30, true, '/images/fido.jpg', 1),
('Luna', '2019-05-05', 'Beagle', 20, false, '/images/luna.jpg', 1),
('Max', '2018-08-08', 'Bulldog', 25, true, '/images/max.jpg', 1),
('Bella', '2021-03-03', 'Poodle', 10, false, '/images/bella.jpg', 2),
('Rocky', '2017-07-07', 'Pastor Alemán', 35, true, '/images/rocky.jpg', NULL),
('Tank', '2021-12-12', 'Newfoundland', 70, true, '/images/tank.jpg', NULL);
