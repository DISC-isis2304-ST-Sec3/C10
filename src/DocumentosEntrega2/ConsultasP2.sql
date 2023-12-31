//1 MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN EN EL ÚLTIMO AÑO CORRIDO.
SELECT rh.HABITACION_NUMERO,
       SUM(c.TOTAL) AS RECOLECTADO
FROM consumo c
JOIN reservanhabitaciones rh ON c.RESERVA_ID = rh.RESERVA_ID 
WHERE c.FECHA BETWEEN '11/7/2022' AND '11/7/2023'
GROUP BY rh.HABITACION_NUMERO
ORDER BY rh.HABITACION_NUMERO, SUM(c.TOTAL)  DESC;

//2 servicios mas populares 
SELECT SERVICIO_ID, COUNT(*) AS CANT_CONSUMOS
FROM CONSUMO 
WHERE FECHA BETWEEN '08/12/02' AND '08/12/03'
GROUP BY SERVICIO_ID
ORDER BY CANT_CONSUMOS DESC;
//3 indice de ocupacion de la habitacion 
SELECT Reservanhabitaciones.habitacion_numero,((COUNT(FECHASALIDA-FECHAENTRADA))/365)
FROM RESERVA
INNER JOIN RESERVANHABITACIONES ON (RESERVA.ID = RESERVANHABITACIONES.RESERVA_ID)
WHERE reserva.fechaentrada BETWEEN '08/12/02' AND '08/12/03'
GROUP BY Reservanhabitaciones.habitacion_numero;
//4 MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTERÍSTICA
select* from consumo;
SELECT SERVICIO_ID 
FROM CONSUMO 
WHERE (FECHA BETWEEN '08/12/02' AND '08/12/13') AND (PRECIOUNITARIO = '171392');
select * from cliente;
//5 MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO.
SELECT ID, DESCRIPCION, TOTAL, CLIENTE_ID, SERVICIO_ID
FROM CONSUMO 
WHERE (CLIENTE_ID = 1) AND FECHA BETWEEN '08/12/02' AND '08/12/13';
// 6 ANALIZAR LA OPERACIÓN DE HOTELANDES
//1
SELECT FECHAENTRADA, SUM(NUMEROPERSONAS) AS TOTAL_PERSONAS
FROM reserva
GROUP BY FECHAENTRADA
ORDER BY TOTAL_PERSONAS DESC;
//2 
SELECT FECHA, SUM(TOTAL) AS TOTAL_INGRESOS
FROM consumo
GROUP BY FECHA
ORDER BY TOTAL_INGRESOS DESC;
//3
SELECT FECHAENTRADA, SUM(NUMEROPERSONAS) AS TOTAL_PERSONAS
FROM reserva
GROUP BY FECHAENTRADA
ORDER BY TOTAL_PERSONAS Asc;
//7 ENCONTRAR LOS BUENOS CLIENTES
SELECT c.CLIENTE_ID,  SUM(DISTINCT r.FECHASALIDA - r.FECHAENTRADA) AS TOTAL_DIAS,SUM(c.TOTAL) AS TOTAL_CONSUMO
FROM reserva r
JOIN consumo c ON r.ID = c.RESERVA_ID
WHERE r.FECHAENTRADA BETWEEN '11/7/2022' AND '11/7/2023' 
GROUP BY c.CLIENTE_ID
HAVING SUM(DISTINCT r.FECHASALIDA - r.FECHAENTRADA)>=15 AND SUM(c.TOTAL)> 150000
ORDER BY TOTAL_CONSUMO DESC, TOTAL_DIAS DESC;
//8 ENCONTRAR LOS SERVICIOS QUE NO TIENEN MUCHA DEMANDA
SELECT SERVICIO_ID, COUNT(*) AS NUMERO_VECES_SOLICITADO
FROM consumo
WHERE FECHA BETWEEN '11/7/2022' AND '11/7/2023' 
GROUP BY SERVICIO_ID
HAVING COUNT(*) < 3 * 52; 

//9 CONSULTAR CONSUMO EN HOTELANDES

SELECT c.ID AS CLIENTE_ID,c.DIRECCION, c.TELEFONO, COUNT(*) AS NUMERO_CONSUMOS
FROM cliente c
LEFT JOIN consumo co ON c.ID = co.CLIENTE_ID
WHERE co.SERVICIO_ID = 4 
AND co.FECHA  BETWEEN '10/10/2022' AND '10/10/2023' 
GROUP BY c.ID, c.DIRECCION, c.TELEFONO
ORDER BY COUNT(*) DESC;
//10 CONSULTAR CONSUMO EN HOTELANDES – RFC9-V2
SELECT c.ID AS CLIENTE_ID, c.DIRECCION, c.TELEFONO, COUNT(*) 
FROM cliente c
LEFT JOIN consumo co ON c.ID = co.CLIENTE_ID
AND co.SERVICIO_ID = 5
AND co.FECHA  BETWEEN '10/10/2022' AND '10/10/2023' 
WHERE co.CLIENTE_ID IS NULL
GROUP BY c.ID, c.DIRECCION, c.TELEFONO
ORDER BY COUNT(*) ; 
// 12 CONSULTAR LOS CLIENTES EXCELENTES
SELECT cliente_id
FROM ((
    SELECT r.cliente_id
    FROM reserva r
    GROUP BY r.cliente_id, EXTRACT(YEAR FROM r.fechaentrada)
    HAVING COUNT(DISTINCT EXTRACT(YEAR FROM r.fechaentrada)) > 4
)
    UNION
    -- Clientes que han consumido servicios costosos
    SELECT c.ID AS cliente_id
    FROM cliente c
    WHERE EXISTS (
        SELECT 1
        FROM consumo co
        WHERE co.CLIENTE_ID = c.ID
        AND co.PRECIOUNITARIO > 300000
    )
    UNION
    -- Clientes que han consumido servicios de SPA con duración mayor a 4 horas
    SELECT r.cliente_id
    FROM reserva r
    JOIN consumo c ON c.RESERVA_ID = r.ID
    JOIN spa s ON c.SERVICIO_ID = s.ID
    WHERE s.DURACION_MIN > (4 * 60)
);