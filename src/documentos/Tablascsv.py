import csv
import datetime
import random
import numpy

def generarReservas(nombre_archivo, num_filas):
    ## Genera Además datos extra para la tabla de visitan
   
    camposCliente=["ID","DIRECCION","TELEFONO","PLANDECONSUMOID"]
    camposCONSUMO= ["ID","FECHA","DESCRIPCION","PRECIOUNITARIO","CANTIDAD","TOTAL","SERVICIO_ID","RESERVA_ID","CLIENTE_ID"]
    camposhabitacion = ["NUMERO","CAPACIDADMAX","DOTACION","ESTADO","TARIFA","PLANDECONSUMOID","TIPO_HABITACION_ID"]
    camposplandeconsumo = ["ID","DESCUENTO","DESCRIPCION","NOMBRE"]
    camposreserva = ["ID","FECHAENTRADA","FECHASALIDA","NUMEROPERSONAS","ESTADO","CLIENTE_ID"]
    camposreservanhabitaciones = ["HABITACION_NUMERO","RESERVA_ID"]
    camposreservaspa = ["ID","HORARIO","CLIENTE_ID","HABITACION_NUMERO"]
    camposservicio = ["ID", "NOMBRE","CAPACIDAD","APERTURA","CIERRE"]
    camposspa = ["ID","DURACION_MIN","TIPO","COSTO"]
    campostipohabitacion = ["ID","NOMBRE","DESCRIPCION"]
    campostipousuario = ["ID","NOMBRE","CANTIDAD"]
    camposusanservicios = ["CLIENTE_ID","SERVICIO_ID"]
    camposusanspa = ["SPA_ID","RESERVASPA_ID"] 
    camposusuario = ["ID","NOMBRE_2","APELLIDO","TIPO_USUARIO_ID"]
    camposrestaurante = ["ID","MENU","INGREDIENTES","MODALIDAD"]
    camposbar = ["ID","INGREDIENTES","TIPO_PLATO","DISPONIBLE"]
    # Generar datos aleatorios para el archivo
    datoscliente = []
    datosconsumo= []
    datoshabitacion= []
    datosplandeconsumo= []
    datosreserva= []
    datosreserva= []
    datosreservahabitaciones= []
    datosreservaspa= []
    datosservicio= []
    datosspa= []
    datostipohabitacion= []
    datostipousuario= []
    datosusanservicios= []
    datosusanspa= []
    datosusuario= []
    datosrestaurante= []
    datosbar= []
    info={}
    for i in range(1, num_filas + 1):
        id= i 
        cliente_id = random.randint(1,75000)
        plandeconsumoid = random.randint(1,500)
        direccion = "Calle" + str(random.randint(1,500)) + "Carrera" + str(random.randint(1,500))
        desripcion = "compra"
        preciounitario = random.randint(25000,250000)
        cantidad = random.randint(1,20)
        total = preciounitario*cantidad
        servicio_id = random.randint(1,100)
        reserva_id = random.randint(1,450000)
        telefono = random.randint(3000000000,3999999999)
        dotacion = "Habitacion de " + str(random.randint(1,4)) + "camas"
        estado = random.choice(["Disponible","Fuera de servicio"])
        tipo_habitacion_id = random.randint(1,20)
        descuento = random.randint(15,30)
        nombredescuento = random.choice(["Platino","Oro","Plata","Bronze"])
        descripcion = "descuento por afiliacion club"
        año,mes,dia = generar_fecha_aleatoria()
        
        fechaentrada = str(mes)+"/"+str(dia)+"/"+str(año)
        
        
        fechasalida = str(random.randint(mes,12))+"/"+str(random.randint(dia,28))+"/"+str(año)
            
                
        estadoreserva = random.choice(["paga","pendiente"])
        numero_habitacion = random.randint(1,1000)
        nombre_servicio = "Serviciohotelx"
        tipospa = random.choice(["Masajetotal","masajepies","masajeespalda","masajefacial","limpiezacara","bañolodo","bañoespuma"])
        nombre_hab = random.choice(["Suite","suiteP","individual","doble","familiar","semisuite"])
        nombretipousuario = random.choice(["Cliente","Empleado","gerente"])
        SPAid = random.randint(1,30)
        fechareservaspa = str(mes)+"/"+str(dia)+"/"+str(año)
        nombreususario = random.choice(["Samuel","Juan","Juanita","Martin", "Isabella", "Laura", "Diego", "Armando", "Lionel", "Jesus", "Jose"])
        apellidoUsuario = random.choice(["Ramirez","Gonzales","hernandes","hernandez","maru", "tobon","lopez","amaya","sarmiento","angulo", "murcia","alonso"])
        tipousuarioid = random.randint(1,3)
        menurestaurante = random.choice(["D","A","C"])
        ingredientes = "esta hecho de cosas"
        modalidad = random.choice(["H,R","R","H"])
        tipoplato = random.choice(["comida","bebida","coctel","postre","entrada"])
        disponible = random.choice(["B,R,H","R,B","B,H","B"])
        reservaspaid = random.randint(1,200000)









        
        
        año,mes,dia = generar_fecha_aleatoria()
        fecha= str(mes)+"/"+str(dia)+"/"+str(año)
        duracion= random.randint(1,99)
        datosusuario.append([id,nombreususario,apellidoUsuario,tipousuarioid])
        datoscliente.append([id,direccion,telefono,plandeconsumoid])
        datosservicio.append([id,nombre_servicio,cantidad,fecha,fecha])
        if id >= 1 and id <= 30:
            datosspa.append([id,duracion,tipospa,preciounitario])
        elif id > 30 and id <= 60:
            datosbar.append([id,ingredientes,tipoplato,disponible])
        elif id > 60 and id <= 100:
            datosrestaurante.append([id,menurestaurante,ingredientes,modalidad])

        datosconsumo.append([id,fecha,desripcion,preciounitario,cantidad,total,servicio_id,reserva_id,cliente_id])
        if id < 1001:
         datoshabitacion.append([id,cantidad,dotacion,estado,preciounitario,plandeconsumoid,tipo_habitacion_id])
        if id < 501:
         datosplandeconsumo.append([id,descuento,descripcion,nombredescuento])
        datosreserva.append([id,fechaentrada,fechasalida,cantidad,estadoreserva,cliente_id])
        datosreservahabitaciones.append([numero_habitacion,reserva_id])
        datosreservaspa.append([id,fechareservaspa,cliente_id,numero_habitacion])
        datostipohabitacion.append([id,nombre_hab,dotacion])
        datostipousuario.append([1,"Empleado",30])
        datostipousuario.append([2,"Cliente",7500000])
        datostipousuario.append([1,"Gerente",2])
        datosusanservicios.append([cliente_id,servicio_id])
        datosusanspa.append([SPAid,reservaspaid])
        

    # Escribir los datos en el archivo CSV
    with open("cliente.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposCliente)
        escritor.writerows(datoscliente)

    with open("consumo.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposCONSUMO)
        escritor.writerows(datosconsumo)

    with open("reserva.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposreserva)
        escritor.writerows(datosreserva)

    with open("usuario.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposusuario)
        escritor.writerows(datosusuario)

    with open("habitacion.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposhabitacion)
        escritor.writerows(datoshabitacion)

    with open("plandeconsumo.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposplandeconsumo)
        escritor.writerows(datosplandeconsumo)

    with open("reservanhabitaciones.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposreservanhabitaciones)
        escritor.writerows(datosreservahabitaciones)

    with open("reservaspa.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposreservaspa)
        escritor.writerows(datosreservaspa)

    with open("servicio.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposservicio)
        escritor.writerows(datosservicio)

    with open("spa.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposspa)
        escritor.writerows(datosspa)

    with open("usanservicios.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposusanservicios)
        escritor.writerows(datosusanservicios)

    with open("usanspa.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposusanspa)
        escritor.writerows(datosusanspa)

    with open("restaurante.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposrestaurante)
        escritor.writerows(datosrestaurante)

    with open("bar.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(camposbar)
        escritor.writerows(datosbar) 

    with open("tipousuario.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(campostipousuario)
        escritor.writerows(datostipousuario)

    with open("tipohabitacion.csv", "w", newline="") as archivo:
        escritor = csv.writer(archivo)
        escritor.writerow(campostipohabitacion)
        escritor.writerows(datostipohabitacion) 

        

    

def generar_fecha_aleatoria():
    Año =random.randint(2002, 2023)  # Fecha inicial para generar valores aleatorios
    Mes = random.randint(1, 12)  # Generar un número aleatorio de días
    Dia = random.randint(1,28) # Crear un delta de tiempo con los días aleatorios
    
    return (Año,Mes,Dia)

print(generar_fecha_aleatoria())



generarReservas("Reservas_Ejemplo.csv",750000) 


