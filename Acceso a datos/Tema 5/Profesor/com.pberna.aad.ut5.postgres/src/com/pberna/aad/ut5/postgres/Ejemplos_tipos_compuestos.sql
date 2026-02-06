INSERT INTO afiliados 
(nombre, apellidos, domicilio)
VALUES 
('Onorato', 'Maestre Toledo', '(''Calle de Rufino'', 56, 98080)');

INSERT INTO afiliados 
(nombre, apellidos, domicilio)
VALUES ('Onorato', 'Maestre Toledo', ROW('Calle de Rufino', 56, 98080));

select * from afiliados 

SELECT (domicilio).calle 
FROM afiliados 
WHERE (domicilio).codigo_postal=98080

