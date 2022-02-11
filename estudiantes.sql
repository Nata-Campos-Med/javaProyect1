
CREATE TABLE IF NOT EXISTS estudiantes (
    id_estudiante INTEGER NOT NULL PRIMARY KEY,
    nombres TEXT NOT NULL,
    apellidos TEXT NOT NULL,
    fecha_nacimiento TEXT NOT NULL,
    correo_institucional TEXT NOT NULL,
    correo_personal TEXT NOT NULL,
    num_celular TEXT NOT NULL,
    num_fijo TEXT NOT NULL,
    programa_academico TEXT NOT NULL);
    
    SELECT * FROM estudiantes;
    
    INSERT INTO estudiantes (id_estudiante, nombres, apellidos, fecha_nacimiento, correo_institucional, correo_personal, num_celular, num_fijo, programa_academico) VALUES (123,"Christopher","Montealegre","2011-07-07","chrism@outlook.com","chris.mc@gmail.com","311000000","5671607","Musica");