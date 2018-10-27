CREATE TABLE profesores(
	profesor_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    profesor_nombre VARCHAR(45) NOT NULL,
    profesor_apellido VARCHAR(45) NOT NULL,
	profesor_direccion VARCHAR(45),
    profesor_numero INT(4),
    profesor_celular INT(45),
    profesor_fijo INT(45),
	profesor_cuil INT(11),
    profesor_fecha_nacimiento DATE
);
