% Aventura Conversacional

:- dynamic estoy/1, tieneitem/2, tienemonedas/2, tengo/2.

estoy(inicio).

haypuerta(inicio, lobby).
haypuerta(lobby, inicio).
haypuerta(lobby, sala).
haypuerta(sala, lobby).
haypuerta(sala, corredor).
haypuerta(corredor, sala).
haypuerta(corredor, cocina).
haypuerta(cocina, corredor).
haypuerta(cocina, patio).
haypuerta(patio, cocina).

mover(Des):- estoy(Org), haypuerta(Org, Des),
retract(estoy(Org)), asserta(estoy(Des)),
write("Caminé y ahora estoy en: "), write(Des).

desc(inicio):- write("Me encuentro ante la entrada de una mansión siniestra"), 
nl, write("y hay un puesto ambulante de bisuteria al lado").

desc(lobby):- write("Parece que hay un salón polvoriento dándome la bienvenida").

desc(sala):- write("Hay varios sillones cubiertos con mantas blancas").

desc(corredor):- write("Hay fotos polvosas colgadas a lo largo del corredor").

desc(cocina):- write("Hay trastes sucios, una alacena vacía y mucho polvo").

desc(patio):- write("Tiene una piscina vacía y el pasto curiosamente está verde").

mirar:- estoy(Hab), desc(Hab).

item(llave).
item(moneda).

tieneitem(corredor, llave).
tieneitem(cocina, moneda).

hayitem(Item):- estoy(Pos), tieneitem(Pos, Item).

tomar(Item):- estoy(Hab), tieneitem(Hab, Item),
retract(tieneitem(Hab, Item)), asserta(tieneitem(usuario, Item)),
write("Has tomado la "), write(Item).

dejar(Item):- tieneitem(usuario, Item), estoy(Hab),
retract(tieneitem(usuario, Item)), asserta(tieneitem(Hab, Item)),
write("Dejaste la "), write(Item), write(" en "), write(Hab).

tienemonedas(lobby, 3).
tienemonedas(patio, 5).
tienemonedas(corredor, 5).

haymonedas:- estoy(Hab), tienemonedas(Hab, Cant), 
write("Hay "), write(Cant), write(" monedas en esta habitación").

tengo(monedas, 0).
tengo(llave, 0).
tengo(joya, 0).

recolectar(M):- estoy(Hab), tienemonedas(Hab, X), tengo(monedas, Y),
Resta is X - M, X > 0,
retract(tienemonedas(Hab, X)), asserta(tienemonedas(Hab, Resta)),
Suma is Y + M,
retract(tengo(monedas, Y)), asserta(tengo(monedas, Suma)).

costo(llave, 7).
costo(joya, 3).

comprar:- estoy(inicio), write("llave - 7 monedas"), nl, write("joya - 3 monedas").

comprar(Item):- estoy(inicio), tengo(monedas, X), tengo(Item, Y), costo(Item, C),
Comp is X - C, X >= C,
retract(tengo(monedas, X)), asserta(tengo(monedas, Comp)),
Inv is Y + 1,
retract(tengo(Item, Y)), asserta(tengo(Item, Inv)).

