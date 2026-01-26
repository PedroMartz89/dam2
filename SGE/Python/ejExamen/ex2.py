import random


def generar_ciudad(filas, columnas):

    matriz = []
    for i in range(filas):
        fila = []
        for j in range(columnas):
            fila.append("SANO")
        matriz.append(fila)

    fila_infectar = random.randint(0, filas-1)
    colum_infectar = random.randint(0, columnas-1)
    matriz[fila_infectar][colum_infectar] = "I-0"
    return matriz


def mostrar_ciudad(matriz):
    for fila in matriz:
        print(fila)


def contagiar(matriz):
    dia = 1
    fila = len(matriz)
    col = len(matriz[0])
    condicion = "SANO"
    while any(condicion in fila for fila in matriz):
        for i in range(fila):
            for j in range(col):
                if matriz[i][j] != "SANO":
                    # verifica la casilla de arriba arriba
                    if i - 1 >= 0 and matriz[i - 1][j] == "SANO": # PRIMERO SE VERIFICA QUE LA CASILLA ES VÁLIDA
                        matriz[i - 1][j] = f"I-{dia}" # Si no verificas puede dar Index out Exception
                        # Abajo
                    if i + 1 < fila and matriz[i + 1][j] == "SANO":
                        matriz[i + 1][j] = f"I-{dia}"
                        # Izquierda
                    if j - 1 >= 0 and matriz[i][j - 1] == "SANO":
                        matriz[i][j - 1] = f"I-{dia}"
                        # Derecha
                    if j + 1 < col and matriz[i][j + 1] == "SANO":
                        matriz[i][j + 1] = f"I-{dia}"
        dia += 1
        mostrar_ciudad(matriz)

    return dia

dias = contagiar(generar_ciudad(4,4))
print(f"Días para contagiar a todos: {dias}")