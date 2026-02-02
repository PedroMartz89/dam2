import random


def configurar_juego():
    filas = int(input("Introduce el número de filas (>=3): "))
    colum = int(input("Introduce el número de columnas (>=3): "))
    correcto = False
    jugadores = 0
    while not correcto:
        jugadores = int(input("Introduce el número de jugadores (2, 3): "))
        if 2 <= jugadores <= 3:
            correcto = True
    d = {"filas": filas, "columnas":colum, "NJugadores": jugadores}
    return d

def jugadores(d):
    numJugadores = d["NJugadores"]
    dicJugadores = {}
    adicionNombre = 2
    for i in range(1, numJugadores+1):
        nombre = str(input(f"Introduce el nombre del jugador {i}: "))
        if nombre in dicJugadores.keys():
            nombre = f"{nombre}{adicionNombre}"
            adicionNombre += 1
        filaRandom = random.randint(0, d["filas"] - 1)
        colRandom = random.randint(0, d["columnas"] - 1)
        while filaRandom in dicJugadores:
            filaRandom = random.randint(0, d["filas"] - 1)
        while colRandom in dicJugadores:
            colRandom = random.randint(0, d["columnas"] - 1)

        dicJugadores[nombre] = (filaRandom, colRandom)
    return dicJugadores

def tablero_juego(dic_gestion, dic_jugadores):
    filas = dic_gestion["filas"]
    colum = dic_gestion["columnas"]
    valores = dic_jugadores.values()
    matriz = []
    for i in range(filas):
        fila = []
        for j in range(colum):
            fila.append("-")
        matriz.append(fila)

    for i in range(filas):
        for j in range(colum):
            actual = (i,j)
            if actual in valores:
                for clave, valor in dic_jugadores.items():
                    if valor[0] == actual[0] and valor[1] == actual[1]:
                        matriz[i][j] = clave
    return matriz

def mostrar_juego(matriz_tablero):
    for fila in matriz_tablero:
        print(fila)


def jugar(matriz_tablero, dic_jugadores):
    fila = len(matriz_tablero)
    colum = len(matriz_tablero[0])
    dic_cabezas = dic_jugadores
    dic_total_movimientos = {}
    continuar = True
    while continuar:
        for i in range(fila):
            for j in range(colum):
                if (i, j) in dic_cabezas.values():
                    actual = matriz_tablero[i][j]
                    # arriba
                    if 0 <= i-1 < fila:
                        arriba = matriz_tablero[i-1][j]
                        if arriba == '-':
                            matriz_tablero[i-1][j] = actual
                            dic_cabezas[actual] = (i-1, j)
                            if actual not in dic_total_movimientos:
                                dic_total_movimientos[actual] = 1
                            else:
                                dic_total_movimientos[actual] =+ 1
                        break
                    # derecha
                    if 0 <= j+1 < colum:
                        derecha = matriz_tablero[i][j+1]
                        if derecha == "-":
                            matriz_tablero[i][j+1] = actual
                            dic_cabezas[actual] = (i, j+1)
                            if actual not in dic_total_movimientos:
                                dic_total_movimientos[actual] = 1
                            else:
                                dic_total_movimientos[actual] =+ 1
                        break
                    # abajo
                    if 0 <= i + 1 < fila:
                        abajo = matriz_tablero[i + 1][j]
                        if abajo == "-":
                            matriz_tablero[i + 1][j] = actual
                            dic_cabezas[actual] = (i + 1, j)
                            if actual not in dic_total_movimientos:
                                dic_total_movimientos[actual] = 1
                            else:
                                dic_total_movimientos[actual] =+ 1
                        break
                    # izquierda
                    if 0 <= j - 1 < colum:
                        izquierda = matriz_tablero[i][j - 1]
                        if izquierda == "-":
                            matriz_tablero[i][j - 1] = actual
                            dic_cabezas[actual] = (i, j - 1)
                            if actual not in dic_total_movimientos:
                                dic_total_movimientos[actual] = 1
                            else:
                                dic_total_movimientos[actual] =+ 1
                        break

            mostrar_juego(matriz_tablero)
            print("==========================")
            input("Pulsa enter para continuar")

dic_gestion = configurar_juego()
dic_jugadores = jugadores(dic_gestion)
matriz_tablero = tablero_juego(dic_gestion, dic_jugadores)
jugar(matriz_tablero, dic_jugadores)