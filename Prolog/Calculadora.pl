% Calculadora con un valor asignado.

valor(5).

sumar(N):- valor(V), R is V + N, write('Resultado: '), write(R).

restar(N):- valor(V), R is V - N, write('Resultado: '), write(R).

multiplicar(N):- valor(V), R is V * N, write('Resultado: '), write(R).
