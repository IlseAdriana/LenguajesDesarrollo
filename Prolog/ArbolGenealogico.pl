% Árbol genealógico de los simpsons

mujer(mona).
mujer(jackie).
mujer(marge).
mujer(lisa).
mujer(maggie).
mujer(selma).
mujer(paty).
hombre(abraham).
hombre(clancy).
hombre(homero).
hombre(bart).
perro(huesos).
gato(boladenieve).

es_hijo(homero, abraham).
es_hijo(homero, mona).
es_hijo(marge, jackie).
es_hijo(selma, jackie).
es_hijo(paty, jackie).
es_hijo(marge, clancy).
es_hijo(selma, clancy).
es_hijo(paty, clancy).
es_hijo(bart, homero).
es_hijo(lisa, homero).
es_hijo(maggie, homero).
es_hijo(bart, marge).
es_hijo(lisa, marge).
es_hijo(maggie, marge).

es_nieto(N, A):- es_hijo(N, P), es_hijo(P, A).

es_hermano(H1, H2):- es_hijo(H1, P), es_hijo(H2, P), H1 \= H2.

es_sobrino(S, T):- es_hijo(S, P), es_hermano(P, T).

es_papa(P, H):- hombre(P), es_hijo(H, P).

es_mama(M, H):- mujer(M), es_hijo(H, M).

esta_casado(E1, E2):- es_mama(E1, H), es_papa(E2, H) ; es_mama(E2, H), es_papa(E1, H).

es_suegro(S, Y):- es_hijo(E, S), esta_casado(Y, E).

