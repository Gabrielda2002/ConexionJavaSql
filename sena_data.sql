-- crud - create(insertar) - read(listar) - update(actuazliar) - delete(eliminar)
SELECT * FROM student;
-- create student
INSERT INTO student(firts_name,last_name,phone,email) VALUES("Gabriel","Duarte", "3025965432", "cam@gmail.com");

UPDATE student SET firts_name="Gabriel C", last_name="Duarte Arias", phone="1234", email="gacbadas@gmail.com" WHERE idStudent =1;
-- eliminar una columna de una tabla
ALTER TABLE student DROP COLUMN Studentcol;
-- Eliminar registro
DELETE FROM student WHERE idStudent=5;

ALTER TABLE student AUTO_INCREMENT = 1;
