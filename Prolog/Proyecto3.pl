% Cadena de ensamblaje de una empresa automovilística

:- dynamic presupuestoInicial/1, tiempoMaximo/1.
:- dynamic presupuestoActual/1, tiempoDisponible/1.
:- dynamic costoTotal/1, tiempoTotal/1.
:- dynamic dineroSobrante/1, tiempoSobrante/1.
:- dynamic estoy/1.

/* Opciones de ensamble de cada isla en el orden: 
        isla, ensamble, precio */
ensamble(islaA, deportivo, 10000).
ensamble(islaA, ciudad, 7000).

ensamble(islaB, alerones, 7000).
ensamble(islaB, stickers, 3000).
ensamble(islaB, escape, 10000).

ensamble(islaC, baseNormal, 5000).
ensamble(islaC, baseCromo, 10000).
ensamble(islaC, baseMetal, 20000).

ensamble(islaD, v4, 20000).
ensamble(islaD, v6, 50000).
ensamble(islaD, v8, 80000).

ensamble(islaE, azulCaribe, 20000).
ensamble(islaE, rossoCorsa, 70000).
ensamble(islaE, grisOxford, 50000).

ensamble(islaF, pantallaNormal, 3000).
ensamble(islaF, pantallaiTouch, 7000).
ensamble(islaF, sistemaiCar, 15000).

ensamble(islaG, ac, 30000).
ensamble(islaG, noAC, 10000).

ensamble(islaH, airbags4, 20000).
ensamble(islaH, airbags6, 30000).

ensamble(islaI, testNormal, 3000).
ensamble(islaI, tanqueLleno, 5000).

/* Conocer las opciones de ensamble de una isla */
opcionesIsla:- estoy(Isla), ensamble(Isla, Opcion, Precio),
    write(Isla), write(": "), write(Opcion), write(" por "), write(Precio).

/* Enlaces entre islas en el orden: 
    origen, destino, minutos*/
enlace(islaA, islaB, 15).
enlace(islaA, islaB, 20).
enlace(islaA, islaC, 10).

enlace(islaB, islaD, 15).

enlace(islaC, islaD, 15).
enlace(islaC, islaD, 20).

enlace(islaD, islaE, 10).
enlace(islaD, islaE, 15).
enlace(islaD, islaE, 20).

enlace(islaE, islaF, 15).
enlace(islaE, islaH, 10).

enlace(islaF, islaG, 10).
enlace(islaF, islaG, 15).

enlace(islaG, islaI, 15).

enlace(islaH, islaI, 10).
enlace(islaH, islaI, 15).

/* Saber a qué isla puedo ir y en cuánto tiempo */
puedoIrA:- estoy(Isla), enlace(Isla, OtraIsla, Tiempo),
    write(OtraIsla), write(" en "), write(Tiempo), write(" minutos").

/* Hechos iniciales */
presupuestoInicial(0).
tiempoMaximo(0).
presupuestoActual(0).
tiempoDisponible(0).
costoTotal(0).
tiempoTotal(0).
dineroSobrante(0).
tiempoSObrante(0).
estoy(islaA).

/* Reduccion de costo de acuerdo al tiempo */
reduccion(10, 0).
reduccion(15, 1000).
reduccion(20, 3000).

/* Manejo de cantidades*/
asignarCantidad(Dinero, Tiempo):- presupuestoInicial(PI), tiempoMaximo(TM), 
    presupuestoActual(PA), tiempoDisponible(TD),
    retract(presupuestoInicial(PI)), asserta(presupuestoInicial(Dinero)),
    retract(tiempoMaximo(TM)), asserta(tiempoMaximo(Tiempo)),
    retract(presupuestoActual(PA)), asserta(presupuestoActual(Dinero)),
    retract(tiempoDisponible(TD)), asserta(tiempoDisponible(Tiempo)).

cantidadRestante:- presupuestoActual(PA), tiempoDisponible(TD),
    write("Dinero restante: "), write(PA), nl,
    write("Minutos restantes: "), write(TD).

cantidadTotal:- costoTotal(CT), tiempoTotal(TT),
    write("Costo total: "), write(CT), nl,
    write("Tiempo total: "), write(TT).

/* TODO: revisar por qué no funciona */
cantidadSobrante:- dineroSobrante(DS), tiempoSobrante(TS), 
    write("Dinero sobrante: "), write(DS), nl,
    write("Tiempo sobrante: "), write(TS).

elegir(Ensamble):- estoy(Isla), ensamble(Isla, Ensamble, Precio),
    presupuestoActual(PA), costoTotal(CT), PA >= Precio, 
    ResPA is PA - Precio, SumCT is CT + Precio,
    retract(presupuestoActual(PA)), asserta(presupuestoActual(ResPA)),
    retract(costoTotal(CT)), asserta(costoTotal(SumCT)).

/* FIXME: agregar las reducciones de dinero */
/* Mover de isla */
mover(Des, Min):- estoy(Org), enlace(Org, Des, Min), reduccion(Min, Dinero),
    presupuestoActual(PA), costoTotal(CT), tiempoDisponible(TD), tiempoTotal(TT),
    TD >= Min, 
    retract(estoy(Org)), asserta(estoy(Des)),

    ResTD is TD - Min, 
    retract(tiempoDisponible(TD)), asserta(tiempoDisponible(ResTD)),

    SumTT is TT + Min, 
    retract(tiempoTotal(TT)), asserta(tiempoTotal(SumTT)),
    
    SumPA is PA + Dinero,
    retract(presupuestoActual(PA)), asserta(presupuestoActual(SumPA)),

    ResCT is CT - Dinero,
    retract(costoTotal(CT)), asserta(costoTotal(ResCT)).


/* FIXME: asignar sobrante automaticamente al final */
/* TODO: revisar por qué no funciona */
asignarSobrante:- estoy(islaI), presupuestoActual(PA), dineroSobrante(DS),
    retract(dineroSobrante(DS)), asserta(dineroSobrante(PA)),
    tiempoDisponible(TD), tiempoSobrante(TS),
    retract(tiempoSobrante(TS)), asserta(tiempoSobrante(TD)).
